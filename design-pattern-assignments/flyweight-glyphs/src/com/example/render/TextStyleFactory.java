package com.example.render;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TextStyleFactory {
    private final Map<String, TextStyle> cache = new HashMap<>();

    public TextStyle getTextStyle(String font, int size, boolean bold) {
        Objects.requireNonNull(font, "font");
        
        // Create key in format: "font|size|B" or "font|size|N"
        String key = font + "|" + size + "|" + (bold ? "B" : "N");
        
        return cache.computeIfAbsent(key, k -> new TextStyle(font, size, bold));
    }

    public int getCacheSize() {
        return cache.size();
    }
}
