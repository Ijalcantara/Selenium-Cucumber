package com.cheq.demo_webshop.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static final Properties properties = new Properties();
    private Properties property;

    public static void loadProperties(String env) {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/config/" + env + ".properties");
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Unable to load environment config: " + env, e);
        }
    }

    public Properties initProperty(String env) {
        property = new Properties();
        String configFilePath = System.getProperty("user.dir") + "src/test/resources/config/" + env + ".properties";
        try (FileInputStream ip = new FileInputStream(configFilePath)) {
            property.load(ip);
        } catch (FileNotFoundException e) {
            System.err.println("Config file not found: " + configFilePath);
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Error loading config file: " + e.getMessage());
            e.printStackTrace();
        }

        return property;
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}