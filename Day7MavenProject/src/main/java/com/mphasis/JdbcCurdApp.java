package com.mphasis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcCurdApp {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mphasisdb";
        String uname = "root";
        String pwd = "root@39";

        try (Connection con = DriverManager.getConnection(url, uname, pwd)) {
            System.out.println("Connection established");

            String insertQuery = "INSERT INTO student (stdid, firstname, lastname, marks) VALUES (?, ?, ?, ?)";
            PreparedStatement psInsert = con.prepareStatement(insertQuery);
            Object[][] students = {
                    {101, "Koushik", "Karmakar", 89.5},
                    {102, "Ravi", "Kumar", 76.0},
                    {103, "Anita", "Sharma", 92.3},
                    {104, "Suresh", "Patel", 68.4},
                    {105, "Priya", "Nair", 81.7},
                    {106, "Arjun", "Mehta", 73.2},
                    {107, "Meena", "Reddy", 95.0},
                    {108, "Vikram", "Singh", 88.9},
                    {109, "Neha", "Gupta", 79.6},
                    {110, "Rahul", "Verma", 85.4}
                };

                for (Object[] s : students) {
                    psInsert.setInt(1, (int) s[0]);
                    psInsert.setString(2, (String) s[1]);
                    psInsert.setString(3, (String) s[2]);
                    psInsert.setDouble(4, (double) s[3]);
                    psInsert.executeUpdate();
                }

            String selectQuery = "SELECT stdid, firstname, lastname, marks FROM student";
            PreparedStatement psSelect = con.prepareStatement(selectQuery);
            ResultSet rs = psSelect.executeQuery();
            System.out.println("Student Table Data:");
            while (rs.next()) {
                int id = rs.getInt("stdid");
                String fname = rs.getString("firstname");
                String lname = rs.getString("lastname");
                double marks = rs.getDouble("marks");

                System.out.println(id + " | " + fname + " " + lname + " | Marks: " + marks);
            }

            String updateQuery = "UPDATE student SET marks = ? WHERE stdid = ?";
            PreparedStatement psUpdate = con.prepareStatement(updateQuery);
            psUpdate.setDouble(1, 95.0);
            psUpdate.setInt(2, 101);
            int updated = psUpdate.executeUpdate();
            System.out.println(updated + " row(s) updated.");

            String deleteQuery = "DELETE FROM student WHERE stdid = ?";
            PreparedStatement psDelete = con.prepareStatement(deleteQuery);
            psDelete.setInt(1, 101);
            int deleted = psDelete.executeUpdate();
            System.out.println(deleted + " row(s) deleted.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
