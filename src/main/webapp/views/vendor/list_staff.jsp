<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4"
	style="padding: 32px 0">

	<div class="container">
		<div class="row">
			<form action="staff" method="post" class="col">
				<div class="input-group col" style="padding-bottom: 16px">

					<div class="form-group">
						<input type="text" name="searching" id="searching"
							class="form-control" />
					</div>

					<div class="form-group">
						<button type="submit" value="submit" class="btn btn-secondary">
							<i class="bi bi-search"></i>
						</button>
					</div>
				</div>
			</form>
			<div class="col" style="height: 100%; text-align: right;">
				<a href="../vendor/staff-add">
					<button type="button" class="btn btn-secondary" style="width:158px;"> Thêm nhân viên </button>	
				</a>		
			</div>
		</div>
		
		<table class="table table-striped table-bordered table-hover"
			id="sample_2">

			<thead>

				<tr>

					<th>Ảnh đại diện</th>

					<th>Tên nhân viên</th>

					<th>Email</th>

					<th>Số điện thoại</th>

					<th>Hành động</th>

				</tr>

			</thead>

			<tbody>

				<c:forEach var="item" items="${staffList}">

					<tr class="odd gradeX">

						<td><c:url value="/image?fname=user/${item.users.avatar}"
								var="imgUrl"></c:url> <img width="50px" height="50px"
							src="${imgUrl}"></td>

						<td>${item.users.firstName}</td>

						<td>${item.users.email}</td>

						<td>${item.users.phone}</td>

						<td><a style="color: black;"
							href="<c:url value='/vendor/staff-delete?id=${item.id}'/>"
							class="center"><i class="bi bi-trash"></i></a> <a
							style="color: black;"
							href="<c:url value='/vendor/staff-edit?id=${item.id}'/>"
							class="center"><i class="bi bi-pencil-square"></i></a></td>

					</tr>

				</c:forEach>

			</tbody>

		</table>

	</div>
</main>
