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
        <div class="col-md-6 bg-light p-4 rounded shadow-sm">
            <h4 class="text-dark text-center">You are adding new restaurant</h4>
        </div>
    </div>
</div>
<div class="container mt-4">
    <div class="row justify-content-center">
        <div class="col-md-6 text-center">
        <div class="col-md-6 bg-light p-4 rounded shadow-sm">
            <a class="text-dark text-center" href="/places">Go back to the restaurants list</a>
        </div>
    </div>
</div>

</body>
</html>