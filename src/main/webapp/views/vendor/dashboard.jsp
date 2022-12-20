<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/vendor" var="link"></c:url>

<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
	<div
		class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
		<h1 class="h2">${store.name}</h1>
		<div class="btn-toolbar mb-2 mb-md-0">
			<div class="btn-group me-2">
				<button type="button" class="btn btn-sm btn-outline-secondary">Xuất báo cáo</button>
			</div>
			<button type="button"
				class="btn btn-sm btn-outline-secondary dropdown-toggle">
				<span data-feather="calendar" class="align-text-bottom"></span> Tuần này
			</button>
		</div>
	</div>

	<canvas class="my-4 w-100" id="myChart" width="900" height="380"></canvas>
</main>
