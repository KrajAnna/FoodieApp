
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
            <h4 class="text-dark text-center">You are adding review of ${restaurant.name}!</h4>
        </div>
    </div>
</div>


<form:form method="post" modelAttribute="review" action="/places/review/${restaurant.id}">
    <form:hidden path="id"/>
    <div class="container mt-2">
        <div class="mb-3">
            <label for="date" class="form-label"><strong>Date</strong></label>
            <form:input type="date" path="date" class="form-control"/>
            <form:errors path="date" class="text-danger"/>
        </div>
        <hr/>
        <div class="mb-3">
            <label for="description" class="form-label"><strong>Description</strong></label>
            <form:input type="textarea" path="description" class="form-control"/>
            <form:errors path="description" class="text-danger"/>
        </div>
        <hr/>
        <div class="mb-3">
            <label><strong>Rating</strong></label>
            <div class="row">
                <div class="col-md-3">
                    <label for="ratingFood" class="form-label">Food:</label>
                    <form:input type="number" name="ratingFood" min="0" max="10" path="ratingFood" class="form-control"/>
                    <form:errors path="ratingFood" class="text-danger"/>
                </div>
                <div class="col-md-3">
                    <label for="ratingService" class="form-label">Service:</label>
                    <form:input type="number" name="ratingService" min="0" max="10" path="ratingService" class="form-control"/>
                    <form:errors path="ratingService" class="text-danger"/>
                </div>
                <div class="col-md-3">
                    <label for="ratingVibe" class="form-label">Vibe:</label>
                    <form:input type="number" name="ratingVibe" min="0" max="10" path="ratingVibe" class="form-control"/>
                    <form:errors path="ratingVibe" class="text-danger"/>
                </div>
                <div class="col-md-3">
                    <label for="ratingGenExperience" class="form-label">General experience:</label>
                    <form:input type="number" name="ratingGenExperience" min="1" max="10" path="ratingGenExperience" class="form-control"/>
                    <form:errors path="ratingGenExperience" class="text-danger"/>
                </div>
            </div>
        </div>
        <hr/>
    </div>
    <div class="container mt-2">
        <button type="submit" class="btn btn-secondary mt-3">Save</button>
    </div>
</form:form>

</body>
</html>
