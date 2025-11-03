package com.cheq.demo_webshop.utils;

import java.io.FileReader;
import java.io.IOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JSONReader {
    private JsonObject jsonObject;

    // Constructor that loads the JSON file
    public JSONReader(String filename) {
        try {
            String path = System.getProperty("user.dir") + "/src/test/resources/testdata/" + filename;
            FileReader reader = new FileReader(path);
            jsonObject = JsonParser.parseReader(reader).getAsJsonObject();
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException("Failed to load JSON test data: " + e.getMessage());
        }
    }

    // Retrieve data by key
    public String getValue(String userType, String key) {
        return jsonObject.getAsJsonObject(userType).get(key).getAsString();
    }
}
