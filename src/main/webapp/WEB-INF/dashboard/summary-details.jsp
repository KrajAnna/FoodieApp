<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Summary</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<%@include file="static_elements/headerLog.jsp" %>


<div class="container mt-4">
    <div class="row justify-content-center">
        <div class="col-md-6 bg-light p-4 rounded shadow-sm">
            <h4 class="text-dark text-center">Here you can check your statistic</h4>
        </div>
    </div>
</div>

<%--<div class="container mt-2">--%>
<%--<hr/>--%>
<%--All visits: ${reviewsTotal}--%>
<%--Average rating: ${avgRate}--%>
<%--<hr/>--%>
<%--Visits by months:--%>
<%--<c:forEach items="${reviewsMonths}" var = "entry">--%>
<%--    ${entry.key} : ${entry.value}--%>
<%--</c:forEach>--%>
<%--Visits by years:--%>
<%--<c:forEach items="${reviewsYears}" var = "entry">--%>
<%--    ${entry.key} : ${entry.value}--%>
<%--</c:forEach>--%>
<%--</div>--%>

<div class="container mt-4">
    <div class="mb-3">
        <h5>All visits:</h5>
        <p>${reviewsTotal}</p>
    </div>
    <div class="mb-3">
        <h5>Average rating:</h5>
        <p>${avgRate}</p>
    </div>
    <hr/>
    <div class="mb-3">
        <h5>Visits by months:</h5>
        <c:forEach items="${reviewsMonths}" var="entry">
            <p class="ml-3">${entry.key} : ${entry.value}</p>
        </c:forEach>
    </div>
    <hr/>
    <div class="mb-3">
        <h5>Visits by years:</h5>
        <c:forEach items="${reviewsYears}" var="entry">
            <p class="ml-3">${entry.key} : ${entry.value}</p>
        </c:forEach>
    </div>
</div>

</body>
</html>