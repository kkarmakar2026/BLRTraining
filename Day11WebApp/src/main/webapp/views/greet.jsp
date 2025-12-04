<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="ct" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Run Custom Tag</title>
</head>
<body>
    <h2>Testing Custom Tag</h2>

    <!-- Call the greet.tag file -->
    
    <ct:calc num2="23" num1="40"></ct:calc>
    <ct:fibonacci count="10" />
</body>
</html>
