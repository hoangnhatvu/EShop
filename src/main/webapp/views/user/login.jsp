<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container">
	<div>
		<h1 style="text-align: center; padding: 50px;">Login</h1>
	</div>

	<div class="container" style="width: 50%; text-align: center;">
		<div class="alert alert-success" role="alert">Login successful</div>
		<form class="row g-3" role="form" action="login" method="post">
			
			<div class="col-12" style="text-align: left;">
				<label for="email" class="form-label">Email</label> <input
					name="email" type="email" class="form-control" id="email">
			</div>
			<div class="col-12" style="text-align: left;">
				<label for="password" class="form-label">Password</label> <input
					name="password" type="password" class="form-control" id="password">
			</div>
			<div class="col-12">
				<button type="submit" class="btn btn-primary">Login</button>
			</div>
		</form>
	</div>
</div>