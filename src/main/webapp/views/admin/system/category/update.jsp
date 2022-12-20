<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/admin/categories/update" var="update"></c:url>
<c:url value="/admin/categories/view" var="home"></c:url>

<body>


	<div class="container">
		<div class="row">
			<div class="col">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="${home }">Home</a></li>
						<li class="breadcrumb-item active" aria-current="page">Category</li>
					</ol>
				</nav>
			</div>
		</div>
	</div>

	<div class="container">
		<div class="row">
			<!-- Image -->
			<div class="col-12 col-lg-6"></div>

			<!-- Add to cart -->
			<div class="">
				<div class="card bg-light mb-3">
					<div class="card-body">

						<form role="form" action="${update}" method="post">

							<c:if test="${category.id == 0}">

								<div class="mb-3">
									<label for="productname" class="form-label">Category
										Id:</label> <input type="text" name="id" class="form-control"
										value="${category.id}" aria-describedby="productName"
										readonly="true">
								</div>

							</c:if>

							<c:if test="${category.id != 0}">

								<div class="mb-3">
									<label for="productname" class="form-label">Category
										Id:</label> <input type="text" name="id" class="form-control"
										value="${category.id}" aria-describedby="productName"
										readonly="true">
								</div>

							</c:if>

							<div class="mb-3">
								<label for="productname" class="form-label">Category
									name:</label> <input type="text" name="name" class="form-control"
									value="${category.name}" aria-describedby="productName"
									placeholder="Enter category's name">
							</div>


							<div class="mb-3">
								<label for="productname" class="form-label">Root
									category:</label> <select name="categoryId" class="form-select"
									aria-label="Default select example">
									<c:forEach items="${categories }" var="cate">
										<option value="${cate.id}">${cate.name}</option>
									</c:forEach>

								</select>
							</div>



							<c:if test="${category.id == null }">
								<button type="submit" class="btn btn-primary">Add</button>
							</c:if>

							<c:if test="${category.id != null }">
								<button type="submit" class="btn btn-primary">Update</button>
							</c:if>


							<button type="reset" class="btn btn-primary">Reset</button>





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



