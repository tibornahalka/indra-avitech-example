package sk.indra.avitech.example.db;

import sk.indra.avitech.example.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private Connection connection;

    public Database() throws SQLException {
        connection = DriverManager.getConnection("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1", "sa", "");
        try (Statement stmt = connection.createStatement()) {
            stmt.execute("CREATE TABLE IF NOT EXISTS SUSERS (USER_ID INT PRIMARY KEY, USER_GUID VARCHAR(255), USER_NAME VARCHAR(255))");
        }
    }

    public synchronized void addUser(User user) throws SQLException {
        String sql = "INSERT INTO SUSERS (USER_ID, USER_GUID, USER_NAME) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, user.getUserId());
            pstmt.setString(2, user.getUserGuid());
            pstmt.setString(3, user.getUserName());
            pstmt.executeUpdate();
        }
    }

    public synchronized List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        String sql = "SELECT USER_ID, USER_GUID, USER_NAME FROM SUSERS";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                users.add(new User(rs.getInt("USER_ID"), rs.getString("USER_GUID"), rs.getString("USER_NAME")));
            }
        }
        return users;
    }

    public synchronized void deleteAllUsers() throws SQLException {
        String sql = "DELETE FROM SUSERS";
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(sql);
        }
    }
}
