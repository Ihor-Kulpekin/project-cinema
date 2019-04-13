package com.cinemaplaza.controllers;

import com.cinemaplaza.dao.ResetPasswordDao;
import com.cinemaplaza.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "ResetPasswordServlet",urlPatterns = "/ResetPasswordServlet")
public class ResetPasswordServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("pages/ResetPassword.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String newPassword = request.getParameter("password");
        User user = new User();

        user.setEmail(email);
        user.setPassword(newPassword);

        ResetPasswordDao resetPasswordDao = new ResetPasswordDao();

        String resetPassword = resetPasswordDao.resetPassword(user);

        if(resetPassword.equals("Success")){
            request.getRequestDispatcher("pages/MainForm.jsp").forward(request,response);
        }

        else   //On Failure, display a meaningful message to the User.
        {
            request.setAttribute("errMessage", resetPasswordDao);
            request.getRequestDispatcher("pages/ResetPassword.jsp").forward(request, response);
        }

    }
}
