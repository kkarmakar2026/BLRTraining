<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head><title>Validation</title></head>
<body>
<%
    String user = request.getParameter("username");
    String pass = request.getParameter("password");

    if("admin".equals(user) && "1234".equals(pass)) {
        session.setAttribute("username", user);
        application.setAttribute("lastLoginUser", user);

  
        response.sendRedirect(request.getContextPath() + "/welcome.jsp");


    } else {
        out.println("<h3 style='color:red;'>Invalid Username or Password</h3>");
        out.println("<a href='" + request.getContextPath() + "/login.jsp'>Try Again</a>");
    }
%>
</body>
</html>
