<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: LAPTOP ACER
  Date: 17-10-2022
  Time: 13:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Settings</h3>
<form:form action="/update" method="post" modelAttribute="configuration">
    <pre>Languages         <form:select path="language">
        <form:option value="english">English</form:option>
        <form:option value="vietnamese">Vietnamese</form:option>
        <form:option value="japanese">Japanese</form:option>
        <form:option value="chinese">Chinese</form:option>
    </form:select>
    </pre>
    <pre>Page Size: Show    <form:select path="pageSize">
        <form:option value="5">5</form:option>
        <form:option value="10">10</form:option>
        <form:option value="15">15</form:option>
        <form:option value="20">20</form:option>
        <form:option value="25">25</form:option>
        <form:option value="50">50</form:option>
        <form:option value="100">100</form:option>
    </form:select>
    </pre>
    <pre>Spams Filter:     <form:checkbox path="spamFilter" value="Enable spams filter"></form:checkbox>Enable spams filter    </pre>
    <pre>Signature:        <form:textarea path="signature"></form:textarea></pre>
    <pre>                  <input type="submit" value="Update">    <input type="reset" value="Cancel"></pre>
</form:form>
</body>
</html>
