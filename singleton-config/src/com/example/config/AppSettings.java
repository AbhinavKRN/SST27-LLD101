package com.example.config;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

/**
 * Thread-safe singleton configuration manager.
 * 
 * Key features:
 * - Lazy initialization (only created when first accessed)
 * - Thread-safe using double-checked locking
 * - Reflection attack protection
 * - Serialization safety (returns same instance)
 * - Immutable after loading (loadFromFile can only be called once)
 */
public class AppSettings implements Serializable {
    private static volatile AppSettings instance;
    private static final Object lock = new Object();
    
    private volatile boolean isLoaded = false;
    private final Properties props = new Properties();
    
    private AppSettings() {
        if (instance != null) {
            throw new RuntimeException("Use getInstance() to get the singleton instance");
        }
    }
    
    /**
     * Gets the singleton instance with lazy initialization.
     * Uses double-checked locking for thread safety.
     */
    public static AppSettings getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new AppSettings();
                }
            }
        }
        return instance;
    }
    
    /**
     * Loads configuration from file. Can only be called once.
     * Thread-safe and prevents multiple loads.
     */
    public void loadFromFile(Path file) {
        if (isLoaded) {
            throw new IllegalStateException("Configuration already loaded. Cannot reload.");
        }
        
        synchronized (lock) {
            if (isLoaded) {
                throw new IllegalStateException("Configuration already loaded. Cannot reload.");
            }
            
            try (InputStream in = Files.newInputStream(file)) {
                props.load(in);
                isLoaded = true;
            } catch (IOException e) {
                throw new UncheckedIOException("Failed to load configuration from " + file, e);
            }
        }
    }
    
    /**
     * Gets a configuration value by key.
     * Returns null if key doesn't exist or config not loaded.
     */
    public String get(String key) {
        if (!isLoaded) {
            throw new IllegalStateException("Configuration not loaded yet. Call loadFromFile() first.");
        }
        return props.getProperty(key);
    }
    

    public boolean isLoaded() {
        return isLoaded;
    }
    
    private Object readResolve() throws ObjectStreamException {
        return getInstance();
    }
}
