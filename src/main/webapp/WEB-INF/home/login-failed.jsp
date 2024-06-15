<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Access denied</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>
<%@include file="header.jsp"%>

<div class="container mt-4">
    <div class="row justify-content-center">
        <div class="col-md-6 bg-light p-4 rounded shadow-sm d-flex align-items-center justify-content-center">
            <h2>Login Failed</h2>
        </div>
    </div>
    <div class="row justify-content-center">
        <div class="col-md-6 bg-light p-4 rounded shadow-sm d-flex align-items-center justify-content-center">
            <p> Invalid username or password. Please try again </p>
        </div>
    </div>
    <div class="row justify-content-center">
        <div class="col-md-6 bg-light p-4 rounded shadow-sm d-flex align-items-center justify-content-center">
            <a href="/login" class="btn btn-secondary">Login Page</a>
            <a href="/home/signup" class="btn btn-secondary">Sign up</a>
        </div>
    </div>

</body>
</html>
