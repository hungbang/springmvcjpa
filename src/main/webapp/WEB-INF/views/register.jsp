<%--
  Created by IntelliJ IDEA.
  User: minhnhat
  Date: 1/13/18
  Time: 10:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Website CSS style -->
    <link rel="stylesheet" href='<c:url value="/resources/css/register.css"/>' type="text/css" media="all">
    <!-- Website Font style -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
    <!-- Google Fonts -->
    <link href='https://fonts.googleapis.com/css?family=Passion+One' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Register</title>
</head>
<body>
<div class="container">
    <div class="row main">
        <div class="main-login main-center">
            <h5>Sign up once and watch any of our free demos.</h5>
            <%--<form class="" method="post" action="/register">--%>
            <form:form method="POST" action="/register" modelAttribute="user">
                <div class="form-group">
                    <label for="email" class="cols-sm-2 control-label">Your Email</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                            <%--<input type="email" class="form-control" name="email" id="email"  placeholder="Enter your Email" />--%>
                            <form:input path="username" type="email" cssClass="form-control" name="email" id="email"  placeholder="Enter your Email" required="required"/>
                            <form:errors path="username" cssClass="error"/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="password" class="cols-sm-2 control-label">Password</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                            <%--<input type="password" class="form-control" name="password" id="password"  placeholder="Enter your Password" required/>--%>
                            <form:input path="password" type="password" class="form-control" name="password" id="password"  placeholder="Enter your Password" required="required"/>
                            <form:errors path="password" cssClass="error"/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="confirm" class="cols-sm-2 control-label">Confirm Password</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                            <%--<input type="password" class="form-control" name="confirm" id="confirm"  placeholder="Confirm your Password" required/>--%>
                            <form:input path="confirmPassword" type="password" class="form-control" name="confirm" id="confirm"  placeholder="Confirm your Password" required="required"/>
                            <form:errors path="confirmPassword" cssClass="error"/>
                        </div>
                    </div>
                </div>

                <div class="form-group ">
                    <input type="submit" class="btn btn-success btn-lg btn-block login-button" value="Register"/>
                </div>

            </form:form>
        </div>
    </div>
</div>
</body>
</html>
