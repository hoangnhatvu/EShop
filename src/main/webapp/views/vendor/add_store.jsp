<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="container">
	
	<div class="form-group">

		<label for="categoryname">Store Name:</label> <input type="text"
			class="form-control" name="name" id="name"
			value="" />

	</div>

	<div class="form-group">

		<label for="categorycode">Biography:</label> <input type="text"
			class="form-control" name="bio"
			value="" id="bio" />

	</div>

	<div class="form-group">

		<label for="images">Avatar:</label> <input type="file"
			class="form-control" name="avatar" id="avatar"
			value="" />

	</div>

	<div class="form-check form-check-inline">

		<label for="status">Status:</label>
		<div>
			<input id="statuson" class="form-check-input" type="radio"
				name="isActive" value="true">
			<label for="statuson" class="form-check-label">Hoạt động</label>
		</div>

		<div>
			<input id="statusoff" class="form-check-input" type="radio"
				name="isActive" value="false">
			<label for="statusoff" class="form-check-label">Khóa</label>
		</div>

	</div>
</div>