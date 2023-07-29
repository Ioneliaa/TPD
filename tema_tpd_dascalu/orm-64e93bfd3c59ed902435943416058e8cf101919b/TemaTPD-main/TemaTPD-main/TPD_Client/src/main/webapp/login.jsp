<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    <%@include file="/css/login.css" %>
</style>
<head>
    <title>Login</title>
    <%--        <jsp:include page="utils/bootstrap.jsp"/>--%>
    <link href="utils/button_link.css" rel="stylesheet" type="text/css">
    <link href="utils/layout.css" rel="stylesheet" type="text/css">
    <link href="utils/alert_box.css" rel="stylesheet" type="text/css">
</head>
<body>

<div class="wrapper">
    <H1 class="title">Login / Register form</H1>
    <form method="post" action="${pageContext.request.contextPath}/login">
        <table>
            <tr>
                <td>
                    <label>Username:</label>
                    <input class="form-control" placeholder="Enter your username..." required name="username" type="text">
                </td>
            </tr>
            <tr>
                <td>
                    <label>Password:</label>
                    <input class="form-control" placeholder="Enter your password..." required name="password" type="password">
                </td>

            </tr>
        </table>
        <%--    <button name="button" type="submit" value="login">Login</button>--%>
        <div class="text-center text-lg-start mt-4 pt-2 form-buttons">
            <button class="form-button" value="login" name="button"
                    style="padding-left: 2.5rem; padding-right: 2.5rem;"
                    type="submit">
                Log In
            </button>

            <button class="form-button" name="button" type="submit" value="register">Register</button>

        </div>
    </form>

</div>
</body>
</html>
