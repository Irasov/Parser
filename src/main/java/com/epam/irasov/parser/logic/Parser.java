package com.epam.irasov.parser.logic;

import com.epam.irasov.parser.entity.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    public Text textParsing(String stringText) {
        Text text = new Text();
        String[] textParagraphs = stringText.split("\n");
        for (String textParagraph : textParagraphs) {
            text.add(paragraphParsing(textParagraph));
        }
        return text;
    }


    public Paragraph paragraphParsing(String stringParagraph) {
        Paragraph paragraph = new Paragraph();
        String[] textSentences = stringParagraph.split("(?<=[.!?]) ");
        for (String textSentence : textSentences) {
            paragraph.add(sentenceParsing(textSentence));
        }
        return paragraph;
    }

    public Sentence sentenceParsing(String stringSentence) {
        String regexPart = ("\\w+?(\\p{Punct}|\\p{Blank})?(\\p{Punct}|\\p{Blank})");
        Pattern pPart = Pattern.compile(regexPart);
        Matcher mPart = pPart.matcher(stringSentence);
        String regexSymbol = ("(\\p{Punct})|(\\p{Blank})");
        Pattern pSymbol = Pattern.compile(regexSymbol);
        Sentence sentence = new Sentence();
        while (mPart.find()) {
            sentence.add(wordParsing(mPart.group().substring(0, mPart.group().length() - 1)));
            Matcher mSymbol = pSymbol.matcher(mPart.group());
            while (mSymbol.find()) {
                sentence.add(partSentenceParsing(mSymbol.group()));
            }

        }
        return sentence;
    }

    private SentencePart wordParsing(String stringWord) {
        String regexPart = ("\\w");
        Pattern pPart = Pattern.compile(regexPart);
        Matcher mPart = pPart.matcher(stringWord);
        Word word = new Word(SentencePart.SentencePartType.WORD);
        while (mPart.find()) {
            word.addLetter((Symbol) partSentenceParsing(mPart.group()));
        }
        return word;
    }

    private SentencePart partSentenceParsing(String stringPartSentence) {
        Symbol symbol;
        String regexPart = ("\\w");
        Pattern pPart = Pattern.compile(regexPart);
        Matcher mPart = pPart.matcher(stringPartSentence);
        if (mPart.find()) {
            symbol = new Symbol(mPart.group(), Symbol.SentencePartType.SYMBOL, Symbol.SymbolType.LETTER );
            return symbol;
        }
        regexPart = ("\\p{Punct}");
        pPart = Pattern.compile(regexPart);
        mPart = pPart.matcher(stringPartSentence);
        if (mPart.find()) {
            symbol = new Symbol(mPart.group(), Symbol.SentencePartType.SYMBOL, Symbol.SymbolType.PUNCTUATION);
            return symbol;
        } else {
            symbol = new Symbol(stringPartSentence, Symbol.SentencePartType.SYMBOL, Symbol.SymbolType.WHITESPACE);
            return symbol;
        }
    }
}
