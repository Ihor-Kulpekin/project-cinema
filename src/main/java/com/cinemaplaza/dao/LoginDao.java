package com.cinemaplaza.dao;

import com.cinemaplaza.dbconnection.DBConnection;
import com.cinemaplaza.model.User;

import java.sql.*;

public class LoginDao {
    public String authenticateUser(User user) throws SQLException, ClassNotFoundException {
        String username = user.getUserName();
        String password = user.getPassword();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String userNameDB = "";
        String passwordDB = "";

        connection = DBConnection.createConnection();
        statement = connection.createStatement();
        resultSet = statement.executeQuery("select userName,password from users");

        while (resultSet.next()) // Until next row is present otherwise it return false
        {
            userNameDB = resultSet.getString("userName"); //fetch the values present in database
            passwordDB = resultSet.getString("password");

            ////If the user entered values are already present in database, which means user has already registered
            // so I will return SUCCESS message.
            if (username.equals(userNameDB) && password.equals(passwordDB)) {
                return "SUCCESS";
            }
        }

        return "Invalid user credentials"; // Just returning appropriate message otherwise
    }

}
