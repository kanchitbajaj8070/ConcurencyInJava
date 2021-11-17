package com.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    static Connection getConnection()
    {
        Connection connection=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","oracle");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
return connection;
    }
}
