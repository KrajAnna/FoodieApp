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
    <title>Sign Up</title>
</head>
<body>
<form:form method="post" modelAttribute="user" action="/home/signup">
    <form:hidden path="id"/>
    <label>First name:
        <form:input path="firstName"/>
        <form:errors path="firstName"/>
    </label>

    <label>Last name:
        <form:input path="lastName"/>
        <form:errors path="lastName"/>
    </label>
    <hr/>
    <label>Email:
        <form:input path="email"/>
        <form:errors path="email"/>
    </label>
    <hr/>
    <label>Password:
        <form:input path="password"/>
        <form:errors path="password"/>
    </label>
    <hr/>
    <form:button>Save</form:button>
</form:form>
</body>
</html>
