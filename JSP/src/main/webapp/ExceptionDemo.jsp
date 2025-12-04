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
		int a =5;int b =0;
		try{
			int c = a/b;
		}
		catch(ArithmeticException ae){
			request.setAttribute("err", ae);
			request.getRequestDispatcher("error.jsp").forward(request,response);
		}
	
	
	%>
</body>
</html>