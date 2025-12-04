<%@ tag description="adding two numbers nyum1,num2" pageEncoding="UTF-8"%>
<%@ attribute name="num1" required="true" type="java.lang.Double"%>
<%@ attribute name="num2" required="true" type="java.lang.Double"%>
<h1>Sum=${num1+num2}</h1>
    <h1>Custom Tag Demo</h1>

    <!-- Call the Fibonacci tag -->
    <ct:fibonacci count="10" />
