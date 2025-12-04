<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.Date" %>
<%! int counter = 0; %>
<%! public String greet(String name) { return "Hello, " + name; } %>

<html>
<head><title>JSP Tag Demo</title></head>
<body>

<%-- JSP Comment: Not visible in output --%>

<h2>Directive Example</h2>
<p>Page imported Date class.</p>

<h2>Declaration + Scriptlet Example</h2>
<%
    counter++;
    out.println("Counter value: " + counter);
%>

<h2>Expression Example</h2>
<p>Current Date: <%= new Date() %></p>
<p>Greeting: <%= greet("Koushik") %></p>


<% ArrayList alist = new ArrayList();
alist.add(56);
alist.add("balai");
out.println(alist);%>

<h2>Action Tag Example</h2>
<%@ include file="footer.jsp" %>

<%--<jsp:include page="/WEB-INF\footer.jsp" /> --%>


</body>
</html>
