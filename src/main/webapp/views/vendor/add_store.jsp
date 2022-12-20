<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="container" style="padding-top: 36px;">

	<form action="store-add" method="post" enctype="multipart/form-data">

		<div class="form-group">

			<label for="name">Tên cửa hàng:</label> <input type="text"
				class="form-control" name="name" id="name" />

		</div>

		<div class="form-group">

			<label for="bio">Mô tả:</label> <input type="text"
				class="form-control" name="bio" id="bio" />

		</div>

		<div class="form-group">

			<label for="avatar">Ảnh đại diện:</label> <input type="file"
				class="form-control" name="avatar" id="avatar" />

		</div>

		<div class="form-check form-check-inline">

			<label for="isActive">Trạng thái:</label>
			<div>
				<input id="statuson" class="form-check-input" type="radio"
					name="isActive" value="true"> <label for="statuson"
					class="form-check-label">Hoạt động</label>
			</div>

			<div>
				<input id="statusoff" class="form-check-input" type="radio"
					name="isActive" value="false"> <label for="statusoff"
					class="form-check-label">Khóa</label>
			</div>

		</div>

		<div class="form-group" style="padding: 18px 0; text-align: center;">
			<button class="btn btn-secondary" type="submit">
				Thêm<i class="fa fa-plus"></i>
			</button>
		</div>

	</form>
</div>