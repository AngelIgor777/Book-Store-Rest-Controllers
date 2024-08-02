package com.project.backend.util;

import java.io.InputStream;
import java.util.Properties;

public final class PropertiesUtil {

    private static final Properties PROPERTIES = new Properties();

    static {
        loadproperties();
    }

    public static String getProperty(String key)    {
        return PROPERTIES.getProperty(key);
    }

    private static void loadproperties() {
        try (InputStream inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream("application.properties")) {
            PROPERTIES.load(inputStream);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private PropertiesUtil() {

    }
}
