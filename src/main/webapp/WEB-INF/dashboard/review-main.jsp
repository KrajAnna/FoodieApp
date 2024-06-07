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
        <th>Date</th>
        <th>Rating avg</th>
        <th>Check details</th>
        <th>Details</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach items="${reviews}" var="review">
        <tr>
            <td>${review.date}</td>
<%--            <td>${review.ratingAvg}</td>--%>
            <td><a href="/reviews/${review.id}">View Details TBD</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<a href="/reviews/add">Add a new review!</a></br>
- sorted by rating - could be added</br>

</body>
</html>