package com.raczkowski.apps.model.repository;

import com.raczkowski.apps.model.User;
import com.raczkowski.apps.model.UserRegistrationData;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UsersJDBCDao implements UsersDao {
    @Override
    public void addUser(UserRegistrationData user) {
        Connection connection = connect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users(id, name, lastname, email, password) VALUES (?,?,?,?,?)");
            preparedStatement.setInt(1, loadUsers().size());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setString(4, user.getMail());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> loadUsers() {
        Connection connection = connect();
        Statement statement;
        List<User> users = new ArrayList<>();
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String lastName = rs.getString("lastname");
                String eMail = rs.getString("email");
                String password = rs.getString("password");
                User user = new User(id, name, lastName, eMail, password);
                users.add(user);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void updateUserData(int id, String email, String password, String name, String lastName) {
        Connection connection = connect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE users SET (name, lastName, email, password) VALUES (?,?,?,?) WHERE id=" + id);
            if (name != null) {
                preparedStatement.setString(1, name);
            }
            if (lastName != null) {
                preparedStatement.setString(2, lastName);
            }
            if (email != null) {
                preparedStatement.setString(3, email);
            }
            if (password != null) {
                preparedStatement.setString(4, password);
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection connect() {
        Connection conn = null;
        try {
            String url = "jdbc:postgresql://localhost:5432/articleservice";
            String user = "postgres";
            String password = "Tajfun";
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
