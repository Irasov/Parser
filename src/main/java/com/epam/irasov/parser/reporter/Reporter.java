package com.epam.irasov.parser.reporter;

import java.util.List;

public class Reporter {
    public static void printFoundWords(List<String> foundWords){
        StringBuilder sb = new StringBuilder();
        if(!foundWords.isEmpty()) {
            for (String word : foundWords) {
                sb.append(word).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
