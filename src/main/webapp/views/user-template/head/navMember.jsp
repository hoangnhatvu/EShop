<%--
  Created by IntelliJ IDEA.
  User: toan
  Date: 15/12/2022
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<nav class="navbar navbar-expand-lg bg-light navbar-light py-3 py-lg-0 px-0">
  <a href="<%=request.getContextPath()%>" class="text-decoration-none d-block d-lg-none">
    <h1 class="m-0 display-5 font-weight-semi-bold"><span class="text-primary font-weight-bold border px-3 mr-1">E</span>Shop</h1>
  </a>
  <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
    <div class="navbar-nav mr-auto py-0">
      <a href="<%=request.getContextPath()%>" class="nav-item nav-link active">Trang chủ</a>
      <a href="<%=request.getContextPath()%>/product" class="nav-item nav-link">Sản phẩm</a>
      <a href="<%=request.getContextPath()%>/contact" class="nav-item nav-link">Liên hệ</a>
    </div>
    <div class="navbar-nav ml-auto py-0">
      <c:if test="${empty sessionScope.userId}">
      <a href="<%=request.getContextPath()%>/login" class="nav-item nav-link">Đăng nhập</a>
      <a href="<%=request.getContextPath()%>/sign_up" class="nav-item nav-link">Đăng ký</a>
      </c:if>
      <c:if test="${fn:length(sessionScope.userId) > 0}">
        <a href="<%=request.getContextPath()%>/account" class="nav-item nav-link">${sessionScope.userName}</a>
        <a href="<%=request.getContextPath()%>/logout" class="nav-item nav-link">Đăng xuất</a>
      </c:if>
    </div>
  </div>
</nav>
