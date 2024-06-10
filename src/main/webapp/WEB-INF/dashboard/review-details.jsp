<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Review Details</title>
</head>
<body>
<p>
    Here you can check review's details:
</p>


<%--<c:forEach items="${review}" var="entryOuter">--%>
<%--    <c:forEach items ="${entryOuter.key}" var = "entryInner">--%>
<%--        Restaurant: ${entryOuter.value.name}--%>
<%--        <hr/>--%>
<%--        Data: ${entryInner.key.date}--%>
<%--        <hr/>--%>
<%--        Food: ${entryInner.key.ratingFood}--%>
<%--        <hr/>--%>
<%--        Service: ${entryInner.key.ratingService}--%>
<%--        <hr/>--%>
<%--        Vibe: ${entryInner.key.ratingVibe}--%>
<%--        <hr/>--%>
<%--        General experience: ${entryInner.key.ratingGenExperience}--%>
<%--        <hr/>--%>
<%--        Total rating: ${entryInner.value}--%>
<%--        <hr/>--%>
<%--    </c:forEach>--%>

<%--</c:forEach>--%>


Restaurant: TBD
<hr/>
Data: ${reviewRate.review.date}
<hr/>
Food: ${reviewRate.review.ratingFood}
<hr/>
Service: ${reviewRate.review.ratingService}
<hr/>
Vibe: ${reviewRate.review.ratingVibe}
<hr/>
General experience: ${reviewRate.review.ratingGenExperience}
<hr/>
Total rating: ${reviewRate.rating}
<hr/>
Description: ${reviewRate.review.description}
<hr/>

<p>
    <a href="/reviews">Go back to the reviews list</a>
</p>
</body>
</html>