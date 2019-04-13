package com.cinemaplaza.dao;

import com.cinemaplaza.dbconnection.DBConnection;
import com.cinemaplaza.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDao {

    public String registerUser(User user) throws ClassNotFoundException {
        String fullName = user.getFullName();
        String email = user.getEmail();
        String userName = user.getUserName();
        String password = user.getPassword();
        Connection con = null;
        PreparedStatement preparedStatement = null;

        try
        {
            con = DBConnection.createConnection();
            String query = "insert into users(fullName,email,userName,password) values (?,?,?,?)"; //Insert user details into the table 'USERS'
            preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
            preparedStatement.setString(1, fullName);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, userName);
            preparedStatement.setString(4, password);

            int executeUpdate= preparedStatement.executeUpdate();

            if (executeUpdate!=0)  //Just to ensure data has been inserted into the database
                return "SUCCESS";
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return "Oops.. Something went wrong there..!";
    }
}
