<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Reviews</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<%@include file="static_elements/headerLog.jsp" %>


<div class="container mt-4">
    <div class="row justify-content-center">
        <div class="col-md-6 bg-light p-4 rounded shadow-sm">
            <h4 class="text-dark text-center">Check all reviews</h4>
        </div>
    </div>
</div>

<div class="container mt-2">
    <div class="table-container">
        <table class="table table-striped">
            <thead class="table-dark">
            <tr>
                <th>Restaurant</th>
                <th>Date</th>
                <th>Rating Total</th>
                <th>Check details</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${reviewRates}" var="reviewRate">
                <tr>
                    <td>${reviewRate.review.restaurant.name}</td>
                    <td>${reviewRate.review.date}</td>
                    <td>${reviewRate.rating}</td>
                    <td><a class="btn btn-sm btn-primary" href="/reviews/${reviewRate.review.id}">View Details</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</div>
<div class="container mt-4">
    <div class="row justify-content-center">
        <div class="col-md-6 bg-light p-4 rounded shadow-sm d-flex align-items-center justify-content-center">
            <a href="/reviews/add" class="btn btn-secondary mt-3" >Add a new review!</a></br>
        </div>
    </div>
</div>
</body>
</html>