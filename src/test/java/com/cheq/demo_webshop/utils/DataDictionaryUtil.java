package com.cheq.demo_webshop.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DataDictionaryUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final Map<String, JsonNode> dataCache = new HashMap<>();

    /** Loads a JSON file and caches its content if not already loaded. */
    public static void loadJsonFile(String filePath) throws IOException {
        if (!dataCache.containsKey(filePath)) {
            File file = new File(System.getProperty("user.dir") + filePath);
            JsonNode rootNode = objectMapper.readTree(file);
            dataCache.put(filePath, rootNode);
        }
    }

    /** Retrieves a specific data group node from the cached JSON file. */
    public static JsonNode getDataNode(String filePath, String dataGroup) throws IOException {

        JsonNode rootNode = dataCache.get(filePath);
        if (rootNode == null) {
            loadJsonFile(filePath);
            rootNode = dataCache.get(filePath);
        }

        JsonNode dataGroupNode = rootNode.path(dataGroup);
        if (dataGroupNode.isMissingNode()) {
            return null;
        }

        return dataGroupNode;
    }

    /** Clears the cached data to avoid stale values between scenarios. */
    public static void clearDataCache() {
        dataCache.clear();
    }
}