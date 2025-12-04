package com.mphasis;
 
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
 
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
 
public class DBServlet extends HttpServlet {
 
    private static final long serialVersionUID = 1L;
 
    private String jdbcUrl;
    private String jdbcUser;
    private String jdbcPassword;
 
    @Override
    public void init() throws ServletException {
        jdbcUrl = getInitParameter("jdbcUrl");
        jdbcUser = getInitParameter("jdbcUser");
        jdbcPassword = getInitParameter("jdbcPassword");
    }
 
    private Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
    }
 
    // GET: search by id, name, or all
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
 
        String idParam = req.getParameter("id");
        String nameParam = req.getParameter("name");
 
        try (Connection conn = getConnection()) {
            PreparedStatement stmt;
            if (idParam != null && !idParam.isEmpty()) {
                stmt = conn.prepareStatement("SELECT * FROM employees WHERE employeeNumber = ?");
                stmt.setInt(1, Integer.parseInt(idParam));
            } else if (nameParam != null && !nameParam.isEmpty()) {
                stmt = conn.prepareStatement("SELECT * FROM employees WHERE firstName LIKE ? OR lastName LIKE ?");
                stmt.setString(1, "%" + nameParam + "%");
                stmt.setString(2, "%" + nameParam + "%");
            } else {
                stmt = conn.prepareStatement("SELECT * FROM employees");
            }
 
            ResultSet rs = stmt.executeQuery();
            out.println("<h2>Employees</h2><table border='1'>");
            out.println("<tr><th>ID</th><th>Last Name</th><th>First Name</th><th>Email</th><th>Job Title</th></tr>");
            while (rs.next()) {
                out.println("<tr><td>" + rs.getInt("employeeNumber") + "</td>"
                        + "<td>" + rs.getString("lastName") + "</td>"
                        + "<td>" + rs.getString("firstName") + "</td>"
                        + "<td>" + rs.getString("email") + "</td>"
                        + "<td>" + rs.getString("jobTitle") + "</td></tr>");
            }
            out.println("</table>");
        } catch (Exception e) {
            e.printStackTrace(out);
        }
    }
 
    // POST: update employee by id
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
 
        String id = req.getParameter("id");
        String email = req.getParameter("email");
        String jobTitle = req.getParameter("jobTitle");
 
        try (Connection conn = getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("UPDATE employees SET email=?, jobTitle=? WHERE employeeNumber=?");
            stmt.setString(1, email);
            stmt.setString(2, jobTitle);
            stmt.setInt(3, Integer.parseInt(id));
 
            int rows = stmt.executeUpdate();
            out.println("<p>Updated " + rows + " record(s).</p>");
        } catch (Exception e) {
            e.printStackTrace(out);
        }
    }
 
    // PUT: insert new employee
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
 
        String id = req.getParameter("id");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String jobTitle = req.getParameter("jobTitle");
        String officeCode = req.getParameter("officeCode");
        String extension = req.getParameter("extension");
 
        try (Connection conn = getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(
                    "INSERT INTO employees (employeeNumber, lastName, firstName, extension, email, officeCode, jobTitle) VALUES (?, ?, ?, ?, ?, ?, ?)");
            stmt.setInt(1, Integer.parseInt(id));
            stmt.setString(2, lastName);
            stmt.setString(3, firstName);
            stmt.setString(4, extension);
            stmt.setString(5, email);
            stmt.setString(6, officeCode);
            stmt.setString(7, jobTitle);
 
            int rows = stmt.executeUpdate();
            out.println("<p>Inserted " + rows + " record(s).</p>");
        } catch (Exception e) {
            e.printStackTrace(out);
        }
    }
 
    // DELETE: remove employee by id
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
 
        String id = req.getParameter("id");
 
        try (Connection conn = getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM employees WHERE employeeNumber=?");
            stmt.setInt(1, Integer.parseInt(id));
 
            int rows = stmt.executeUpdate();
            out.println("<p>Deleted " + rows + " record(s).</p>");
        } catch (Exception e) {
            e.printStackTrace(out);
        }
    }
}