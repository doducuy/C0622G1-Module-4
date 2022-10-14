<%--
  Created by IntelliJ IDEA.
  User: LAPTOP ACER
  Date: 14-10-2022
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Calculator</h3>
<form action="/calculate">
    <pre>
        <input type="number" name="operatorOne" value="${operatorOne}">
    </pre>
    <pre>
        <input type="number" name="operatorTwo" value="${operatorTwo}">
    </pre>
    <input type="submit" value="Addition(+)" name="calculation">
    <input type="submit" value="Subtraction(-)" name="calculation">
    <input type="submit" value="Multiplication(*)" name="calculation">
    <input type="submit" value="Division(/)" name="calculation">
    <pre>
        Result: ${result}
    </pre>
</form>
</body>
</html>
