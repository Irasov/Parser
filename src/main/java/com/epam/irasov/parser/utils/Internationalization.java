package com.epam.irasov.parser.utils;

import java.util.Locale;
import java.util.ResourceBundle;

public class Internationalization {
    private static Internationalization instance = null;
    ResourceBundle resourceBundle;
    Locale locale;
    String baseName;

    private Internationalization() {
    }

    public static Internationalization getInstance() {
        if (instance == null) {
            instance = new Internationalization();
        }
        return instance;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }


    public Locale getLocale() {
        return this.locale;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }

    public String getBaseName() {
        return this.baseName;
    }

    public ResourceBundle getResourceBundle() {
        return ResourceBundle.getBundle(baseName,locale);
    }

    public String getInternationalization(String key) {
        return Internationalization.getInstance().getResourceBundle().getString(key);
    }
}
