<%--
  Created by IntelliJ IDEA.
  User: toan
  Date: 15/12/2022
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<div class="container-fluid pt-5">
  <div class="text-center mb-4">
    <h2 class="section-title px-5"><span class="px-2">Sản phẩm mới nhất</span></h2>
  </div>
  <div class="row px-xl-5 pb-3">
    <c:forEach var="prod" items="${arrivalProd}">
      <c:set var="prod" value="${prod}" scope="request"/>
      <c:import url="/views/user-template/include/productBox.jsp"/>
    </c:forEach>
  </div>
</div>
