<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Review Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<%@include file="static_elements/headerLog.jsp" %>


<div class="container mt-4">
    <div class="row justify-content-center">
        <div class="col-md-6 bg-light p-4 rounded shadow-sm">
            <h4 class="text-dark text-center">Your account</h4>
        </div>
    </div>
</div>
<div class="container mt-4">
    <div class="row mb-3">
        <div class="col-md-2"><strong>First name</strong></div>
        <div class="col-md-10">${user.firstName}</div>
    </div>
    <hr/>
    <div class="row mb-3">
        <div class="col-md-2"><strong>Last name</strong></div>
        <div class="col-md-10">${user.lastName}</div>
    </div>
    <hr/>
    <div class="row mb-3">
        <div class="col-md-2"><strong>Email</strong></div>
        <div class="col-md-10">${user.email}</div>
    </div>
    <hr/>
    <div class="row mb-3">
        <div class="col-md-2"><strong>Your reviews:</strong></div>
        <div class="col-md-10">${reviewRate.review.restaurant.name}<a
                class="link-secondary link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover"
                href="/reviews">Link</a>
        </div>
    </div>
    <hr/>
</div>


<div class="container mt-4">
    <div class="row justify-content-center">
        <div class="col-md-6 bg-light p-4 rounded shadow-sm d-flex align-items-center justify-content-center">
            <a href="/reviews" class="btn btn-secondary mt-3">Go back to the reviews list</a></br>
        </div>
<%--        <div class="col-md-6 bg-light p-4 rounded shadow-sm d-flex align-items-center justify-content-center">--%>
<%--            <form th: action="/logout" method="post">--%>
<%--                <button type="submit">Wyloguj się</button>--%>
<%--            </form>--%>
<%--            <a href="/logout" class="btn btn-secondary mt-3">Log out</a></br>--%>
<%--        </div>--%>
    </div>
</div>
</body>
</html>