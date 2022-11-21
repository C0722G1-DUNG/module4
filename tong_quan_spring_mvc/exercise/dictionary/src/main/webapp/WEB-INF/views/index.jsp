<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/18/2022
  Time: 5:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/dictionary" method="post">
    <input type="text" placeholder="input search" name="dictionary">
    <button type="submit">Enter</button>
</form>
<p>Result: ${result}</p>
</body>
</html>
