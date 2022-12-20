<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/templates/" var="URL"></c:url>

<c:url value="/admin" var="admin"></c:url>

<h1 class="visually-hidden">Sidebars examples</h1>






<div class="flex-shrink-0 p-3 bg-light" style="width: 280px;">

	<svg class="bi pe-none me-2" width="30" height="24">
		<use xlink:href="" /></svg>
	<span class="fs-5 fw-semibold">Admin</span> </a>
	<ul class="list-unstyled ps-0">
		<li class="mb-1">
			<button
				class="btn btn-toggle d-inline-flex align-items-center rounded border-0 collapsed"
				data-bs-toggle="collapse" data-bs-target="#home-collapse"
				aria-expanded="true">Shop management</button>
			<div class="collapse show" id="home-collapse">
				<ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
					<li><a href="${admin }/products/view"
						class="link-dark d-inline-flex text-decoration-none rounded">View
							products</a></li>
					<li><a href="${admin }/users/view"
						class="link-dark d-inline-flex text-decoration-none rounded">View
							users</a></li>
					<li><a href="${admin }/stores/view"
						class="link-dark d-inline-flex text-decoration-none rounded">View
							stores</a></li>
				</ul>
			</div>
		</li>
		<li class="mb-1">
			<button
				class="btn btn-toggle d-inline-flex align-items-center rounded border-0 collapsed"
				data-bs-toggle="collapse" data-bs-target="#dashboard-collapse"
				aria-expanded="false">System managemnet</button>
			<div class="collapse" id="dashboard-collapse">
				<ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
					<li><a href="${admin}/categories/view"
						class="link-dark d-inline-flex text-decoration-none rounded">View
							categories</a></li>
					<li><a href="${admin}/styles/view"
						class="link-dark d-inline-flex text-decoration-none rounded">View
							styles</a></li>
					<li><a href="${admin}/deliveries/view"
						class="link-dark d-inline-flex text-decoration-none rounded">View
							delivery units</a></li>
					<li><a href="${admin}/deliveries/view"
						class="link-dark d-inline-flex text-decoration-none rounded">View
							delivery units</a></li>
					<li><a href="${admin}/commissions/view"
						class="link-dark d-inline-flex text-decoration-none rounded">View
							commissions</a></li>
				</ul>
			</div>
		</li>
		<li class="mb-1">
			<button
				class="btn btn-toggle d-inline-flex align-items-center rounded border-0 collapsed"
				data-bs-toggle="collapse" data-bs-target="#orders-collapse"
				aria-expanded="false">Dashboard</button>
			<div class="collapse" id="orders-collapse">
				<ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
					<li><a href="#"
						class="link-dark d-inline-flex text-decoration-none rounded">Revenue
							statistics</a></li>
			</div>
		</li>



		<li class="border-top my-3"></li>
		<li class="mb-1">
			<button
				class="btn btn-toggle d-inline-flex align-items-center rounded border-0 collapsed"
				data-bs-toggle="collapse" data-bs-target="#account-collapse"
				aria-expanded="false">Account</button>
			<div class="collapse" id="account-collapse">
				<ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
					<li><a href="#"
						class="link-dark d-inline-flex text-decoration-none rounded">New...</a></li>
					<li><a href="#"
						class="link-dark d-inline-flex text-decoration-none rounded">Profile</a></li>
					<li><a href="#"
						class="link-dark d-inline-flex text-decoration-none rounded">Settings</a></li>
					<li><a href="#"
						class="link-dark d-inline-flex text-decoration-none rounded">Sign
							out</a></li>
				</ul>
			</div>
		</li>
	</ul>
</div>
<div class=" b-example-vr"></div>