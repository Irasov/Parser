package com.epam.irasov.parser.logic;

import com.epam.irasov.parser.entity.*;

import java.util.ArrayList;
import java.util.List;

public class WordsSearch {

    public static List<SentencePart> sentenceWords(List<Paragraph> paragraphs, int paragraphNumber, int sentenceNumber) {
        Sentence sentence;
        List<SentencePart> wordsSentence = new ArrayList<SentencePart>();
        sentence = paragraphs.get(paragraphNumber).getElements().get(sentenceNumber);
        for (SentencePart w : sentence.getElements()) {
            if (w.getType() == SentencePart.SentencePartType.WORD)
                wordsSentence.add(w);
        }
        return wordsSentence;
    }

    public static List<SentencePart> textWordsNotConsiderOnSentence(List<Paragraph> paragraphs, int paragraphNumber, int sentenceNumber){
        List<SentencePart> wordsSentences = new ArrayList<SentencePart>();
        for (Paragraph p : paragraphs) {
            for (Sentence s : p.getElements()) {
                if (s != paragraphs.get(paragraphNumber).getElements().get(sentenceNumber)) {
                    for (SentencePart w : s.getElements()) {
                        if (w.getType() == SentencePart.SentencePartType.WORD)
                            wordsSentences.add(w);
                    }
                }
            }
        }

        return wordsSentences;
    }


    public static List<SentencePart> uniqueWordsSearch(List<SentencePart> w, List<SentencePart> ww) {
        List<SentencePart> foundWords = new ArrayList<SentencePart>();
        for(SentencePart ss1 : w) {
            if(!ww.contains(ss1)){
                foundWords.add(ss1);
            }
        }
        return foundWords;
    }
}
