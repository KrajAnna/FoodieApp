<%--
  Created by IntelliJ IDEA.
  User: anna
  Date: 6/2/24
  Time: 6:27 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Sign Up</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>
<%@include file="header.jsp" %>
<form:form method="post" modelAttribute="user" action="/home/signup">
    <form:hidden path="id"/>
    <div class="container mt-2">
        <div class="mb-3">
            <label for="firstName" class="form-label">First name</label>
            <form:input path="firstName" id="firstName" class="form-control"/>
            <form:errors path="firstName"/>
        </div>
        <div class="mb-3">
            <label for="lastName" class="form-label">Last name</label>
            <form:input path="lastName" class="form-control"/>
            <form:errors path="lastName"/>
        </div>
        <div class="mb-3">
            <label for="email" class="form-label">Email</label>
            <form:input path="email" class="form-control" placeholder="name@example.com"/>
            <form:errors path="email"/>
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Password</label>
            <form:password path="password" class="form-control"/>
            <form:errors path="password"/>
        </div>

    </div>
    <div class="container mt-2">
        <button type="submit" class="btn btn-secondary mt-3">Submit</button>
    </div>
</form:form>
</body>
</html>
