<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/vendor" var="link"></c:url>
<% if (session.getAttribute("storeId")== null) {%>
   <header class="p-3 text-bg-dark">
    <div class="container">
      <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
        <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
          <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"/></svg>
        </a>

        <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
          <li><a href="#" class="nav-link px-2 text-white">Trang chủ</a></li>
          <li><a href="${link}/store" class="nav-link px-2 text-white">Cửa hàng</a></li>
          <li><a href="#" class="nav-link px-2 text-white">Sản phẩm</a></li>
          <li><a href="#" class="nav-link px-2 text-white">Liên hệ</a></li>
          <li><a href="#" class="nav-link px-2 text-white">Về chúng tôi</a></li>
        </ul>

        <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" role="search">
          <input type="search" class="form-control form-control-dark text-bg-dark" placeholder="Search..." aria-label="Search">
        </form>
        
		<% if( (String)session.getAttribute("ownerId") != null) {%>
	        <div class="text-end">
	        <a href="../user/sign_out">
	          <button type="button" class="btn btn-outline-light me-2">Đăng xuất</button>
	          </a>
	        </div>
        <% }else { %>
        	<div class="text-end">
        	  <a href="../user/login">
	          	<button type="button" class="btn btn-outline-light me-2">Đăng nhập</button>
	          </a>
	          <a href="../user/sign_up">
	          	<button type="button" class="btn btn-warning">Đăng ký</button>
	          </a>
	        </div>
        <% } %>
      </div>
    </div>
  </header>
<% } else {%>
<header
	class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
	<a class="navbar-brand col-md-3 col-lg-2 me-0 px-3 fs-6" href="${link}/home">Trang chủ</a>
	<button class="navbar-toggler position-absolute d-md-none collapsed"
		type="button" data-bs-toggle="collapse" data-bs-target="#sidebarMenu"
		aria-controls="sidebarMenu" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="navbar-nav" style="background-color: #333333; padding: 6px 0">
		<div class="nav-item text-nowrap">
			<a class="nav-link px-3" href="../user/sign_out">Đăng xuất</a>
		</div>
	</div>
</header>
<% } %>