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
</head>
<body>
<p>
  Welcome! <c:out value="${name}"> You can use the FoodieApp.
</c:out>
</p>
<p>
  <a href="/app">Let's get started</a>
</p>
</body>
</html>
