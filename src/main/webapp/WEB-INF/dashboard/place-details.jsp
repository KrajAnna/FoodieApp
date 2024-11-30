<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Restaurant Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<%@include file="static_elements/headerLog.jsp" %>

<div class="container mt-4">
    <div class="row justify-content-center">
        <div class="col-md-6 bg-light p-4 rounded shadow-sm d-flex align-items-center justify-content-center">
            <h4 class="text-dark text-center">Here you can check restaurant <strong>${restaurant.name} </strong>details and visits</h4>
        </div>
    </div>
</div>

<div class="container mt-2">
    <div class="table-container">
        <table class="table table-striped">
            <thead class="table-dark">
            <tr>
                <th>Date</th>
                <th>Rating Total</th>
                <th>Food</th>
                <th>Service</th>
                <th>Vibe</th>
                <th>Experience</th>
                <th>Check details</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${reviewRates}" var="reviewRate">
                <tr>
                    <td>${reviewRate.review.date}</td>
                    <td>${reviewRate.rating}</td>
                    <td>${reviewRate.review.ratingFood}</td>
                    <td>${reviewRate.review.ratingService}</td>
                    <td>${reviewRate.review.ratingVibe}</td>
                    <td>${reviewRate.review.ratingGenExperience}</td>
                    <td>
                        <a href="/reviews/${reviewRate.review.id}" class="btn btn-sm btn-primary">View Details</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<div class="container mt-4">
    <div class="row justify-content-center">
        <div class="col-md-6 bg-light p-4 rounded shadow-sm d-flex align-items-center justify-content-center">
            <a href="/places" class="btn btn-secondary">Go back to the restaurants list</a>
        </div>
    </div>
</div>
</body>
</html>