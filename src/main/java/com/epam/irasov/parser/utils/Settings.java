package com.epam.irasov.parser.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Settings {

    private static Settings instance = null;
    private Properties props = new Properties();
    private static final String FILE_NAME_SETTINGS = "settings.properties";

    private Settings() {

    }

    public void loadSettings() throws IOException {
        InputStream stream = Settings.class.getClassLoader().getResourceAsStream(FILE_NAME_SETTINGS);
        props.load(stream);
    }

    public static Settings getInstance() {
        if (instance == null) {
            instance = new Settings();
        }
        return instance;
    }

    public String getProperties(String key) {
        return props.getProperty(key);
    }
}
