package com.epam.irasov.parser.logic;

import com.epam.irasov.parser.entity.*;

import java.util.ArrayList;
import java.util.List;

public class SearchWord {
    public static List<String> foundWords(List<Paragraph> paragraphs) {
        List<String> foundWords = new ArrayList<String>();
        List<String> wordsFirstSentence = new ArrayList<String>();
        List<String> wordsSentences = new ArrayList<String>();
        Sentence sentence = paragraphs.get(0).getPart().get(0);
        List<Sentence> sentences = new ArrayList<Sentence>();
        for (SentencePart w : sentence.getPart()) {
            if (w.getType() == SentencePart.SentencePartType.WORD)
                wordsFirstSentence.add(w.buildOriginalString());
        }
        for (Paragraph p : paragraphs) {
            for (Sentence s : p.getPart()) {
                if (s != paragraphs.get(0).getPart().get(0)) {
                    for (SentencePart w : s.getPart()) {
                        if (w.getType() == SentencePart.SentencePartType.WORD)
                            wordsSentences.add(w.buildOriginalString());
                    }
                }
            }
        }
        for (String ss1 : wordsFirstSentence) {
            int repetitionWords = 0;
            for (String ss2 : wordsSentences) {
                if (ss1.equals(ss2)) {
                    repetitionWords++;
                }
            }
            if (repetitionWords == 0) {
                foundWords.add(ss1);
            }
        }
        return foundWords;
    }
}
