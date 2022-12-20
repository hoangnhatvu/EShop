<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/admin/product/update/" var="update"></c:url>


<body>




	<div class="container">

		<section class="row">

			<div class="col mt-4">

				<div class="card">


					<div class="card-body">

						<!-- Hiển thông báo -->

						<c:if test="${message != null}">

							<div class="alert alert-primary" role="alert">

								<i>${message}</i>

							</div>

						</c:if>
						<div class="card-header text-center fs-2 fw-bold">
							List of orders <a type="button"
								href="<c:url value='/admin/orders/add'/>"
								class="btn btn-secondary float-end">Thêm SP</a>
						</div>

						<!-- Hêt thông báo -->

						<table class="table table-striped table-responsive">

							<thead class="thead-inverse">

								<tr>

									<th text-center>STT</th>

									<th class="text-center">User name</th>

									<th class="text-center">Store name</th>

									<th class="text-center">Delivery name</th>

									<th class="text-center">Commission name</th>

									<th class="text-center">Address</th>

									<th class="text-center">User phone number</th>

									<th class="text-center">Amount from user</th>

									<th class="text-center">Amount from store</th>

									<th class="text-center">Amount to store</th>

									<th class="text-center">Amount to GD</th>

									<th class="text-center">Create At</th>

									<th class="text-center">Update At</th>

									<th class="text-center">Action</th>

								</tr>

							</thead>

							<tbody>

								<c:forEach items="${orders}" var="order" varStatus="STT">

									<tr>

										<td><p class="text-center">${STT.index+1}</p></td>

										<td>${order.name}</td>
										<td>
											<p class="text-center fw-bold ">${product.promotionalPrice }đ</p>
											<p class="text-center text-decoration-line-through">${product.price}đ</p>
										</td>
										<td><img height="200" width="200"
											src="<c:url value="${product.listImage}"/>" /></td>
										<td><p class="text-center">${product.quantity}</p></td>

										<td><a
											href="<c:url value='/admin/products/update?id=${product.id }'/>"
											class="btn btn-outline-info"><i class="fa fa-edit"></i>Sửa</a>
											<a
											href="<c:url value='/admin/products/delete?id=${product.id }'/>"
											class="btn btn-outline-danger"><i class="fa fa-trash"></i>Xóa</a>
										</td>

									</tr>

								</c:forEach>

							</tbody>



						</table>



					</div>

				</div>

			</div>

		</section>
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
			crossorigin="anonymous"></script>

	</div>

</body>
