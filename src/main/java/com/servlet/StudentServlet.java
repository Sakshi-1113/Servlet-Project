package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String course = request.getParameter("course");

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html><body>");
        out.println("<h1>Student Information</h1>");
        out.println("<p>Name: " + escape(name) + "</p>");
        out.println("<p>Email: " + escape(email) + "</p>");
        out.println("<p>Course: " + escape(course) + "</p>");
        out.println("<a href='index.html'>Back to Forms</a>");
        out.println("</body></html>");
    }

    private String escape(String value) {
        if (value == null) {
            return "";
        }

        return value.replace("&", "&amp;")
                    .replace("<", "&lt;")
                    .replace(">", "&gt;")
                    .replace("\"", "&quot;")
                    .replace("'", "&#39;");
    }
}
