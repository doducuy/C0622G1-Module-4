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
<h3>Sandwich Condiments</h3>
<form action="/condiment">
    <pre>Choose condiment you want:</pre>
    <pre>
        <table>
            <tr>
                <input type="checkbox" name="lettuce" value="Lettuce">Lettuce</input>
                <input type="checkbox" name="tomato" value="Tomato">Tomato</input>
                <input type="checkbox" name="mustard" value="Mustard">Mustard</input>
                <input type="checkbox" name="sprouts" value="Sprouts">Sprouts</input>
            </tr>
        </table>

    </pre>
    <pre>Condiments You Choose: ${lettuce} ${tomato} ${mustard} ${sprouts}</pre>
    <input type="submit" value="Save!">
</form>
</body>  
</html>
