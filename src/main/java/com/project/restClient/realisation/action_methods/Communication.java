package com.project.restClient.realisation.action_methods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Communication {

    private static final String PUBLIC_KEY = "8ef537ef8f5718b7c642c8dea68ef197";
    private static final String PRIVATE_KEY = "66986b5ce7827d594561a0f852fe63f713499773";
    long ts = System.currentTimeMillis();


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
        String hash = null;
        try {
            hash = generateHash(ts, PRIVATE_KEY, PUBLIC_KEY);
        } catch (NoSuchAlgorithmException e) {
        }
        return String.format("http://gateway.marvel.com/v1/public/comics?ts=%d&apikey=%s&hash=%s", ts, PUBLIC_KEY, hash);
    }
}
