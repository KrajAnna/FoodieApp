<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Review Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<%@include file="static_elements/headerLog.jsp" %>


<div class="container mt-4">
    <div class="row justify-content-center">
        <div class="col-md-6 bg-light p-4 rounded shadow-sm">
            <h4 class="text-dark text-center">Check the review's details</h4>
        </div>
    </div>
</div>
<div class="container mt-4">
    <div class="row mb-3">
        <div class="col-md-2"><strong>Data:</strong></div>
        <div class="col-md-10">${reviewRate.review.date}</div>
    </div>
    <hr/>
    <div class="row mb-3">
        <div class="col-md-2"><strong>Food:</strong></div>
        <div class="col-md-10">${reviewRate.review.ratingFood}</div>
    </div>
    <hr/>
    <div class="row mb-3">
        <div class="col-md-2"><strong>Service:</strong></div>
        <div class="col-md-10">${reviewRate.review.ratingService}</div>
    </div>
    <hr/>
    <div class="row mb-3">
        <div class="col-md-2"><strong>Price:</strong></div>
        <div class="col-md-10">${reviewRate.review.ratingVibe}</div>
    </div>
    <hr/>
    <div class="row mb-3">
        <div class="col-md-2"><strong>General experience:</strong></div>
        <div class="col-md-10">${reviewRate.review.ratingGenExperience}</div>
    </div>
    <hr/>
    <div class="row mb-3">
        <div class="col-md-2"><strong>Total rating:</strong></div>
        <div class="col-md-10">${reviewRate.rating}</div>
    </div>
    <hr/>
    <div class="row mb-3">
        <div class="col-md-2"><strong>Description:</strong></div>
        <div class="col-md-10">${reviewRate.review.description}</div>
    </div>
    <hr/>
    <div class="row mb-3">
        <div class="col-md-2"><strong>Restaurant:</strong></div>
        <div class="col-md-10">${reviewRate.review.restaurant.name} -> <a
                class="link-secondary link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover"
                href="/places/${reviewRate.review.restaurant.id}">See more reviews</a></div>
    </div>
    <hr/>
</div>



<div class="container mt-4">
    <div class="row justify-content-center">
        <div class="col-md-6 bg-light p-4 rounded shadow-sm d-flex align-items-center justify-content-center">
            <a href="/reviews" class="btn btn-secondary mt-3" >Go back to the reviews list!</a></br>
        </div>
    </div>
</div>
</body>
</html>