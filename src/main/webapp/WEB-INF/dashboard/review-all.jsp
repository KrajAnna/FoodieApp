<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Reviews</title>
<%--    <style>--%>
<%--        table {--%>
<%--            width: 100%;--%>
<%--            border-collapse: collapse;--%>
<%--        }--%>
<%--        th, td {--%>
<%--            border: 1px solid black;--%>
<%--            padding: 8px;--%>
<%--            text-align: left;--%>
<%--        }--%>
<%--        th {--%>
<%--            background-color: #f2f2f2;--%>
<%--        }--%>
<%--    </style>--%>
</head>
<body>
<p>
    All reviews:
</p>
<table>
    <thead>
    <tr>
        <th>Date</th>
        <th>Rating avg</th>
        <th>Restaurant</th>
        <th>Check details</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach items="${reviews}" var="entry">
        <tr>
            <td>${entry.key.date}</td>
            <td>${entry.key.date}</td>
            <td>${entry.value.name}</td>
            <td><a href="/reviews/${entry.key.id}">View Details TBD</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<a href="/reviews/add">Add a new review!</a></br>
<a href="/reviews/all">Check all review!</a></br>
- sorted by rating - could be added</br>

</body>
</html>