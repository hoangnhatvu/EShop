<%--
  Created by IntelliJ IDEA.
  User: toan
  Date: 22/11/2022
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Sản phẩm</h2>
<c:if test="${fn:length(productList) <= 0}">
    <h3>Không tìm thấy sản phẩm</h3>
</c:if>
<table>
    <thead>
    <tr>
        <th>STT</th>
        <th>Tên</th>
        <th>Giá</th>
        <th>Giá khuyến mãi</th>
        <th>Thêm vào giỏ hàng</th>
        <th>Theo dõi</th>
        <th>Danh gia</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="prod" items="${productList}" varStatus="STT">
        <tr class = "odd gradeX">
            <td>${STT.index + 1}</td>
            <td>${prod.name}</td>
            <td>${prod.price}</td>
            <td>${prod.promotionalPrice}</td>
            <td><a href="<%=request.getContextPath()%>/product/addToCart?productId=${prod.id}">Add</a></td>
            <td><a href="<%=request.getContextPath()%>/followProduct?productId=${prod.id}">Follow</a></td>
            <td><a href="<%=request.getContextPath()%>/product/review?productId=${prod.id}">${prod.rating}</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<h2>Cửa hàng</h2>
<c:if test="${fn:length(storeList) <= 0}">
    <h3>Không tìm thấy cửa hàng</h3>
</c:if>
<table>
    <thead>
    <tr>
        <th>STT</th>
        <th>Ảnh</th>
        <th>Tên</th>
        <th>Mô tả</th>
        <th>Đánh giá</th>
        <th>Theo dõi</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="store" items="${storeList}" varStatus="STT">
        <tr class = "odd gradeX">
            <td>${STT.index + 1}</td>
            <td><img width="50px" height="50px"src="${store.avatar}"></td>
            <td>${store.name}</td>
            <td>${store.bio}</td>
            <td>${store.rating}</td>
            <td><a href="<%=request.getContextPath()%>/followStore?storeId=${store.id}">Follow</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<h2>Người dùng</h2>
<c:if test="${fn:length(userList) <= 0}">
    <h3>Không tìm thấy người dùng</h3>
</c:if>
<table>
    <thead>
    <tr>
        <th>STT</th>
        <th>Ảnh</th>
        <th>Tên</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${userList}" varStatus="STT">
        <tr class = "odd gradeX">
            <td>${STT.index + 1}</td>
            <td><img width="50px" height="50px"src="${user.avatar}"></td>
            <td>${user.firstName} ${user.lastName}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
