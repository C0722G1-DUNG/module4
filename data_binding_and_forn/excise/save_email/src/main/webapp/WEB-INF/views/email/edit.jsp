<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/22/2022
  Time: 2:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/update" method="post" modelAttribute="email" >
    <form:hidden path="id"/>
   <form:select path="languages" items="${languagesList}">
   </form:select>

    <form:label path="pageSize">pageSize</form:label>
    <form:input path="pageSize"/>

    <form:label path="spamsFiller">spamsFiller</form:label>
    <form:input path="spamsFiller"/>

    <form:label path="signature">signature</form:label>
    <form:input path="signature"/>

    <input type="submit" value="luu">
</form>
</body>
</html>
