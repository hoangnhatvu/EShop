<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/admin/stores/update" var="update"></c:url>
<c:url value="/admin/stores/view" var="home"></c:url>

<body>


	<div class="container">
		<div class="row">
			<div class="col">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="${home }">Home</a></li>
						<li class="breadcrumb-item active" aria-current="page">Store</li>
					</ol>
				</nav>
			</div>
		</div>
	</div>

	<div class="container">
		<div class="row">
			<!-- Image -->
			<div class="col-12 col-lg-6">
				<div class="card bg-light mb-3">
					<div class="card-body">
						<div>
							<div class="mb-4 d-flex justify-content-center">
								<img class="img-fluid" src="<c:url value="${store.avatar}"/>"
									<%-- ${product.listIFmage} --%>
									alt="Chưa có ảnh" />

							</div>



						</div>
					</div>
				</div>
			</div>

			<!-- Add to cart -->
			<div class="col-12 col-lg-6 add_to_cart_block">
				<div class="card bg-light mb-3">
					<div class="card-body">
						<p class="text-center fw-bold fs-2">${store.name}</p>

						<form role="form" action="${update}" method="post"
							enctype="multipart/form-data">

							<c:if test="${store.id == 0}">

								<div class="mb-3">
									<label for="productname" class="form-label">Store Id:</label> <input
										type="text" name="id" class="form-control" value=""
										aria-describedby="productName" readonly="true">
								</div>

							</c:if>

							<c:if test="${store.id != 0}">

								<div class="mb-3">
									<label for="productname" class="form-label">Store Id:</label> <input
										type="text" name="id" class="form-control" value="${store.id}"
										aria-describedby="productName" readonly="true">
								</div>

							</c:if>

							<div class="mb-3">
								<label for="productname" class="form-label">Store name:</label>
								<input type="text" name="name" class="form-control"
									value="${store.name}" aria-describedby="productName"
									placeholder="Enter store's name">
							</div>


							<div class="mb-3">
								<label for="productname" class="form-label">User's
									owner:</label> <select name="userId" class="form-select"
									aria-label="Default select example">

									<option selected value>${store.users.firstName}
										${store.users.lastName}</option>
									<c:forEach items="${users}" var="user">
										<c:if test="${user.role == 1}">
											<option value="${user.id}">${user.firstName}
												${user.lastName}</option>
										</c:if>
									</c:forEach>
								</select>
							</div>





							<div class="mb-3">
								<label for="productDescription" class="form-label">Bio:</label>
								<textarea class="form-control" rows="5" id="comment"
									placeholder="Enter store's bio" name='bio'>${store.bio } </textarea>


							</div>



							<div class="mb-3">
								<input type="file" class="form-control" name="avatar"
									value="${store.avatar}" placeholder="Enter photo">
							</div>

							<c:if test="${store.id == 0 }">
								<button type="submit" class="btn btn-primary">Add</button>
							</c:if>

							<c:if test="${store.id != 0 }">
								<button type="submit" class="btn btn-primary">Update</button>
							</c:if>


							<button type="reset" class="btn btn-primary">Reset</button>






							<!-- Lưu biến source image -->
							<input type="text" name="avatars" class="form-control"
								value="${store.avatar}" aria-describedby="productImage"
								readonly="true" hidden>

							<%-- <!-- Lưu biến Id cua Owner -->
							<input type="text" name="userId" class="form-control"
								value="${store.users.id}" aria-describedby="productImage"
								readonly="true"> --%>


						</form>



						</form>



					</div>
				</div>
			</div>
		</div>





	</div>

	<!-- Site meta -->
	<meta charset="utf-8">
	<meta name="viewport"
		content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<!-- CSS -->
	<link
		href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
		rel="stylesheet" type="text/css">
	<link
		href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
		rel="stylesheet" type="text/css">
	<link href="//fonts.googleapis.com/css?family=Open+Sans:400,300,600"
		rel="stylesheet" type="text/css">
	<link href="css/style.css" rel="stylesheet" type="text/css">




</body>



