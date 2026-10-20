package com.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session != null) {
            session.invalidate();
        }

        response.setContentType("text/html;charset=UTF-8");

        response.getWriter().println(
            "<!DOCTYPE html><html><body>" +
            "<h1>Logout Successful!</h1>" +
            "<p>Your session has been terminated.</p>" +
            "<a href='" + request.getContextPath() +
            "/index.html'>Login Again</a>" +
            "</body></html>"
        );
    }
}
