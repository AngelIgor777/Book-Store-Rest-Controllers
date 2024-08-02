package com.project.backend.action_methods;

import com.project.backend.entity.characters.Character;
import com.project.backend.entity.characters.CharacterDataWrapper;
import com.project.backend.entity.comics.Comic;
import com.project.backend.entity.comics.ComicDataWrapper;
import com.project.backend.util.PropertiesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.core.ParameterizedTypeReference;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Component
public class CommunicationImpl implements Communication {
    private RestTemplate restTemplate;

    @Autowired
    public CommunicationImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private static final String PUBLIC_KEY = "url.public.key";
    private static final String PRIVATE_KEY = "url.private.key";
    long ts = System.currentTimeMillis();
    String hash = null;

    public List<Character> getAllCharacters() {
        ResponseEntity<CharacterDataWrapper> responseEntity =
                restTemplate.exchange(getUrl(UrlTypes.CHARACTERS), HttpMethod.GET, null, new ParameterizedTypeReference<CharacterDataWrapper>() {
                });
        return responseEntity.getBody().getData().getResults();
    }

    public List<Comic> getAllComics() {
        ResponseEntity<ComicDataWrapper> responseEntity =
                restTemplate.exchange(getUrl(UrlTypes.COMICS), HttpMethod.GET, null, new ParameterizedTypeReference<ComicDataWrapper>() {
                });
        return responseEntity.getBody().getData().getResults();
    }

    private static String generateHash(long ts, String privateKey, String publicKey) throws NoSuchAlgorithmException {
        String valueToHash = ts + privateKey + publicKey;
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hashBytes = md.digest(valueToHash.getBytes(StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        for (byte b : hashBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public String getUrl(UrlTypes urlType) {
        try {
            hash = generateHash(ts, PropertiesUtil.getProperty(PRIVATE_KEY), PropertiesUtil.getProperty(PUBLIC_KEY));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        switch (urlType) {
            case COMICS:
                return String.format("http://gateway.marvel.com/v1/public/comics?ts=%d&apikey=%s&hash=%s", ts, PropertiesUtil.getProperty(PUBLIC_KEY), hash);
            case CHARACTERS:
                return String.format("http://gateway.marvel.com/v1/public/characters?ts=%d&apikey=%s&hash=%s", ts, PropertiesUtil.getProperty(PUBLIC_KEY), hash);
            default:
                return "Incorrect url type";
        }
    }


}
