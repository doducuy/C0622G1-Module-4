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
<h3>Check Email</h3>
<form action="/check">
    <pre>
        Enter Your Email:
        <input type="text" name="email" placeholder="doducuy@gmail.com" value="${email}">
    </pre>
    <pre>
        Result: ${result}
    </pre>
    <input type="submit" value="Check!">
</form>
</body>
</html>
