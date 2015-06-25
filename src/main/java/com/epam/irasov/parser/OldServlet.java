package com.epam.irasov.parser;

import com.epam.irasov.parser.entity.SentencePart;
import com.epam.irasov.parser.entity.Text;
import com.epam.irasov.parser.logic.Parser;
import com.epam.irasov.parser.logic.WordsSearch;
import com.epam.irasov.parser.reporter.Reporter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class OldServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String stringText = request.getParameter("text");
        String foundWords;
        Parser parser = new Parser();
        Text text = parser.textParsing(stringText);
        List<SentencePart> words = WordsSearch.uniqueWordsSearch(WordsSearch.sentenceWords(text.getElements(), 0, 0), WordsSearch.textWordsNotConsiderOnSentence(text.getElements(), 0, 0));
        foundWords = Reporter.reportFoundWords(words);
        HttpSession session = request.getSession();
        session.setAttribute("text",text);
        session.setAttribute("foundWords",foundWords);
        session.setAttribute("words",words);
        response.sendRedirect(request.getContextPath()+"/result");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
