package day05.ex00.ChatFolder.src.main.java.fr.chat;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/chatdb";
        String user = "postgres";
        String password = "test@@1234"; // 🔒 replace with yours

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("✅ Connected to PostgreSQL!");


            String sql = "SELECT * FROM users";
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String login = rs.getString("login");
                    String pwd = rs.getString("password");
                    Timestamp createdAt = rs.getTimestamp("created_at");

                    System.out.println(id + " | " + name + " | " + login + " | " + pwd + " | " + createdAt);
                }
            }
            // INSERT
            try (PreparedStatement insert = conn.prepareStatement("INSERT INTO users (name, email) VALUES (?, ?)")) {
//                insert.setString(1, "Alice");
//                insert.setString(2, "alice@example.com");
//                insert.executeUpdate();
                // fetch all users
                System.out.println("✅ User inserted");
            }
//
//            // SELECT
//            try (Statement select = conn.createStatement();
//                 ResultSet rs = select.executeQuery("SELECT * FROM users")) {
//                System.out.println("📋 Users:");
//                while (rs.next()) {
//                    System.out.println("- " + rs.getString("name") + " | " + rs.getString("email"));
//                }
//            }
//
//            // UPDATE
//            try (PreparedStatement update = conn.prepareStatement("UPDATE users SET name = ? WHERE email = ?")) {
//                update.setString(1, "Alicia");
//                update.setString(2, "alice@example.com");
//                update.executeUpdate();
//                System.out.println("✅ User updated");
//            }
//
//            // DELETE
//            try (PreparedStatement delete = conn.prepareStatement("DELETE FROM users WHERE email = ?")) {
//                delete.setString(1, "alice@example.com");
//                delete.executeUpdate();
//                System.out.println("✅ User deleted");
//            }

        } catch (SQLException e) {
            System.err.println("❌ Error: " + e.getMessage());
        }
    }
}
