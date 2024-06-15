<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Access denied</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>
<%@include file="header.jsp"%>
<h2>Login Failed</h2>
<p>Invalid username or password. Please try again.</p>
<a href="${pageContext.request.contextPath}/login">Go back to Login Page</a>
<a href="${pageContext.request.contextPath}/home/signup">Sign up</a>


</body>
</html>
