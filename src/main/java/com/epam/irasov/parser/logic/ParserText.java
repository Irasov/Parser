package com.epam.irasov.parser.logic;

import com.epam.irasov.parser.entity.*;
import com.epam.irasov.parser.utils.FileOperation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserText {

    public Text parse(String textFile) {
        Text text = new Text();
        String[] textParagraphs = textFile.split("\n");
        for (String textParagraph : textParagraphs) {
            text.add(parseParagraph(textParagraph));
        }
        return text;
    }


    public Paragraph parseParagraph(String textParagraph) {
        Paragraph paragraph = new Paragraph();
        String[] textSentences = textParagraph.split("(?<=[.!?]) ");
        for (String textSentence : textSentences) {
            paragraph.add(parseSentence(textSentence));
        }
        return paragraph;
    }

    public Sentence parseSentence(String textSentence) {
        String regexPart = ("\\w+?(\\p{Punct}|\\p{Blank})?(\\p{Punct}|\\p{Blank})");
        Pattern pPart = Pattern.compile(regexPart);
        Matcher mPart = pPart.matcher(textSentence);
        String regexSymbol = ("(\\p{Punct})|(\\p{Blank})");
        Pattern pSymbol = Pattern.compile(regexSymbol);
        Sentence sentence = new Sentence();
        while(mPart.find()){
            sentence.add(parseWord(mPart.group().substring(0, mPart.group().length() - 1)));
            Matcher mSymbol = pSymbol.matcher(mPart.group());
            while(mSymbol.find()){
                sentence.add(parsePartSentence(mSymbol.group()));
            }

        }
        return sentence;
    }

    private SentencePart parseWord(String textWord) {
        String regexPart = ("\\w");
        Pattern pPart = Pattern.compile(regexPart);
        Matcher mPart = pPart.matcher(textWord);
        Word word = new Word(SentencePart.SentencePartType.WORD);
        while(mPart.find()){
            word.addLetter((Symbol) parsePartSentence(mPart.group()));
        }
        return word;
    }

    private SentencePart parsePartSentence(String textPartSentence) {
        Symbol symbol;
        String regexPart = ("\\w");
        Pattern pPart = Pattern.compile(regexPart);
        Matcher mPart = pPart.matcher(textPartSentence);
        if (mPart.find()) {
            symbol = new Symbol(mPart.group(), SentencePart.SentencePartType.LETTER);
            return symbol;
        }
        regexPart = ("\\p{Punct}");
        pPart = Pattern.compile(regexPart);
        mPart = pPart.matcher(textPartSentence);
        if (mPart.find()) {
            symbol = new Symbol(mPart.group(), SentencePart.SentencePartType.PUNCTUATION);
            return symbol;
        } else {
            symbol = new Symbol(textPartSentence, SentencePart.SentencePartType.SPACEORTAB);
            return symbol;
        }
    }
}
