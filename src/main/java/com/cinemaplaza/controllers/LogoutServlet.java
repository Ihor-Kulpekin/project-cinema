package com.cinemaplaza.controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LogoutServlet",urlPatterns = "/LogoutServlet")
public class LogoutServlet extends HttpServlet {
    private static final long serialVersion = 1L;



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if(session!=null){
            session.invalidate();
            request.setAttribute("errorMessage","You have logged out successfully");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("pages/Login.jsp");
            requestDispatcher.forward(request,response);
            System.out.println("Logged out");
        }
    }
}
