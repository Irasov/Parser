package com.epam.irasov.parser.runner;

import com.epam.irasov.parser.entity.*;
import com.epam.irasov.parser.logic.Parser;
import com.epam.irasov.parser.logic.WordsSearch;
import com.epam.irasov.parser.reporter.Reporter;
import com.epam.irasov.parser.utils.FileOperation;

public class Runner {
    public static void main(String[] args) {
        Parser parser = new Parser();
        Text text = parser.textParsing(FileOperation.fileRead());
        System.out.println(text.buildOriginalString());
        Reporter.printFoundWords(WordsSearch.UniqueWordsSearch(WordsSearch.sentenceWords(text.getPart(), 0, 0), WordsSearch.sentenceWordsNotConsiderOnSentence(text.getPart(), 0, 0)));
    }
}
