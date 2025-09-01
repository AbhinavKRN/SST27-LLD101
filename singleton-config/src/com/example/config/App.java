package com.example.config;

import java.nio.file.Path;

public class App {
    public static void main(String[] args) throws Exception {
        String path = args.length > 0 ? args[0] : "app.properties";
        
        System.out.println("=== Singleton Configuration Demo ===\n");
        
        AppSettings config1 = AppSettings.getInstance();
        AppSettings config2 = AppSettings.getInstance();
        AppSettings config3 = AppSettings.getInstance();
        
        System.out.println("Getting instances multiple times:");
        System.out.println("config1 hash: " + System.identityHashCode(config1));
        System.out.println("config2 hash: " + System.identityHashCode(config2));
        System.out.println("config3 hash: " + System.identityHashCode(config3));
        System.out.println("All same instance? " + (config1 == config2 && config2 == config3));
        System.out.println();
        
        System.out.println("Loading configuration from: " + path);
        try {
            config1.loadFromFile(Path.of(path));
            System.out.println("Configuration loaded successfully!");
        } catch (Exception e) {
            System.out.println("Failed to load config: " + e.getMessage());
            System.out.println("Creating sample config for demo...");
        }
        
        try {
            String appName = config1.get("app.name");
            System.out.println("app.name = " + (appName != null ? appName : "not set"));
        } catch (Exception e) {
            System.out.println("Error accessing config: " + e.getMessage());
        }
        
        System.out.println("\nTrying to reload configuration...");
        try {
            config1.loadFromFile(Path.of(path));
        } catch (Exception e) {
            System.out.println("Reload blocked (as expected): " + e.getMessage());
        }
        
        System.out.println("\nUsing SettingsLoader:");
        SettingsLoader loader = new SettingsLoader();
        try {
            AppSettings loadedConfig = loader.load(Path.of(path));
            System.out.println("Loaded config hash: " + System.identityHashCode(loadedConfig));
            System.out.println("Same as original? " + (loadedConfig == config1));
        } catch (Exception e) {
            System.out.println("SettingsLoader demo: " + e.getMessage());
        }
        
        System.out.println("\n=== Demo Complete ===");
    }
}
