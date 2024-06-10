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
    </tbody>
</table>
</body>
</html>