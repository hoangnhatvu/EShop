<%--
  Created by IntelliJ IDEA.
  User: toan
  Date: 15/12/2022
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<div class="container-fluid pt-5">
  <div class="row px-xl-5 pb-3">
  <c:set var="count" value="0"/>
  <c:forEach var="cate" items="${categories}">
    <c:if test="${count lt 6}">
      <div class="col-lg-4 col-md-6 pb-1">
        <div class="cat-item d-flex flex-column border mb-4" style="padding: 30px;">
          <p class="text-right">15 Sản phẩm</p>
          <a href="<%=request.getContextPath()%>/product?cateId=${cate.id}" class="cat-img position-relative overflow-hidden mb-3">
            <img class="img-fluid-cate" src="${cate.image}" alt="">
          </a>
          <h5 class="font-weight-semi-bold m-0">${cate.name}</h5>
        </div>
      </div>
      <c:set var="count" value="${count + 1}"/>
    </c:if>
  </c:forEach>
  </div>
</div>
