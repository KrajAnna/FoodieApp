<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Restaurants</title>
</head>
<body>
<p>
    List of restaurants:
</p>
<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Address</th>
        <th>Details</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach items="${restaurants}" var="place">
        <tr>
            <td>${place.name}</td>
            <td>${place.address}</td>
            <td><a href="/places/${place.id}">View Details</a></td>
            <td><a href="places/review/${place.id}">Add a visit and review</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<a href="/places/add">Add a new place</a></br>
- sorted by rating - could be added</br>

</body>
</html>