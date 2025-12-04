<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head><title>Welcome Page</title></head>
<body>
<%
    String user = (String) session.getAttribute("username");
    String lastUser = (String) application.getAttribute("lastLoginUser");

    if(user != null) {
%>
        <h2>Welcome, <%= user %>!</h2>
        <p>You are successfully logged in.</p>
        <p>Last login user (application scope): <%= lastUser %></p>
        <a href="<%= request.getContextPath() %>/logout.jsp">Logout</a>
<%
    } else {
%>
        <h3>No active session. Please <a href="<%= request.getContextPath() %>/login.jsp">Login</a>.</h3>
<%
    }
%>
</body>
</html>
