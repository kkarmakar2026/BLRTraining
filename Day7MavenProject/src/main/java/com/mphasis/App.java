package com.mphasis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class App {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded");

        String uname = "root";
        String pwd = "root@39";
        String url = "jdbc:mysql://localhost:3306/mphasisdb";

        Connection con = DriverManager.getConnection(url, uname, pwd);
        System.out.println("Connection established");

        String query = "SELECT customerNumber, checkNumber, paymentDate, amount FROM payments";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        while (rs.next()) {
            int customerNumber = rs.getInt("customerNumber");
            String checkNumber = rs.getString("checkNumber");
            java.sql.Date paymentDate = rs.getDate("paymentDate");
            double amount = rs.getDouble("amount");

            System.out.println("Customer: " + customerNumber +
                               ", Check: " + checkNumber +
                               ", Date: " + paymentDate +
                               ", Amount: " + amount);
        }

        rs.close();
        st.close();
        con.close();
    }
}
