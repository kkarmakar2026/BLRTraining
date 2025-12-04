<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
    <h2>Login Form</h2>
    <!-- Use context path to avoid 404 -->
    <form action="<%= request.getContextPath() %>/validate.jsp" method="post">
        Username: <input type="text" name="username" /><br><br>
        Password: <input type="password" name="password" /><br><br>
        <input type="submit" value="Login" />
    </form>
</body>
</html>
