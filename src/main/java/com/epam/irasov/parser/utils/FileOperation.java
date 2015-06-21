package com.epam.irasov.parser.utils;

import java.io.*;
import java.util.Scanner;

public class FileOperation {
    public static String fileRead() {
        Settings settings = Settings.getInstance();
        try {
            settings.loadSettings();
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuilder text = new StringBuilder();
        InputStream in = FileOperation.class.getClassLoader().getResourceAsStream(settings.getProperties("file.input.path"));
        Scanner scanner = new Scanner(in, "UTF-8");
        scanner.useDelimiter("Z");
        text.append(scanner.next());
        scanner.close();
        return text.toString();
    }

    public static void fileWrite(String words, String filename){
        try
        {
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), "UTF8"));
            out.write(words);
            out.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
