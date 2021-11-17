package com.app.dao;

import com.app.beans.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {

    public int saveUser(User user) throws Exception {
        int update = 0;
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into user(id,name,email) values(?,?,?)");
        preparedStatement.setInt(1, user.getId());
        preparedStatement.setString(2, user.getName());
        preparedStatement.setString(3, user.getEmail());
        update = preparedStatement.executeUpdate();
        return update;
    }
}
