package com.epam.brest.courses.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by viktar on 11/4/14.
 */
public class HelloServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String parameter = request.getParameter("name");

        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        try {
            out.print("Hello ");
            out.print(parameter);
        } finally {
            out.close();
        }
    }
}
