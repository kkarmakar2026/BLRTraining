package com.mphasis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.DatabaseMetaData;

public class App {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");

            String uname = "root";
            String pwd = "root@39";
            String url = "jdbc:mysql://localhost:3306/mphasisdb";

            String query = "SELECT customerNumber, checkNumber, paymentDate, amount FROM payments";

            try (Connection con = DriverManager.getConnection(url, uname, pwd);
                 Statement st = con.createStatement();
                 ResultSet rs = st.executeQuery(query)) {

                System.out.println("Connection established");

                ResultSetMetaData rsmd = rs.getMetaData();
                int columnCount = rsmd.getColumnCount();
                System.out.println("Number of columns: " + columnCount);

                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(rsmd.getColumnName(i) + "\t");
                }
                System.out.println();
    
                DatabaseMetaData dbmd = con.getMetaData();
                System.out.println("Database Product: " + dbmd.getDatabaseProductName());
                System.out.println("Database Version: " + dbmd.getDatabaseProductVersion());
               // rs = dbmd.getTables(null, null, "root", new String[] {"TABLE"});

                while (rs.next()) {
                    int customerNumber = rs.getInt("customerNumber");
                    String checkNumber = rs.getString("checkNumber");
                    java.sql.Date paymentDate = rs.getDate("paymentDate");
                    double amount = rs.getDouble("amount");

                    System.out.println(customerNumber + "\t" + checkNumber + "\t" + paymentDate + "\t" + amount);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
