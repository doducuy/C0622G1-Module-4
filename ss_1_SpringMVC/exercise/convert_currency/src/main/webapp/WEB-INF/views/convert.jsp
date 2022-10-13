<%--
  Created by IntelliJ IDEA.
  User: LAPTOP ACER
  Date: 13-10-2022
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Convert Currency</h3>
<form action="/result" method="post">
    <pre>USD: <input type="number" name="usd" placeholder="USD" value="${usd}"> </pre>
    <pre>Rate: <input type="number" name="rate" placeholder="Rate" value="${rate}"></pre>
    <pre>Result: ${result} VND</pre>
    <input type="submit" value="Convert">
</form>
</body>
</html>
