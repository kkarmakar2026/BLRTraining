<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
    String user = "Koushik";
   
    pageContext.setAttribute("user", user);
%>

<!-- Retrieve and display the value -->
<p>User from application scope: <%= pageContext.getAttribute("user") %></p>
<%=page.getClass() %>
</body>
</html>
