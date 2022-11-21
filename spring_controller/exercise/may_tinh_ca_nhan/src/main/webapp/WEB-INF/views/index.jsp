<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/20/2022
  Time: 11:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/computer" method="post">
    <input name="numberOne" placeholder="numberOne" type="text">
    <input name="numberTwo" placeholder="numberTwo" type="text">
    <table>
        <tr>
            <th>
                <input onclick="myf()"  value="Addition(+)" id="1" type="button">
            </th>
            <th>
                <input value="Subtraction(-)" id="2" type="button">
            </th>
            <th>
                <input value="Multiplication(x)" id="3" type="button">
            </th>
            <th>
                <input value="Division(/)" id="4"  type="button">
            </th>
        </tr>
    </table>
</form>
<p id="ketqua"></p>
<p id="ketqua1"></p>
<%--<c:choose>--%>
<%--    <c:when test="Addition(+)">--%>

<%--    </c:when>--%>
<%--    <c:when test="Subtraction(-)">--%>
<%--        <p>kết quả là : ${result2}</p>--%>
<%--    </c:when>--%>
<%--    <c:when test="Multiplication(x)">--%>
<%--        <p>kết quả là : ${result3}</p>--%>
<%--    </c:when>--%>
<%--    <c:when test="Division(/)">--%>
<%--        <p>kết quả là : ${result4}</p>--%>

<%--    </c:when>--%>
<%--</c:choose>--%>
<script>
    function myf() {
 // let a = document.getElementById("numberOne").value  ;
 // a = Number(a);
 //   let b =     document.getElementById("numberTwo").value ;
 //   b= Number(b);
   document.getElementById("ketqua").innerHTML = "kết quả là"+ ${result1};
    }
    function myT() {
document.getElementById("ketqua1").innerHTML = "kết quả là " + ${result2} ;
    }
</script>
</body>

</html>
