package com.organization.features.tasks;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository {

    private static final String URL = "jdbc:sqlite:src/main/resources/app.db";

    public void save(Task task) {
        try {
            Connection conn = DriverManager.getConnection(URL);
            PreparedStatement stmt = conn.prepareStatement(
                    "INSERT INTO tasks(title, description, dueDate, completed) VALUES (?, ?, ?, ?)");
            stmt.setString(1, task.getTitle());
            stmt.setString(2, task.getDescription());
            stmt.setString(3, task.getDueDate());
            stmt.setBoolean(4, task.isCompleted());
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Task> findAll() {
        List<Task> tasks = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(URL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM tasks");
            while (rs.next()) {
                Task t = new Task();
                t.setId(rs.getInt("id"));
                t.setTitle(rs.getString("title"));
                t.setDescription(rs.getString("description"));
                t.setDueDate(rs.getString("dueDate"));
                t.setCompleted(rs.getInt("completed") == 1);
                tasks.add(t);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return tasks;
    }
}
