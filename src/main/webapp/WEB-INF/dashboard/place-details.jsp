<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Restaurant Details</title>
</head>
<body>
<p>
    Here you can check restaurant ${restaurant.name} details:
</p>
Address: ${restaurant.address}</br>
TU MUSI BYC TOTAL RATING RESTAURACJI</br>

Reviews list:
<table>
    <thead>
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
            <td><a href="/reviews/${reviewRate.review.id}">View Details</a></td>

        </tr>
    </c:forEach>
    </tbody>

</table>
<p>
    <a href="/places">Go back to the restaurants list</a>
</p>
</body>
</html>