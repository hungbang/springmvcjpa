<%--
  Created by IntelliJ IDEA.
  User: kyo
  Date: 12/01/2018
  Time: 19:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>List Users</title>
</head>
<body>
    <h2>ALl USERS IN DATA</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>UserName</th>
            <th>PassWord</th>
            <th>Email</th>
            <th>Active</th>
            <th>LinkConfig</th>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.password}</td>
                <td>${user.email}</td>
                <td>${user.active}</td>
                <td>${user.linkConfirm}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
