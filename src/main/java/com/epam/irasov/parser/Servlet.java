package com.epam.irasov.parser;

import com.epam.irasov.parser.utils.Internationalization;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String local = request.getParameter("local");
        Internationalization bundle = Internationalization.getInstance();
        bundle.setBaseName("i18n");
        bundle.setLocale(new Locale((local)));
        request.setAttribute("bundle", bundle);
        RequestDispatcher dispatcher  = request.getRequestDispatcher("/parser.jsp");
        dispatcher.forward(request,response);

      //  response.sendRedirect(request.getContextPath()+"/parser.jsp");
    }
}
