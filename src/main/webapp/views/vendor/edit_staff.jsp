<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">

	<div class="container">

		<form action="staff-edit" method="post" enctype="multipart/form-data">

			<div class="form-group" hidden="hidden">

				<label for="id">Mã nhân viên:</label> <input type="text" name="id"
					value="${user.id}" id="id" class="form-control" readonly />

			</div>

			<div class="form-group">

				<label for="lastName">Họ:</label> <input type="text"
					class="form-control" value="${user.lastName}" name="lastName"
					id="lastName" />

			</div>

			<div class="form-group">

				<label for="firstName">Tên:</label> <input type="text"
					class="form-control" value="${user.firstName}" name="firstName"
					id="firstName" />

			</div>

			<div class="form-group">

				<label for="avatar">Ảnh đại diện:</label> <input type="file"
					class="form-control" value="${user.avatar}" name="avatar"
					id="avatar" />

			</div>

			<div class="form-group">

				<label for="idCard">Số CCCD:</label> <input type="text"
					class="form-control" value="${user.idCard}" name="idCard"
					id="idCard" />

			</div>

			<div class="form-group">

				<label for="email">Email:</label> <input type="text"
					class="form-control" value="${user.email}" name="email" id="email" />

			</div>

			<div class="form-group">

				<label for="phone">Số điện thoại:</label> <input type="text"
					class="form-control" value="${user.phone}" name="phone" id="phone" />

			</div>

			<div class="form-group">

				<label for="addresses">Địa chỉ:</label> <input type="text"
					class="form-control" value="${user.addresses}" name="addresses"
					id="addresses" />

			</div>

			<div class="form-group" style="text-align: center; padding-top: 18px;"> 

				<button class="btn btn-secondary" type="submit">
					Lưu<i class="fa fa-plus"></i>
				</button>

			</div>

		</form>
	</div>
</main>