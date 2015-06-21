package com.epam.irasov.parser.reporter;

import com.epam.irasov.parser.entity.SentencePart;
import com.epam.irasov.parser.utils.FileOperation;
import com.epam.irasov.parser.utils.Settings;
import org.apache.log4j.Logger;

import java.util.List;

public class Reporter {
    private static Logger LOGGER = Logger.getLogger(Reporter.class);

    public static void printFoundWords(List<SentencePart> foundWords) {
        Settings settings = Settings.getInstance();
        StringBuilder sb = new StringBuilder();
        if (!foundWords.isEmpty()) {
            for (SentencePart word : foundWords) {
                sb.append(word.buildOriginalString()).append("\n");
            }
            LOGGER.info("The search words are printed to a fondWords.txt");
            FileOperation.fileWrite(sb.toString(), settings.getProperties("file.found.words.path"));
        } else {
            LOGGER.info("Not found words");
        }
    }
}
