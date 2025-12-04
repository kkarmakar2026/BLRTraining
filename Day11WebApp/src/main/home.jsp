<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
    <h2>Home Page</h2>

    <c:choose>
        <c:when test="${not empty sessionScope.user}">
            <p>Hello, ${sessionScope.user}! You are logged in.</p>
            <p><a href="logout">Logout</a></p>
        </c:when>
        <c:otherwise>
            <p>You are not logged in.</p>
            <p><a href="login.jsp">Login here</a></p>
        </c:otherwise>
    </c:choose>
</body>
</html>
