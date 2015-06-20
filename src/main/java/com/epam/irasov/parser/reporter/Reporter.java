package com.epam.irasov.parser.reporter;

import com.epam.irasov.parser.entity.SentencePart;

import java.util.List;

public class Reporter {
    public static void printFoundWords(List<SentencePart> foundWords){
        StringBuilder sb = new StringBuilder();
        if(!foundWords.isEmpty()) {
            for (SentencePart word : foundWords) {
                sb.append(word.buildOriginalString()).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
