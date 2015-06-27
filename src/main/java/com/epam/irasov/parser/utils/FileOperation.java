package com.epam.irasov.parser.utils;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.Scanner;

public class FileOperation {
    private static Logger LOGGER = Logger.getLogger(FileOperation.class);

    public static String fileRead(String stringText) {
        StringBuilder text = new StringBuilder();
        try {
            BufferedReader out = new BufferedReader(new InputStreamReader(new FileInputStream(stringText), "UTF-8"));
            text.append(out.read());
            out.close();
        } catch (FileNotFoundException e) {
            LOGGER.info(e);
        } catch (IOException e) {
            LOGGER.error(e);
        }
        return text.toString();
    }

    public static String fileRead() {
        Settings settings = Settings.getInstance();
        try {
            settings.loadSettings();
        } catch (FileNotFoundException e) {
            LOGGER.info(e);
        } catch (IOException e) {
            LOGGER.error(e);
        }
        StringBuilder text = new StringBuilder();
        InputStream in = FileOperation.class.getClassLoader().getResourceAsStream(settings.getProperties("file.input.path"));
        Scanner scanner = new Scanner(in, "UTF-8");
        scanner.useDelimiter("Z");
        text.append(scanner.next());
        scanner.close();
        return text.toString();
    }

    public static void fileWrite(String words, String filename) {
        try {
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), "UTF8"));
            out.write(words);
            out.close();
        } catch (IOException e) {
            LOGGER.error(e);
        }

    }
}
