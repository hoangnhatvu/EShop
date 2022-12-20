<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</div>
</div>
</div>
<div class="container">
	<div>
		<h1 style="text-align: center; padding: 50px;">Đăng ký</h1>
	</div>

	<div class="container" style="width: 50%; text-align: center;">
	
		<c:if test="${message != null}">

			<div class="alert alert-success" role="alert">${message}</div>

		</c:if>
	
		<form class="row g-3" role="form" action="sign_up" method="post">
			<div class="col-md-6" style="text-align: left;">
				<label for="firstName" class="form-label">Họ</label> <input
					type="text" name="firstName" class="form-control" id="firtName">
			</div>
			<div class="col-md-6" style="text-align: left;">
				<label for="lastName" class="form-label">Tên</label> <input
					type="text" name="lastName" class="form-control" id="lastName">
			</div>
			<div class="col-12" style="text-align: left;">
				<label for="email" class="form-label">Email</label> <input
					name="email" required="required" type="email" class="form-control" id="email">
			</div>
			<div class="col-12" style="text-align: left;">
				<label for="password" class="form-label">Mật khẩu</label> <input
					name="password" required="required" type="password" class="form-control" id="password">
			</div>
			<div class="col-12">
				<button type="submit" class="btn btn-primary">Đăng ký</button>
			</div>
		</form>
	</div>
</div>