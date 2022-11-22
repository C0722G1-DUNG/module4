<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/22/2022
  Time: 2:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table class="table">
    <thead>
    <tr>
        <th>STT</th>
        <th>languages</th>
        <th>pageSize</th>
        <th>spamsFiller</th>
        <th>signature</th>
        <th>UPDATE</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="email" items="${emailList}">
        <tr>
            <td>${email.id}</td>
            <td>${email.languages}</td>
            <td>${email.pageSize}</td>
            <td>${email.spamsFiller}</td>
            <td>${email.signature}</td>
            <td>
                <a class="btn btn-danger" href="/update?id=${email.id}">UPDATE</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
