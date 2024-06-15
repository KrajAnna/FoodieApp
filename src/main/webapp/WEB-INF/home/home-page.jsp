<%--
  Created by IntelliJ IDEA.
  User: anna
  Date: 6/1/24
  Time: 12:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FoodieApp</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>
<%@include file="header.jsp"%>
<div class="container mt-5">
    <h3> Welcome in FoodieApp! </h3>
    <h5>Let's get started</h5>
<p>
    <a href="/login" class="btn btn-primary mt-3">Login </a>

    <a href="/home/signup" class="btn btn-primary mt-3"> Sign up</a>
</p>
</div>
</body>
</html>
