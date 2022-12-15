<%--
  Created by IntelliJ IDEA.
  User: toan
  Date: 24/11/2022
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<html>
<head>
    <title>Title</title>
</head>
<body>
 <c:forEach var="review" items="${reviews}">
     <p>${review.content} - ${review.stars}</p>
 </c:forEach>

</body>
</html>
