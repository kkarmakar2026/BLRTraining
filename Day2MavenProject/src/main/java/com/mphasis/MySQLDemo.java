package com.mphasis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQLDemo {
    public static void main(String[] args) throws ClassNotFoundException {
//        try {
            // Step 1: Load MySQL driver (optional in JDBC 4+)
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("driver loaded");

//            // Step 2: Connect to database
//            Connection con = DriverManager.getConnection(
//                "jdbc:mysql://localhost:3306/employee?useSSL=false&serverTimezone=UTC",
//                "root",
//                "root@39"
//            );
//
//            // Step 3: Create statement
//            Statement stmt = con.createStatement();
//
//            // Step 4: Execute query
//            ResultSet rs = stmt.executeQuery("SELECT * FROM student");
//
//            // Step 5: Process results
//            while (rs.next()) {
//                System.out.println(rs.getInt("StudentID") + " " + rs.getString("Name"));
//            }
//
//            // Step 6: Close resources
//            rs.close();
//            stmt.close();
//            con.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
