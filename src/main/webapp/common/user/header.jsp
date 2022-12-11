<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:url value="/templates/" var="URL"></c:url>

<link href="${URL}css/headers.css" rel="stylesheet/css">

   <header>
     <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
    <div class="px-3 py-2 text-bg-dark">
      <div class="container">
        <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
          <a href="/" class="d-flex align-items-center my-2 my-lg-0 me-lg-auto text-white text-decoration-none">
            <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"/></svg>
          </a>

          <ul class="nav col-12 col-lg-auto my-2 justify-content-center my-md-0 text-small">
            <li>
              <a href="#" class="nav-link text-secondary">
                <svg class="bi d-block mx-auto mb-1" width="24" height="24"><use xlink:href="#home"/></svg>
                Home
              </a>
            </li>
            <li>
              <a href="#" class="nav-link text-white">
                <svg class="bi d-block mx-auto mb-1" width="24" height="24"><use xlink:href="#speedometer2"/></svg>
                Dashboard
              </a>
            </li>
            <li>
              <a href="<%=request.getContextPath()%>/order" class="nav-link text-white">
                <svg class="bi d-block mx-auto mb-1" width="24" height="24"><use xlink:href="#table"/></svg>
                Orders
              </a>
            </li>
            <li>
              <a href="<%=request.getContextPath()%>/product" class="nav-link text-white">
                <svg class="bi d-block mx-auto mb-1" width="24" height="24"><use xlink:href="#grid"/></svg>
                Products
              </a>
            </li>
            <li>
              <a href="<%=request.getContextPath()%>/account" class="nav-link text-white">
                <svg class="bi d-block mx-auto mb-1" width="24" height="24"><use xlink:href="#people-circle"/></svg>
                <c:if test="${empty sessionScope.userId}">
                  Customer
                </c:if>
                ${sessionScope.userName}
              </a>
            </li>
          </ul>
        </div>
      </div>
    </div>
    <div class="px-3 py-2 border-bottom mb-3">
      <div class="container d-flex flex-wrap justify-content-center">
        <form action="<%=request.getContextPath()%>/search" method="post" class="col-12 col-lg-auto mb-2 mb-lg-0 me-lg-auto" role="search">
          <input type="search" name="searchString" class="form-control rounded" placeholder="Search" aria-label="Search" aria-describedby="search-addon" />
          <button class="input-group-text border-0" id="search-addon"><i class="fa fa-search"></i></button>
        </form>

        <div class="text-end">
          <a href="<%=request.getContextPath()%>/userFollow"><button type="button" class="btn btn-primary">Follow</button></a>
          <a href="<%=request.getContextPath()%>/cart"><button type="button" class="btn btn-primary">Cart</button></a>
          <a href="<%=request.getContextPath()%>/login"><button type="button" class="btn btn-light text-dark me-2">Login</button></a>
          <a href="<%=request.getContextPath()%>/sign_up"><button type="button" class="btn btn-primary">Sign-up</button></a>
        </div>
      </div>
    </div>
  </header>