package com.epam.irasov.parser.logic;

import com.epam.irasov.parser.entity.*;

import java.util.ArrayList;
import java.util.List;

public class SearchWords {

    public static List<SentencePart> sentenceWords(List<Paragraph> paragraphs, int paragraphNumber, int sentenceNumber) {
        Sentence sentence;
        List<SentencePart> wordsSentence = new ArrayList<SentencePart>();
        sentence = paragraphs.get(paragraphNumber).getPart().get(sentenceNumber);
        for (SentencePart w : sentence.getPart()) {
            if (w.getType() == SentencePart.SentencePartType.WORD)
                wordsSentence.add(w);
        }
        return wordsSentence;
    }

    public static List<SentencePart> sentenceWordsNotConsiderOnSentence(List<Paragraph> paragraphs, int paragraphNumber, int sentenceNumber){
        List<SentencePart> wordsSentences = new ArrayList<SentencePart>();
        for (Paragraph p : paragraphs) {
            for (Sentence s : p.getPart()) {
                if (s != paragraphs.get(paragraphNumber).getPart().get(sentenceNumber)) {
                    for (SentencePart w : s.getPart()) {
                        if (w.getType() == SentencePart.SentencePartType.WORD)
                            wordsSentences.add(w);
                    }
                }
            }
        }

        return wordsSentences;
    }


    public static List<SentencePart> foundWords(List<SentencePart> w,List<SentencePart> ww) {
        List<SentencePart> foundWords = new ArrayList<SentencePart>();
        for (SentencePart ss1 : w) {
            int repetitionWords = 0;
            for (SentencePart ss2 : ww) {
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
