<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container"  style="padding-top: 36px;">

	<div class="row">
		<form action="store" method="post" class="col" >
			<div class="input-group col" style="padding-bottom: 16px">
			
				<div class="form-group">
					<input type="text" name="searching" id="searching" class="form-control" />
				</div>
				
				<div class="form-group">		
					<button type="submit" class="btn btn-secondary">
						<i class="bi bi-search"></i>
					</button>
				</div>
			</div>
		</form>
		<div class="col" style="height: 100%; text-align: right;">
			<a href="../vendor/store-add">
				<button type="button" class="btn btn-secondary"
					style="width: 158px;">Thêm cửa hàng</button>
			</a>
		</div>
	</div>
	
	<table class="table table-striped table-bordered table-hover"
		id="sample_2">

		<thead>

			<tr>

				<th>Ảnh đại diện</th>

				<th>Tên cửa hàng</th>

				<th>Mô tả</th>

				<th>Trạng thái</th>

				<th>Hành động</th>

			</tr>

		</thead>

		<tbody>

			<c:forEach var="item" items="${storeList}">

				<tr class="odd gradeX">

					<td><c:url value="/image?fname=store/${item.avatar}"
							var="imgUrl"></c:url> <img width="50px" height="50px"
						src="${imgUrl}"></td>

					<td><a href="<c:url value='/vendor/dashboard?id=${item.id}'/>"
						style="text-decoration: none; color: #212529">${item.name}</a></td>

					<td>${item.bio }</td>

					<td><c:if test="${item.isActive == true}">

							<span class="label label-sm label-success"> Hoạt động </span>

						</c:if> <c:if test="${item.isActive ==false}">

							<span class="label label-sm label-warning"> Khóa </span>

						</c:if></td>

					<td><a style="color: black;" href="<c:url value='/vendor/store-delete?id=${item.id}'/>"
						class="center"><i class="bi bi-trash"></i></a></td>

				</tr>

			</c:forEach>

		</tbody>

	</table>

</div>
