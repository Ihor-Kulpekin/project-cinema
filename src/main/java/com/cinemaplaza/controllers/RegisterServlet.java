package com.cinemaplaza.controllers;

import com.cinemaplaza.dao.RegisterDao;
import com.cinemaplaza.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "RegisterServlet",urlPatterns = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("pages/Register.jsp").forward(req,resp);
//        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fullName = req.getParameter("fullname");
        String email = req.getParameter("email");
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        User user = new User();
        user.setFullName(fullName);
        user.setEmail(email);
        user.setUserName(userName);
        user.setPassword(password);
        RegisterDao registerDao = new RegisterDao();
        try {
            String userRegistered = registerDao.registerUser(user);
            if(userRegistered.equals("SUCCESS"))   //On success, you can display a message to user on Home page
            {
                req.getRequestDispatcher("pages/Home.jsp").forward(req, resp);
            }
            else   //On Failure, display a meaningful message to the User.
            {
                req.setAttribute("errMessage", userRegistered);
                req.getRequestDispatcher("pages/Register.jsp").forward(req, resp);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
