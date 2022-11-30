<%--
  Created by IntelliJ IDEA.
  User: toan
  Date: 24/11/2022
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<!--Pagination-->
<div class="">
    <ul class="pagination pull-right">
        <c:if test="${tag>1}">
            <li><a href="${pageContext.request.contextPath }/product?index=${tag-1}">&laquo;</a></li>
        </c:if>
        <c:forEach begin="1" end="${endP}" var="i">
            <li class='${tag==i?"active":"" }'><a
                    href="${pageContext.request.contextPath}/product?index=${i}">${i}</a></li>
        </c:forEach>
        <c:if test="${tag<endP}">
            <li><a href="${pageContext.request.contextPath}/product?index=${tag+1}">&raquo;</a></li>
        </c:if>
    </ul>
</div>
</body>
</html>
