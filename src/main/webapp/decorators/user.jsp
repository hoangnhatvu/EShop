<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<!-- Site meta -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>EShop</title>
    <!-- CSS -->
	<link href="../templates/css/bootstrap.min.css" rel="stylesheet">	
    <%@ include file="/common/user/header.jsp"%>
</head>

<body>	

	<decorator:body/>
	
</body>

<footer>
	<jsp:include page="/common/user/footer.jsp"></jsp:include>	
	<script src="../templates/js/bootstrap.bundle.min.js"></script>	
</footer>
</html>