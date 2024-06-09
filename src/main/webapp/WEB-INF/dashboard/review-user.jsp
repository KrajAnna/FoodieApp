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
    <c:forEach items="${userReviews}" var="entryOuter">
        <tr>
            <td>${entryOuter.value.name}</td>
            <c:forEach items="${entryOuter.key}" var = "entryInner">
                <td>${entryInner.key.date}</td>
                <td>${entryInner.value}</td>
                <td><a href="/reviews/${entryInner.key.id}">View Details TBD</a></td>
            </c:forEach>
        </tr>
    </c:forEach>
    </tbody>
</table>

<a href="/reviews/add">Add a new review!</a></br>
<a href="/reviews/all">Check all review!</a></br>
- sorted by rating - could be added</br>

</body>
</html>