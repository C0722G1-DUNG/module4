<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/21/2022
  Time: 11:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/sandwich" method="post">
    <input type="checkbox" name="choise" value="lettuce" >Lettuce
    <input type="checkbox" name="choise" value="tomato" >Tomato
    <input type="checkbox" name="choise" value="mustard" >Mustard
    <input type="checkbox" name="choise" value="sprouts" >Sprouts
    <input type="submit">
  </form>
  <p> kết quả là : ${result}</p>
  </body>
</html>
