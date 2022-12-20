<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
	<div class="container" style = "padding: 18px 0;">

		<form action="staff-add" method="post" enctype="multipart/form-data">

			<div class="form-group">

				<label for="firstName">Tên:</label> <input type="text"
					class="form-control" name="firstName" id="firstName" />

			</div>

			<div class="form-group">

				<label for="lastName">Họ:</label> <input type="text"
					class="form-control" name="lastName" id="lastName" />

			</div>

			<div class="form-group">

				<label for="email">Email:</label> <input type="text"
					class="form-control" name="email" id="email" />

			</div>

			<div class="form-group">

				<label for="password">Mật khẩu:</label> <input type="text"
					class="form-control" name="password" id="password" />

			</div>

			<div class="form-group">

				<label for="phone">Số điện thoại:</label> <input type="text"
					class="form-control" name="phone" id="phone" />

			</div>

			<div class="form-group" style = "padding: 18px 0; text-align: center;">
				<button class="btn btn-secondary" type="submit">
					Thêm<i class="fa fa-plus"></i>
				</button>
			</div>

		</form>
	</div>
</main>