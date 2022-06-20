package com.denik.vy.dao;

import com.denik.vy.models.User;

import java.sql.SQLException;
import java.util.Set;

public interface UserDao {
    void createTable() throws SQLException;
    void dropTable() throws SQLException;
    void addUser(User user) throws SQLException;
    Set<User> getAllUsers() throws SQLException;
    void removeUser(int userId) throws SQLException;
    void cleanTable() throws SQLException;
}
