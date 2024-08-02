package com.project.backend.action_methods;

import com.project.backend.entity.characters.Character;
import com.project.backend.entity.characters.CharacterDataContainer;
import com.project.backend.entity.characters.CharacterDataWrapper;
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
public class Communication {
    private RestTemplate restTemplate;

    @Autowired
    public Communication(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private static final String PUBLIC_KEY = "url.public.key";
    private static final String PRIVATE_KEY = "url.private.key";
    long ts = System.currentTimeMillis();
    String hash = null;

    public List<Character> getAllCharacters() {
        ResponseEntity<CharacterDataWrapper> responseEntity =
                restTemplate.exchange(getCharactersUrl(), HttpMethod.GET, null, new ParameterizedTypeReference<CharacterDataWrapper>() {});
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

    public String getUrl() {
        try {
            hash = generateHash(ts, PropertiesUtil.getProperty(PRIVATE_KEY), PropertiesUtil.getProperty(PUBLIC_KEY));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return String.format("http://gateway.marvel.com/v1/public/comics?ts=%d&apikey=%s&hash=%s", ts, PropertiesUtil.getProperty(PUBLIC_KEY), hash);
    }

    public String getCharactersUrl() {
        try {
            hash = generateHash(ts, PropertiesUtil.getProperty(PRIVATE_KEY), PropertiesUtil.getProperty(PUBLIC_KEY));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();  // Логируйте исключение
        }
        String format = String.format("http://gateway.marvel.com/v1/public/characters?ts=%d&apikey=%s&hash=%s", ts, PropertiesUtil.getProperty(PUBLIC_KEY), hash);
        System.out.println(format);
        return format;
    }

}
