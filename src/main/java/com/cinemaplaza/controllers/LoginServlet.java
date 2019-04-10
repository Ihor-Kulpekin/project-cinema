package com.cinemaplaza.controllers;

import com.cinemaplaza.dao.LoginDao;
import com.cinemaplaza.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name="LoginServlet",urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("pages/Login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User loginUser = new User();

        loginUser.setUserName(username);
        loginUser.setPassword(password);

        LoginDao loginDao = new LoginDao();

        try {
            String userValidate = loginDao.authenticateUser(loginUser);
            if(userValidate.equals("SUCCESS")){
                req.setAttribute("userName",username);
                req.getRequestDispatcher("pages/UserPage.jsp").forward(req,resp);
            }

            else {
                req.setAttribute("errMessage", userValidate); //If authenticateUser() function returnsother than SUCCESS string it will be sent to Login page again. Here the error message returned from function has been stored in a errMessage key.
                req.getRequestDispatcher("pages/Login.jsp").forward(req, resp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
