<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Summary</title>
</head>
<body>
<p>
    Here you can check your statistic:
</p>


<hr/>
All visits: ${reviewsTotal}
Average rating: ${avgRate}
<hr/>
Visits by months:
<c:forEach items="${reviewsMonths}" var = "entry">
    ${entry.key} : ${entry.value}
</c:forEach>
Visits by years:
<c:forEach items="${reviewsYears}" var = "entry">
    ${entry.key} : ${entry.value}
</c:forEach>
</body>
</html>