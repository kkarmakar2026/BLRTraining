<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login Success</title>
</head>
<body>
    <h2>Login Successful</h2>

    <c:if test="${not empty sessionScope.user}">
        <p>Welcome, ${sessionScope.user}!</p>
    </c:if>

    <p><a href="home.jsp">Go to Home</a></p>
</body>
</html>
     