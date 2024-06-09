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

<c:forEach items="${review}" var="entry">
    Restaurant: TBD
    <hr/>
    Data: ${entry.key.date}
    <hr/>
    Food: ${entry.key.ratingFood}
    <hr/>
    Service: ${entry.key.ratingService}
    <hr/>
    Vibe: ${entry.key.ratingVibe}
    <hr/>
    General experience: ${entry.key.ratingGenExperience}
    <hr/>
    Total rating: ${entry.value}
    <hr/>
</c:forEach>
<p>
    <a href="/reviews">Go back to the reviews list</a>
</p>
</body>
</html>