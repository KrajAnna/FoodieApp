<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Reviews</title>
</head>
<body>
<p>
    Your reviews:
</p>
<table>
    <thead>
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
            <td><a href="/reviews/${reviewRate.review.id}">View Details</a></td>

        </tr>
    </c:forEach>
    </tbody>
</table>

<a href="/reviews/add">Add a new review!</a></br>
<a href="/reviews/all">Check all reviews!</a></br>
- sorted by rating - could be added</br>

</body>
</html>