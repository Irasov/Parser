package com.epam.irasov.parser.runner;

import com.epam.irasov.parser.entity.*;
import com.epam.irasov.parser.logic.ParserText;
import com.epam.irasov.parser.logic.SearchWords;
import com.epam.irasov.parser.reporter.Reporter;
import com.epam.irasov.parser.utils.FileOperation;

public class Runner {
    public static void main(String[] args) {
        ParserText parser = new ParserText();
        Text text = parser.parse(FileOperation.fileRead());
        System.out.println(text.buildOriginalString());
        Reporter.printFoundWords(SearchWords.foundWords(text.getPart()));
    }
}
