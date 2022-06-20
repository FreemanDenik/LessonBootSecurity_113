package com.denik.vy.dao;

import com.denik.vy.models.User;
import com.denik.vy.utils.Util;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class UserDaoJDBC implements UserDao {
    Connection connection = Util.DBConnection();

    @Override
    public void createTable() throws SQLException {
        Statement statement = connection.createStatement();
        String sql = """
                CREATE TABLE IF NOT EXISTS users
                (
                    id BIGINT NOT NULL AUTO_INCREMENT,
                    name VARCHAR(256),
                    lastname VARCHAR(256),
                    age TINYINT,
                    PRIMARY KEY(`id`)
                )
                """;
        statement.execute(sql);
    }

    @Override
    public void dropTable() throws SQLException {
        Statement statement = connection.createStatement();
        String sql = """
                DROP TABLE IF EXISTS users
                """;
        statement.execute(sql);
    }

    @Override
    public void addUser(User user) throws SQLException {
        String sql = """
                INSERT INTO users (name, lastname, age) VALUES (?,?,?)
                """;
        PreparedStatement prepared = connection.prepareStatement(sql);
        prepared.setString(1, user.getName());
        prepared.setString(2, user.getLastname());
        prepared.setByte(3, user.getAge());
        prepared.execute();
    }

    @Override
    public Set<User> getAllUsers() throws SQLException {
        Statement statement = connection.createStatement();
        String sql = """
                SELECT u.name, u.lastname, u.age FROM users u 
                """;
        ResultSet result = statement.executeQuery(sql);
        Set<User> users = new HashSet<>();
        while (result.next()) {
            users.add(new User(
                    result.getString("name"),
                    result.getString("lastname"),
                    result.getByte("age")
            ));
        }
        return users;
    }

    @Override
    public void removeUser(int userId) throws SQLException {
        String sql = """
                DELETE FROM users u WHERE u.id = ?
                """;
        PreparedStatement prepared = connection.prepareStatement(sql);
        prepared.setInt(1, 1);
        prepared.execute();
    }

    @Override
    public void cleanTable() throws SQLException {
        Statement statement = connection.createStatement();
        String sql = """
                TRUNCATE TABLE users
                """;
        statement.execute(sql);
    }
}
