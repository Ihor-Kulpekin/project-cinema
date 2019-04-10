package com.cinemaplaza.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection createConnection() throws ClassNotFoundException, SQLException {
        Connection connection = null;

        String url = "jdbc:mysql://localhost:3306/cinemaplaza1?serverTimezone=UTC";
        String username = "root";
        String password = "admin";

        Class.forName("com.mysql.cj.jdbc.Driver");

        connection = DriverManager.getConnection(url,username,password);
        System.out.println("Printing connection object "+connection);

        return connection;
    }
}

