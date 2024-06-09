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
    <title>Review</title>
</head>
<body>
<form:form method="post" modelAttribute="review" action="/reviews/add">
<%--    <form:hidden path="users" value="${user}"/>--%>
    <form:hidden path="id"/>
    <label>Date:
        <form:input type="date" path="date"/>
    </label>
    <label>Restaurant:
        <form:select path="restaurant" itemLabel="name" itemValue="id" items="${restaurants}"/>
    </label>
    <label>Description:
        <form:textarea path="description" rows="5" cols="20"/>
        <form:errors path="description"/>
    </label>
    <hr/>
    <label>Rating:
        Food: <form:input type="number" name="ratingFood" min="1" max="10" path="ratingFood"/>
        <form:errors path="ratingFood"/>
        Service: <form:input type="number" name="ratingService" min="1" max="10" path="ratingService"/>
        <form:errors path="ratingService"/>
        Vibe: <form:input type="number" name="ratingVibe" min="1" max="10" path="ratingVibe"/>
        <form:errors path="ratingVibe"/>
        General experience: <form:input type="number" name="ratingGenExperience" min="1" max="10" path="ratingGenExperience"/>
        <form:errors path="ratingGenExperience"/>
    </label>
    <hr/>
    <form:button>Save</form:button>
</form:form>
</body>
</html>
