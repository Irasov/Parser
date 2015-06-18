package com.epam.irasov.parser.utils;

import java.io.InputStream;
import java.util.Scanner;

public class FileOperation {
    public static String fileRead() {
        StringBuilder text = new StringBuilder();
        InputStream in = FileOperation.class.getClassLoader().getResourceAsStream("page.txt");
        Scanner scanner = new Scanner(in, "UTF-8");
        scanner.useDelimiter("Z");
        text.append(scanner.next());
        scanner.close();
        return text.toString();
    }
}
