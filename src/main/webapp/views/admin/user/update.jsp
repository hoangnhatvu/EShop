<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/admin/users/" var="preAction"></c:url>
<c:url value="/admin/users/view" var="home"></c:url>

<body>


	<div class="container">
		<div class="row">
			<div class="col">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="${home }">Home</a></li>
						<li class="breadcrumb-item active" aria-current="page">User</li>
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
								<img class="img-fluid" src="<c:url value="${user.avatar}"/>"
									<%-- ${product.listImage} --%>
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
						<p class="text-center fw-bold fs-2" name="firstName">${user.firstName}
						</p>
						<p class="text-center fw-bold fs-2" name="lastName">
							${user.lastName }</p>
						<form role="form" action="${preAction}${action}" method="post"
							enctype="multipart/form-data">

							<c:if test="${user.id == 0}">

								<div class="mb-3">
									<label for="productname" class="form-label">User Id:</label> <input
										type="text" name="id" class="form-control" value=""
										aria-describedby="productName" readonly="true">
								</div>

							</c:if>

							<c:if test="${user.id != 0}">

								<div class="mb-3">
									<label for="productname" class="form-label">User Id:</label> <input
										type="text" name="id" class="form-control" value="${user.id}"
										aria-describedby="productName" readonly="true">
								</div>

							</c:if>

							<c:if test="${user.id == null}">

								<div class="mb-3">
									<label for="productname" class="form-label">Fisrt Name:</label>
									<input type="text" name="firstName" class="form-control"
										value="${user.firstName}" aria-describedby="productName"
										placeholder="Enter user's first name">
								</div>

							</c:if>
							<c:if test="${user.id == null}">

								<div class="mb-3">
									<label for="productname" class="form-label">Last Name:</label>
									<input type="text" name="lastName" class="form-control"
										value="${user.lastName}" aria-describedby="productName"
										placeholder="Enter user's last name">
								</div>

							</c:if>





							<div class="mb-3">
								<label for="productname" class="form-label">Email: </label> 
								<input
									type="text" name="email" class="form-control"
									value="${user.email}" aria-describedby="productName"
									placeholder="Enter user's email">
							</div>

							<c:if test="${user.id == null }">

								<label for="productname" class="form-label">Password: </label>

								<input type="password" name="hashedPassword"
									class="form-control" value="${user.hashedPassword }"
									aria-describedby="productName"
									placeholder="Enter user's password">

							</c:if>
							<div class="mb-3">
								<label for="productPrice" class="form-label">Phone
									number: </label> <input type="text" name="phone" class="form-control"
									value="${user.phone}" aria-describedby="productPrice"
									placeholder="Enter user's phone number">
							</div>





							<div class="mb-3">
								<label for="productDescription" class="form-label">Address:</label>
								<input class="form-control" name="addresses"
									value="${user.addresses }" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Enter user's address">


							</div>

							<div class="mb-3">
								<label value for="productPrice" class="form-label">Role:
								</label>
								<c:if test="${user.role == null}">
									<select name="role" class="form-select form-select-sm mb-3"
										aria-label=".form-select-lg example">
										<option value="1">Vendor</option>
										<option value="2">User</option>
										<option value="3">Admin</option>
									</select>
								</c:if>
								<c:if test="${user.role != null}">

									<select class="form-select form-select-sm mb-3"
										aria-label=".form-select-lg example" disabled>
										<c:if test="${user.role == 1} ">
											<option selected>Vendor</option>
										</c:if>
										<c:if test="${user.role == 2}">
											<option selected>User</option>
										</c:if>
										<c:if test="${user.role == 3}">
											<option selected>Admin</option>
										</c:if>
										<option value="1">Vendor</option>
										<option value="2">User</option>
										<option value="3">Admin</option>
									</select>
								</c:if>
							</div>




							<div class="mb-3">
								<input type="file" class="form-control" name="avatarImage"
									value="${user.avatar}" placeholder="Enter photo">
							</div>

							<c:if test="${user.id == null }">
								<button type="submit" class="btn btn-primary">Add</button>
							</c:if>

							<c:if test="${user.id != null }">
								<button type="submit" class="btn btn-primary">Update</button>
							</c:if>


							<button type="reset" class="btn btn-primary">Reset</button>






							<!-- Lưu biến source image -->
							<input type="text" name="avatar" class="form-control"
								value="${user.avatar}" aria-describedby="productImage"
								readonly="true" hidden>
							<!-- Lưu biến firstname -->
							<input type="text" name="firstName" class="form-control"
								value="${user.firstName}" aria-describedby="productImage"
								readonly="true" hidden>
							<!-- Lưu biến lastname -->
							<input type="text" name="lastName" class="form-control"
								value="${user.lastName}" aria-describedby="productImage"
								readonly="true" hidden>

							<c:if test="${user.id != null }">
								<!-- Lưu biến hashedpass -->
								<input type="text" name="hashedPassword" class="form-control"
									value="${user.hashedPassword}" aria-describedby="productImage"
									readonly="true" hidden>
							</c:if>


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



