<%@ page import="hcmute.vn.entity.Category" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: toan
  Date: 15/12/2022
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="col-lg-3 d-none d-lg-block">
  <a class="btn shadow-none d-flex align-items-center justify-content-between bg-primary text-white w-100" data-toggle="collapse" href="#navbar-vertical" style="height: 65px; margin-top: -1px; padding: 0 30px;">
    <h6 class="m-0">Danh mục</h6>
    <i class="fa fa-angle-down text-dark"></i>
  </a>
  <nav class="collapse show navbar navbar-vertical navbar-light align-items-start p-0 border border-top-0 border-bottom-0" id="navbar-vertical">
    <div class="navbar-nav w-100 overflow-hidden" style="height: 410px">
      <%--<div class="nav-item dropdown">
        <a href="#" class="nav-link" data-toggle="dropdown">Dresses <i class="fa fa-angle-down float-right mt-1"></i></a>
        <div class="dropdown-menu position-absolute bg-secondary border-0 rounded-0 w-100 m-0">
          <a href="" class="dropdown-item">Men's Dresses</a>
          <a href="" class="dropdown-item">Women's Dresses</a>
          <a href="" class="dropdown-item">Baby's Dresses</a>
        </div>
      </div>--%>
      <% List<Category> categories=(List<Category>)session.getAttribute("categories"); %>
      <c:forEach var="cate" items="<%=categories%>">
      <a href="<%=request.getContextPath()%>/product?cateId=${cate.id}" class="nav-item nav-link">${cate.name}</a>
      </c:forEach>
    </div>
  </nav>
</div>
