<%@ tag description="Factorial Tag" pageEncoding="UTF-8"%>
<%@ attribute name="number" required="true" type="java.lang.Integer" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<c:set var="fact" value="1" />
 
<c:forEach var="i" begin="1" end="${number}">
    <c:set var="fact" value="${fact * i}" />
</c:forEach>
 
Factorial of <c:out value="${number}" /> is <c:out value="${fact}" />
 

 