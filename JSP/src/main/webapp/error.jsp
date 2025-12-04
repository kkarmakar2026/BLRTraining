<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error Page</title>
</head>
<body>
    <h2 style="color:red;">An error occurred!</h2>
    <%
        // Retrieve the error object from request scope
        Exception ex = (Exception) request.getAttribute("err");
        if (ex != null) {
    %>
        <p><strong>Error Type:</strong> <%= ex.getClass().getName() %></p>
        <p><strong>Message:</strong> <%= ex.getMessage() %></p>
    <%
        } else {
    %>
        <p>No error details available.</p>
    <%
        }
    %>
    <p><a href="<%= request.getContextPath() %>/index.jsp">Go Back</a></p>
</body>
</html>
