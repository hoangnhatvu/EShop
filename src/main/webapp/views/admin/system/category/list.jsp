<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/admin/categories/update/" var="update"></c:url>


<body>




	<div class="container">

		<section class="row">

			<div class="col mt-4">

				<div class="card">

					<div class="card-header text-center fs-2 fw-bold">
						List of categories <a type="button"
							href="<c:url value='/admin/categories/add'/>"
							class="btn btn-secondary float-end">Add category</a>
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

									<th class="text-center">Category name</th>

									<th class="text-center">Creatation date</th>
									
									<th class="text-center">Update date</th>
									
									<th class="text-center">Root category</th>
									
									<th class="text-center">Action</th>



								</tr>

							</thead>

							<tbody>

								<c:forEach items="${categories}" var="cate" varStatus="STT">

									<tr>

										<td><p class="text-center">${STT.index+1}</p></td>
										<td><p class="text-center">${cate.name}</p></td>
										<td><p class="text-center">${cate.createAt}</p></td>
										<td><p class="text-center">${cate.updateAt}</p></td>
										<c:if test="${cate.category.name == null }">
											<td><p class="text-center">Is root category</p></td>
										</c:if>
										<c:if test="${cate.category.name != null }">
											<td><p class="text-center">${cate.category.name}</p></td>
										</c:if>
										<td>
											<div class="text-center">
												<a
													href="<c:url value='/admin/categories/update?id=${cate.id }'/>"
													class="btn btn-outline-info"><i class="fa fa-edit"></i>Sửa</a>
												<a
													href="<c:url value='/admin/categories/delete?id=${cate.id }'/>"
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
