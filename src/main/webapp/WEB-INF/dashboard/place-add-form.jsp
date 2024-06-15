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
    <title>Restaurants</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<%@include file="static_elements/headerLog.jsp" %>
<div class="container mt-4">
    <div class="row justify-content-center">
        <div class="col-md-6 bg-light p-4 rounded shadow-sm">
            <h4 class="text-dark text-center">You are adding new restaurant</h4>
        </div>
    </div>
</div>

<form:form method="post" modelAttribute="restaurant" action="/places/add">
    <form:hidden path="id"/>
    <div class="container mt-2">
        <div class="mb-3">
            <label for="name" class="form-label"><strong>Name</strong></label>
            <form:input path="name" id="name" class="form-control"/>
            <form:errors path="name" class="text-danger"/>
        </div>
        <hr/>
        <div class="mb-3">
            <label for="address" class="form-label"><strong>Address</strong></label>
            <form:input path="address" id="address" class="form-control"/>
            <form:errors path="address" class="text-danger"/>
        </div>
        <hr/>
    </div>
    <div class="container mt-2">
        <form:button class="btn btn-secondary mt-3">Submit</form:button>
    </div>
</form:form>
</body>
</html>
