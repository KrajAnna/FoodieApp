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
    <title>Review</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>

<%@include file="static_elements/headerLog.jsp" %>
<div class="container mt-4">
    <div class="row justify-content-center">
        <div class="col-md-6 bg-light p-4 rounded shadow-sm">
            <h4 class="text-dark text-center">You are adding the new review!</h4>
        </div>
    </div>
</div>
<form:form method="post" modelAttribute="review" action="/reviews/add">
    <%--    <form:hidden path="users" value="${user}"/>--%>
    <form:hidden path="id"/>
    <div class="container mt-2">
        <div class="mb-3">
            <label for="date" class="form-label"><strong>Date</strong></label>
            <form:input type="date" path="date" id="date" class="form-control"/>
            <form:errors path="date" class="text-danger"/>
        </div>
        <hr/>
        <div class="mb-3">
            <label for="restaurants" class="form-label"><strong>Restaurant</strong></label>
            <form:select path="restaurant" itemLabel="name" itemValue="id" items="${restaurants}" class="form-control"/>
            <small> <a href="/places/add" class="btn btn-sm  btn-secondary"> Add Restaurant</a></small>
        </div>
        <hr/>
        <div class="mb-3">
            <label for="description" class="form-label"><strong>Description</strong></label>
            <form:textarea path="description" id="description" class="form-control"/>
            <form:errors path="description" class="text-danger"/>
        </div>
        <hr/>
        <div class="mb-3">
            <label class="form-label"></label>
            <div class="row">
                <div class="col-md-3">
                    <label for="ratingFood" class="form-label">Food:</label>
                    <form:input type="number" name="ratingFood" min="1" max="10" path="ratingFood"
                                class="form-control"/>
                    <form:errors path="ratingFood" class="text-danger"/>
                </div>
                <div class="col-md-3">
                    <label for="ratingService" class="form-label">Service:</label>
                    <form:input type="number" name="ratingService" min="1" max="10" path="ratingService"
                                class="form-control"/>
                    <form:errors path="ratingService" class="text-danger"/>
                </div>
                <div class="col-md-3">
                    <label for="ratingVibe" class="form-label">Price:</label>
                    <form:input type="number" name="ratingVibe" min="1" max="10" path="ratingVibe"
                                class="form-control"/>
                    <form:errors path="ratingVibe" class="text-danger"/>
                </div>
                <div class="col-md-3">
                    <label for="ratingGenExperience" class="form-label">General experience:</label>
                    <form:input type="number" name="ratingGenExperience" min="1" max="10" path="ratingGenExperience"
                                class="form-control"/>
                    <form:errors path="ratingGenExperience" class="text-danger"/>
                </div>
            </div>
        </div>
        <hr/>
    </div>
    <div class="container mt-2">
        <form:button class="btn btn-secondary mt-3">Save</form:button>
    </div>
</form:form>

</body>
</html>
