
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Restaurants</title>
</head>
<body>
You are adding review of ${restaurant.name}

<form:form method="post" modelAttribute="review" action="/places/review/${restaurant.id}">
    <form:hidden path="id"/>
<%--    <input type = "hidden" value="${restaurant.id}" name="restaurantId">--%>
    <label>Date:
        <form:input type="date" path="date"/>
    </label>
    <label>Description:
        <form:input type="textarea" path="description"/>
        <form:errors path="description"/>
    </label>
    <hr/>
    <label>Rating:
        Food: <form:input type="number" name="ratingFood" min="0" max="10" path="ratingFood"/>
        <form:errors path="ratingFood"/>
        Service: <form:input type="number" name="ratingService" min="0" max="10" path="ratingService"/>
        <form:errors path="ratingService"/>
        Vibe: <form:input type="number" name="ratingRestaurant" min="0" max="10" path="ratingRestaurant"/>
        <form:errors path="ratingRestaurant"/>
        General experience: <form:input type="number" name="ratingGenExperience" min="1" max="10" path="ratingGenExperience"/>
        <form:errors path="ratingGenExperience"/>
    </label>
    <hr/>
    <form:button>Save</form:button>


</form:form>
<p>
    Tu bedzie dodaj zalacznik - zdjęcia
</p>
</body>
</html>
