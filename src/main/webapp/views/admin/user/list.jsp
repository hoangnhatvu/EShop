<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/admin/users/update/" var="update"></c:url>


<body>




	<div class="container">

		<section class="row">

			<div class="col mt-4">

				<div class="card">

					<div class="card-header text-center fs-2 fw-bold">
						List of Users <a type="button"
							href="<c:url value='/admin/users/add'/>"
							class="btn btn-secondary float-end">Add user</a>
					</div>



					<div class="card-body">

						<!-- Hiển thông báo -->

						<c:if test="${message != null}">

							<div class="alert alert-primary" role="alert">

								<i>${message}</i>

							</div>

						</c:if>

						<!-- Hêt thông báo -->

						<table class="table table-striped table-responsive">

							<thead class="thead-inverse">

								<tr>

									<th class="text-center">STT</th>

									<th class="text-center">Avatar</th>

									<th class="text-center">Full name</th>

									<th class="text-center">Phone number</th>

									<th class="text-center">Role</th>

									<th class="text-center">Action</th>

								</tr>

							</thead>

							<tbody>

								<c:forEach items="${users}" var="user" varStatus="STT">

									<tr>

										<td><p class="text-center">${STT.index+1}</p></td>

										<td><img class="mx-auto d-block" height="200" width="200"
											src="<c:url value="${user.avatar}"/>"></td>
										<td>

											<p class="text-center">${user.firstName}${user.lastName }</p>
										</td>
										<td>
											<p class="text-center  ">${user.phone }</p>

										</td>

										<td><c:if test="${user.role == 1}">
												<p class="text-center">Vendor</p></td>
										</c:if>

										<c:if test="${user.role == 2}">
											<p class="text-center">User</p>
											</td>
										</c:if>

										<c:if test="${user.role == 3}">
											<p class="text-center">Admin</p>
											</td>
										</c:if>

										<td>
											<div class="text-center">
												<a
													href="<c:url value='/admin/users/update?id=${user.id }'/>"
													class="btn btn-outline-info "><i class="fa fa-edit"></i>Sửa</a>
												<a
													href="<c:url value='/admin/users/delete?id=${user.id }'/>"
													class="btn btn-outline-danger"><i class="fa fa-trash"></i>Xóa</a>
											</div>

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
