<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
	<div class="container" style="padding: 18px 0;">

		<form action="product-edit" method="post" enctype="multipart/form-data">

			<div class="form-group" hidden="hidden">

				<label for="id">Mã sản phẩm:</label> <input type="text" name="id"
					value="${product.id}" id="id" class="form-control" readonly />

			</div>

			<div class="form-group">

				<label for="name">Tên sản phẩm:</label> <input type="text"
					class="form-control" value="${product.name}" name="name" id="name" />

			</div>

			<div class="form-group">

				<label for="listImage">Ảnh:</label> <input type="file"
					class="form-control" name="listImage" value="${user.id}"
					id="listImage" value="${product.listImage}" />

			</div>

			<div>
				<label for="categoryId">Loại:</label> <select class="form-select"
					name="categoryId" id="categoryId">

					<c:forEach var="item" items="${categoryList}">
						<option value="${item.id}">${item.name}</option>
					</c:forEach>
					
				</select>
			</div>

			<div class="form-group">

				<label for="desciption">Mô tả:</label> <input type="text"
					class="form-control" value="${product.desciption}" name="desciption"
					id="desciption" />

			</div>

			<div class="form-group">

				<label for="price">Giá:</label> <input type="text"
					class="form-control" value="${product.price}" name="price" id="price" />

			</div>

			<div class="form-group">

				<label for="promotionalPrice">Giá khuyến mãi:</label> <input type="text"
					class="form-control" value="${product.promotionalPrice}" name="price" id="price" />

			</div>

			<div class="form-group">

				<label for="quantity">Số lượng:</label> <input type="text"
					class="form-control" value="${product.quantity}" name="quantity"
					id="quantity" />

			</div>

			<div class="form-check form-check-inline">

				<label for="isActive">Trạng thái:</label>
				<div>
					<input id="statuson" class="form-check-input" type="radio"
						name="isActive" ${product.isActive?'checked':''} value="true"> <label
						for="statuson" class="form-check-label">Hoạt động</label>
				</div>

				<div>
					<input id="statusoff" class="form-check-input" type="radio"
						name="isActive" ${!product.isActive?'checked':''} value="false">
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