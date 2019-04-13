package com.cinemaplaza.dao;

import com.cinemaplaza.dbconnection.DBConnection;
import com.cinemaplaza.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ResetPasswordDao {

    public String resetPassword(User user){

        String email = user.getEmail();
        String newPassword = user.getPassword();

        Connection connection = null;
        PreparedStatement preparedStatement = null;


        try {
            connection = DBConnection.createConnection();

            String query = "UPDATE users set password = ? where email = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,newPassword);
            preparedStatement.setString(2,email);

            int executeUpdate = preparedStatement.executeUpdate();

            if(executeUpdate!=0){
                return "Success";
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "Invalid email";
    }
}
