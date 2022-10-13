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
<h3>Dictionary</h3>
<form action="/result" method="post">
    <pre>EngLish: <input type="text" name="eng" placeholder="EngLish" value="${eng}"> </pre>

    <pre>Việt Nam: ${result} </pre>
    <input type="submit" value="Translate">
</form>
</body>
</html>
