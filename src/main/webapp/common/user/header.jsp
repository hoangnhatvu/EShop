<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:url value="/templates/" var="URL"></c:url>


<!DOCTYPE html>
<html>
<!-- Head Start -->
<jsp:include page="../views/user-template/header.jsp"/>
<jsp:include page="../views/user-template/head/topBar.jsp"/>
<div class="container-fluid mb-5">
  <div class="row border-top px-xl-5">
      <jsp:include page="../views/user-template/head/categoryList.jsp">
          <jsp:param name="categories" value="${categories}"/>
      </jsp:include>
    <div class="col-lg-9">
      <jsp:include page="../views/user-template/head/navMember.jsp"/>