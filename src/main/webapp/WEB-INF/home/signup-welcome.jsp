<%--
  Created by IntelliJ IDEA.
  User: anna
  Date: 6/3/24
  Time: 10:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>
<%@include file="header.jsp" %>

<div class="container mt-2">
    <h3>Welcome
        <c:out value="${user.firstName}!">! </c:out></h3>
    <h4>You can use the FoodieApp.</h4>

</div>

<div class="container mt-2">
    <p><a class="link-secondary link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover" href="/reviews">Let's get started</a></p>

</div>
</body>
</html>
