<%--
  Created by IntelliJ IDEA.
  User: kyo
  Date: 12/01/2018
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <title>Add Users Form</title>
</head>

<body>
<h2>Add New User</h2>
<br/>
<form:form method="post" modelAttribute="user">
    <table>
        <tr>
            <td>UserName</td>
            <td><form:input path="username" /></td>
        </tr>
        <tr>
            <td>password</td>
            <td><form:input path="password" /></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><form:input path="email" /></td>
        </tr>
            <tr>
                <td>Active</td>
                <td><form:input path="active" /></td>
            </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
