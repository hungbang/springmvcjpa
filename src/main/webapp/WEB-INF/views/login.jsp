<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href='<c:url value="/resources/css/style.css"/>' type="text/css" media="all">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<div class="header-w3l">
    <h1>
        <span>L</span>ogin
        <span>F</span>orm</h1>
</div>
<!---728x90--->
<!--//header-->
<div class="main-content-agile">
    <div class="sub-main-w3">
        <h2>Login Here</h2>
        <form action="login" method="POST">
            <%--<input type="hidden"--%>
                   <%--name="${_csrf.parameterName}"--%>
                   <%--value="${_csrf.token}"/>--%>
            <div class="pom-agile">
                <span class="fa fa-user-o" aria-hidden="true"></span>
                <input placeholder="E-mail" name="username" class="user" type="email" required="">
            </div>
            <div class="pom-agile">
                <span class="fa fa-key" aria-hidden="true"></span>
                <input placeholder="Password" name="password" class="pass" type="password" required="">
            </div>
            <div class="sub-w3l">
                <div class="sub-agile">
                    <input type="checkbox" id="brand1" value="">
                    <label for="brand1">
                        <span></span>Remember me</label>
                </div>
                <a href="https://p.w3layouts.com/demos_new/template_demo/23-12-2017/creative_login_form-demo_Free/1749241113/web/index.html#">Forgot Password?</a>
                <div class="clear"></div>
            </div>
            <div class="right-w3l">
                <input type="submit" value="Login">
            </div>
        </form>
    </div>
</div>
<!--//main-->
<!---728x90--->
<!--footer-->
<div class="footer">
    <p>© 2018 Creative Login Form. All rights reserved | Design by
        <a href="http://w3layouts.com/">W3layouts</a>
    </p>
</div>
</body>
</html>
