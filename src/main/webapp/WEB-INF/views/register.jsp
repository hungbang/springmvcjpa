<%--
  Created by IntelliJ IDEA.
  User: Anh
  Date: 1/10/2018
  Time: 8:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href='<c:url value="/resources/css/register.css"/>' type="text/css" media="all">
</head>
<body>
<div data-vide-bg="video/awesome" style="position: relative;"><div style="position: absolute; z-index: -1; top: 0px; left: 0px; bottom: 0px; right: 0px; overflow: hidden; background-size: cover; background-repeat: no-repeat; background-position: 50% 50%; background-image: none;"><video autoplay="" loop="" muted="" style="margin: auto; position: absolute; z-index: -1; top: 50%; left: 50%; transform: translate(-50%, -50%); visibility: visible; width: auto; height: 884px;"><source src="/resources/video/awesome.mp4" type="video/mp4"></video></div>
    <div class="main-w3layouts center-container" style="height: 100%">
        <h1>Register Form</h1>

        <div class="main-agileinfo">
            <div class="agileits-top">
                <form action="/register" method="post">
                    <i class="fa fa-user-o" aria-hidden="true"></i>
                    <%--<input class="text" type="text" name="Username" placeholder="Username" required="">--%>
                    <input class="text email" type="text" name="userName" placeholder="Email" required="">
                    <input class="text" type="password" name="passWord" placeholder="Password" required="">
                    <%--<input class="text w3lpass" type="password" name="password" placeholder="Confirm Password" required="">--%>

                    <input type="submit" value="REGISTER">
                </form>
            </div>
        </div>


        <div class="w3copyright-agile">
            <h2>© 2017 Register Form. All rights reserved</h2>
        </div>
</body>
</html>
