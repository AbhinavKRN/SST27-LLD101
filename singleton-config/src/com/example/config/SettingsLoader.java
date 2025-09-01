package com.example.config;

import java.nio.file.Path;


public class SettingsLoader {
    

    public AppSettings load(Path file) {
        AppSettings settings = AppSettings.getInstance();
        settings.loadFromFile(file);
        return settings;
    }
    

    public void loadIntoExisting(Path file) {
        AppSettings.getInstance().loadFromFile(file);
    }
}
