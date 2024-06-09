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
    <c:forEach items="${reviewsRat}" var="entryOuter">
        <tr>
            <td>${entryOuter.value.name}</td>
            <c:forEach items="${entryOuter.key}" var = "entryInner">
            <td>${entryInner.key.date}</td>
            <td>${entryInner.value}</td>
            <td><a href="/reviews/${entryInner.key.id}">Check Details</a></td>
            </c:forEach>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>