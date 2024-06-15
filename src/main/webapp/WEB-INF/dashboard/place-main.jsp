<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <div class="col-md-6 bg-light p-4 rounded shadow-sm d-flex align-items-center justify-content-center">
            <h4 class="text-dark text-center">All restaurants</h4>
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
            <c:forEach items="${restaurants}" var="place">
                <tr>
                    <td>${place.name}</td>
                    <td>${place.address}</td>
                    <td>
                        <a href="/places/${place.id}" class="btn btn-sm btn-primary">View Details</a>
                    </td>
                    <td>
                        <a href="places/review/${place.id}" class="btn btn-sm btn-success">Add a visit and review</a>
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
            <a href="/places/add" class="btn btn-secondary">Add a new restaurant</a>
        </div>
    </div>
</div>
</body>
</html>