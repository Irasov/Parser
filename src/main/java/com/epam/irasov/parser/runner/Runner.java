package com.epam.irasov.parser.runner;

import com.epam.irasov.parser.entity.*;
import com.epam.irasov.parser.logic.Parser;
import com.epam.irasov.parser.logic.WordsSearch;
import com.epam.irasov.parser.reporter.Reporter;
import com.epam.irasov.parser.utils.FileOperation;
import org.apache.log4j.Logger;

public class Runner {
    private static Logger LOGGER = Logger.getLogger(Runner.class);
    public static void main(String[] args) {
        LOGGER.info("Info: parser project launched");
        Parser parser = new Parser();
        Text text = parser.textParsing(FileOperation.fileRead());
        Reporter.printFoundWords(WordsSearch.uniqueWordsSearch(WordsSearch.sentenceWords(text.getElements(), 0, 0), WordsSearch.textWordsNotConsiderOnSentence(text.getElements(), 0, 0)));
        LOGGER.info("Info: parser has completed execution of the project");
    }
}
