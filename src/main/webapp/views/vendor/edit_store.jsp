<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
	<div class="container" style="padding: 18px 0;">

		<form action="store-edit" method="post" enctype="multipart/form-data">

			<div class="form-group">

				<label for="name">Tên cửa hàng:</label> <input type="text"
					class="form-control" value="${store.name}" name="name" id="name" />

			</div>

			<div class="form-group">

				<label for="avatar">Ảnh đại diện:</label> <input type="file"
					class="form-control" name="avatar" id="listImage" value="${store.avatar}" />

			</div>

			<div class="form-group">

				<label for="bio">Mô tả:</label> <input type="text"
					class="form-control" value="${store.bio}" name="bio"
					id="bio" />

			</div>

			<div class="form-group">

				<label for="EWallet">Ví điện tử:</label> <input type="text"
					class="form-control" value="${store.EWallet}" name="EWallet" id="EWallet" />

			</div>

			<div class="form-check form-check-inline">

				<label for="isActive">Trạng thái:</label>
				<div>
					<input id="statuson" class="form-check-input" type="radio"
						name="isActive" ${store.isActive?'checked':''} value="true"> <label
						for="statuson" class="form-check-label">Hoạt động</label>
				</div>

				<div>
					<input id="statusoff" class="form-check-input" type="radio"
						name="isActive" ${!store.isActive?'checked':''} value="false">
					<label for="statusoff" class="form-check-label">Khóa</label>
				</div>
			</div>

			<div class="form-group" style="padding: 18px 0; text-align: center;">
				<button class="btn btn-secondary" type="submit">
					Lưu<i class="fa fa-plus"></i>
				</button>
			</div>
		</form>
	</div>
</main>