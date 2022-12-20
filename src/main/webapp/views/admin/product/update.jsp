<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/admin/products/" var="preAction"></c:url>
<c:url value="/admin/products/view" var="home"></c:url>

<body>


	<div class="container">
		<div class="row">
			<div class="col">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="${home }">Home</a></li>
						<li class="breadcrumb-item active" aria-current="page">Product</li>
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
								<img class="img-fluid"
									src="<c:url value="${product.listImage}"/>"
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
						<p class="text-center fw-bold fs-2">${product.promotionalPrice }đ</p>
						<p class="text-decoration-line-through fs-2 text-center">${product.price }đ</p>

						<form role="form" action="${preAction}${action}" method="post"
							enctype="multipart/form-data">

							<c:if test="${product.id == 0}">

								<div class="mb-3">
									<label for="productname" class="form-label">Product Id:</label>
									<input type="text" name="id" class="form-control" value=""
										aria-describedby="productName" readonly="true">
								</div>

							</c:if>

							<c:if test="${product.id != 0}">

								<div class="mb-3">
									<label for="productname" class="form-label">Product Id:</label>
									<input type="text" name="id" class="form-control"
										value="${product.id}" aria-describedby="productName"
										readonly="true">
								</div>

							</c:if>




							<div class="mb-3">
								<label for="productname" class="form-label">Product
									name:</label> <input type="text" name="name" class="form-control"
									value="${product.name}" aria-describedby="productName"
									placeholder="Enter product's Name">
							</div>

							<div class="mb-3">
								<label for="productPrice" class="form-label">Product
									price:</label> <input type="text" name="price" class="form-control"
									value="${product.price}" aria-describedby="productPrice"
									placeholder="Enter product's Price">
							</div>

							<div class="mb-3">
								<label for="productPrice" class="form-label">Product
									promotionalPrice price:</label> <input type="text" class="form-control"
									name="promotionalPrice" value="${product.promotionalPrice}"
									aria-describedby="productpromotionalPrice"
									placeholder="Enter product's Promotional Price">
							</div>

							<div class="mb-3">
								<label for="productPrice" class="form-label">Quantity:</label> <input
									type="text" class="form-control" name="quantity" var="quan"
									value="${product.quantity}" aria-describedby="productQuantity"
									placeholder="Enter product's Quantity">

							</div>

							<div class="mb-3">
								<label for="productDescription" class="form-label">Description:</label>
								<textarea class="form-control" rows="5" id="comment"
									placeholder="Enter product's description" name=desciption>${product.desciption } </textarea>


							</div>


							<div class="mb-3">
								<input type="file" class="form-control" name="images"
									value="${product.listImage}" placeholder="Enter photo">
							</div> 

							<c:if test="${product.id == 0 }">
								<button type="submit" class="btn btn-primary">Add</button>
							</c:if>

							<c:if test="${product.id != 0 }">
								<button type="submit" class="btn btn-primary">Update</button>
							</c:if>


							<button type="reset" class="btn btn-primary">Reset</button>






							<!-- Lưu biến source image -->
							<input type="text" name="listImage" class="form-control"
								value="${product.listImage}" aria-describedby="productImage"
								readonly="true" hidden>

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



