package com.example.dethi.model;

import com.example.dethi.entity.User;
import com.example.dethi.util.ConfigSql;
import com.example.dethi.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserModel {
    public User findAccountByUsername(String username) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement(
                            ConfigSql.SELECT_ACCOUNT_BY_USERNAME);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String usernameDatabase = resultSet.getString("username");
                String password = resultSet.getString("password");
                User user = new User();
                user.setUsername(usernameDatabase);
                user.setPassword(password);
                ;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}