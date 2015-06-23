package com.epam.irasov.parser;

import com.epam.irasov.parser.entity.SentencePart;
import com.epam.irasov.parser.entity.Text;
import com.epam.irasov.parser.logic.Parser;
import com.epam.irasov.parser.logic.WordsSearch;
import com.epam.irasov.parser.reporter.Reporter;
import com.epam.irasov.parser.utils.Internationalization;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class OldServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String stringText = request.getParameter("text");
        //ResourceBundle bundle = ResourceBundle.getBundle("i18n");
        Internationalization bundle = Internationalization.getInstance();
        bundle.setBaseName("i18n");
        bundle.setLocale(new Locale(("en")));
        Parser parser = new Parser();
        Text text = parser.textParsing(stringText);
        List<SentencePart> words = WordsSearch.uniqueWordsSearch(WordsSearch.sentenceWords(text.getPart(), 0, 0), WordsSearch.textWordsNotConsiderOnSentence(text.getPart(), 0, 0));
        String foundWords = Reporter.reportFoundWords(words);
        HttpSession session = request.getSession();
        session.setAttribute("bundle",bundle);
        session.setAttribute("text",text);
        session.setAttribute("fondWords",foundWords);
        response.sendRedirect(request.getContextPath()+"/result");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     /*   Internationalization bundle = Internationalization.getInstance();
      //  String local = request.getParameter("local");
        String local ="en";
        bundle.setBaseName("i18n");
        bundle.setLocale(new Locale((local)));
        request.setAttribute("bundle", bundle);
        RequestDispatcher dispatcher  = request.getRequestDispatcher("/result");
        dispatcher.forward(request,response);*/

    }
}
