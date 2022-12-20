<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
    prefix="decorator"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<title>EShop</title>
    <!-- CSS --> 	
	<link href="../templates/css/bootstrap.min.css" rel="stylesheet">
	<link href="../templates/css/dashboard.css" rel="stylesheet">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">
    <%@ include file="/common/vendor/header.jsp"%>
    
</head>

<body>
	<% if (session.getAttribute("storeId") != null) {%>
		<div class="container-fluid">
			<div class="row">
			<jsp:include page="/common/vendor/left.jsp"></jsp:include>
			<decorator:body/>
			</div>	
		</div>
	<%} else {%>
	<decorator:body/>	
	<% } %>
	<script src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js" integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE" crossorigin="anonymous"></script><script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js" integrity="sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha" crossorigin="anonymous"></script>
	<script src="../templates/js/bootstrap.bundle.min.js"></script>
	<script src="../templates/js/dashboard.js"></script>
</body>

<footer>
	<jsp:include page="/common/vendor/footer.jsp"></jsp:include>	
</footer>
</html>