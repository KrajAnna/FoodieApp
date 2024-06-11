<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Access denied</title>
</head>
<body>

<h2>Login Failed</h2>
<p>Invalid username or password. Please try again.</p>
<a href="${pageContext.request.contextPath}/login">Go back to Login Page</a>
<a href="${pageContext.request.contextPath}/home/signup">Sign up</a>


</body>
</html>
