<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="kk" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <kk:set var="name" value="koushik"></kk:set>
 <kk:out value="${name}"></kk:out>
 <kk:if test="${name == 'koushik'}">
 <h1>Name is Koushik</h1>
 </kk:if>
 </body>
</html>