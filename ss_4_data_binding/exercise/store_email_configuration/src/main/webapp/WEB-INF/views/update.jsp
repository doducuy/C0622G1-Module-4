<%--
  Created by IntelliJ IDEA.
  User: LAPTOP ACER
  Date: 17-10-2022
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2 style="color: red">Update Success!!!</h2>
<pre>Language:      ${configuration.getLanguage()}</pre>
<pre>Page Size:     ${configuration.getPageSize()} </pre>
<pre>Spam filter:   ${configuration.getSpamFilter()}</pre>
<pre>Signature:     ${configuration.getSignature()}</pre>
<a href="/home">Back</a>
<pre></pre>
</body>
</html>
