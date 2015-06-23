package com.epam.irasov.parser;

import com.epam.irasov.parser.entity.Sentence;
import com.epam.irasov.parser.entity.SentencePart;
import com.epam.irasov.parser.entity.Text;
import com.epam.irasov.parser.logic.Parser;
import com.epam.irasov.parser.logic.WordsSearch;
import com.epam.irasov.parser.reporter.Reporter;
import com.epam.irasov.parser.utils.FileOperation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class OldServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String stringText = request.getParameter("text");
        Parser parser = new Parser();
        Text text = parser.textParsing(stringText);
        HttpSession session = request.getSession();
        session.setAttribute("text",text);
        response.sendRedirect(request.getContextPath()+"/result");
      //  session.setAttribute("text",text);
      //  getServletContext().setAttribute("text",text);
      //  request.getRequestDispatcher("/result.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
