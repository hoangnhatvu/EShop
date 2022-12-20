<%--
  Created by IntelliJ IDEA.
  User: toan
  Date: 19/12/2022
  Time: 23:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="media mb-4">
  <img src="${requestScope.review.user.avatar}" alt="Image" class="img-fluid mr-3 mt-1" style="width: 45px;">
  <div class="media-body">
    <h6>${requestScope.review.user.firstName} ${requestScope.review.user.lastName}<small> - <i>${requestScope.review.createAt}</i></small></h6>
    <div class="text-primary mb-2">
      <c:forEach begin="${1}" end="${requestScope.review.stars}">
        <small class="fa fa-star"></small>
      </c:forEach>
      <c:forEach begin="${requestScope.review.stars + 1}" end="${5}">
        <small class="far fa-star"></small>
      </c:forEach>
    </div>
    <p>${requestScope.review.content}</p>
  </div>
</div>
