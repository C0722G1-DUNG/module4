<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/18/2022
  Time: 11:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/convert/add" method="post">
<%--            <input type="text" name="vnd" placeholder="đổi tiền vnd ra usd">--%>
            <input type="text" name="usd" placeholder="đổi tiền từ usd ra vnd">
      <select>
      <option>
      </option>
    </select>
    <input type="submit" value="convert">
  </form>
<%--  <p> kết quả là ${kq1}</p>--%>
  <p> kết quả là ${kq2}</p>
  </body>
</html>
