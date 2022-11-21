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
                <input name="chose"  value="Addition(+)" id="1" type="submit">
            </th>
            <th>
                <input  name="chose" value="Subtraction(-)" id="2" type="submit">
            </th>
            <th>
                <input name="chose" value="Multiplication(x)" id="3" type="submit">
            </th>
            <th>
                <input name="chose" value="Division(/)" id="4"  type="submit">
            </th>
        </tr>
    </table>
</form>
<p> kết quả : ${result}</p>

<%--<p id="ketqua1"></p>--%>
<%--&lt;%&ndash;<c:choose>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <c:when test="Addition(+)">&ndash;%&gt;--%>

<%--&lt;%&ndash;    </c:when>&ndash;%&gt;<p id="ketqua"></p>--%>

<%--&lt;%&ndash;    <c:when test="Subtraction(-)">&ndash;%&gt;--%>
<%--&lt;%&ndash;        <p>kết quả là : ${result2}</p>&ndash;%&gt;--%>
<%--&lt;%&ndash;    </c:when>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <c:when test="Multiplication(x)">&ndash;%&gt;--%>
<%--&lt;%&ndash;        <p>kết quả là : ${result3}</p>&ndash;%&gt;--%>
<%--&lt;%&ndash;    </c:when>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <c:when test="Division(/)">&ndash;%&gt;--%>
<%--&lt;%&ndash;        <p>kết quả là : ${result4}</p>&ndash;%&gt;--%>

<%--&lt;%&ndash;    </c:when>&ndash;%&gt;--%>
<%--&lt;%&ndash;</c:choose>&ndash;%&gt;--%>
<%--<script>--%>
<%--    function myf() {--%>
<%-- // let a = document.getElementById("numberOne").value  ;--%>
<%-- // a = Number(a);--%>
<%-- //   let b =     document.getElementById("numberTwo").value ;--%>
<%-- //   b= Number(b);--%>
<%--   document.getElementById("ketqua").innerHTML = "kết quả là"+ ${result1};--%>
<%--    }--%>
<%--    function myT() {--%>
<%--document.getElementById("ketqua1").innerHTML = "kết quả là " + ${result2} ;--%>
<%--    }--%>
<%--</script>--%>
</body>

</html>
