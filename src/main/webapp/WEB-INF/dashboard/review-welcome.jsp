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
<div class="container mt-2">
    <h3>
        Congrats!  New reviews was added to database.
    </h3>
</div>

<div class="container mt-2">
    <p><a class="btn btn-secondary mt-3" href="/reviews/all">Go back to the all reviews list</a></p>

</div>
</body>
</html>