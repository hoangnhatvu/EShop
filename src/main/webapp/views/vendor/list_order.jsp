<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4"
	style="padding: 32px 0">

	<div class="container">
		<div class="row">
			<div class="input-group col" style ="padding-bottom: 16px">
				<div class="form-outline">
					<input type="search" id="form1" class="form-control" />
				</div>
				<button type="button" class="btn btn-secondary">
					<i class="bi bi-search"></i>
				</button>
			</div>
		</div>
		
		<table class="table table-striped table-bordered table-hover"
			id="sample_2">

			<thead>

				<tr>

					<th>Người đặt</th>

					<th>Tổng tiền</th>

					<th>Địa chỉ</th>

					<th>Trạng thái</th>

					<th>Hành động</th>

				</tr>

			</thead>

			<tbody>

				<c:forEach var="item" items="${orderList}">

					<tr class="odd gradeX">

						<td>${item.users.firstName}</td>

						<td>${item.amountFromUser}</td>

						<td>${item.address}</td>
						
						<td><c:if test="${item.status == true}">

								<span class="label label-sm label-success"> Hoàn thành </span>

							</c:if> <c:if test="${item.status == false}">

								<span class="label label-sm label-warning"> Chờ duyệt </span>

							</c:if>
						</td>

						<td>
							<c:if test="${item.status == false}">					
								<a style="color: black;" href="<c:url value='/vendor/order-complete?id=${item.id}'/>"
								class="center"><i class="bi bi-check-lg"></i>
								</a>
							</c:if>
							<a style="color: black;" href="<c:url value='/vendor/order-delete?id=${item.id}'/>"
							class="center"><i class="bi bi-trash"></i></a> 
						</td>

					</tr>

				</c:forEach>

			</tbody>

		</table>

	</div>
</main>
