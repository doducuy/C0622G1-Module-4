<%--
  Created by IntelliJ IDEA.
  User: LAPTOP ACER
  Date: 17-10-2022
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Login</title>
</head>
<body>
<h2>Nhập tài khoản và mật khẩu</h2>
<form:form modelAttribute="login" action="/login" method="post">
    <fieldset>
        <legend>Login</legend>
        <table>
            <tr>
                <td><form:label path="account">Account</form:label></td>
                <td><form:input path="account"></form:input></td>
            </tr>
            <tr>
                <td><form:label path="password">Password</form:label></td>
                <td><form:input path="password"></form:input></td>
            </tr>
            <tr>
                <td><form:button>Login</form:button></td>
            </tr>
        </table>

    </fieldset>
</form:form>
</body>
</html>
