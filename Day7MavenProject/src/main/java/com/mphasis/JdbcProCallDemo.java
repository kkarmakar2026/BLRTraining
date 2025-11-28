package com.mphasis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.CallableStatement;
import java.sql.ResultSet;

public class JdbcProCallDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/koushikdb";
        String uname = "root";
        String pwd = "root@39";

        try (Connection con = DriverManager.getConnection(url, uname, pwd)) {
            System.out.println("Connection established");

            CallableStatement csInsert = con.prepareCall("{call insert_student(?,?,?,?)}");
            csInsert.setInt(1, 201);
            csInsert.setString(2, "Arjun");
            csInsert.setString(3, "Mehta");
            csInsert.setDouble(4, 88.5);
            csInsert.execute();
            System.out.println("Student inserted.");

            CallableStatement csRead = con.prepareCall("{call get_students()}");
            ResultSet rs = csRead.executeQuery();
            System.out.println("Student Table Data:");
            while (rs.next()) {
                int id = rs.getInt("stdid");
                String fname = rs.getString("firstname");
                String lname = rs.getString("lastname");
                double marks = rs.getDouble("marks");
                System.out.println(id + " | " + fname + " " + lname + " | Marks: " + marks);
            }

            CallableStatement csUpdate = con.prepareCall("{call update_student(?,?)}");
            csUpdate.setInt(1, 201);
            csUpdate.setDouble(2, 95.0);
            csUpdate.execute();
            System.out.println("Student updated.");

            CallableStatement csDelete = con.prepareCall("{call delete_student(?)}");
            csDelete.setInt(1, 201);
            csDelete.execute();
            System.out.println("Student deleted.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
