<%--
  Created by IntelliJ IDEA.
  User: anna
  Date: 6/2/24
  Time: 6:27 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Restaurants</title>
</head>
<body>
<form:form method="post" modelAttribute="restaurant" action="/places/add">
    <form:hidden path="id"/>
    <label>Name:
        <form:input path="name"/>
        <form:errors path="name"/>
    </label>
    <hr/>
    <label>Address:
        <form:input path="address"/>
        <form:errors path="address"/>
    </label>
    <hr/>
    <form:button>Save</form:button>
</form:form>
</body>
</html>
