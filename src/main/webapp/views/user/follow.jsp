<%--
  Created by IntelliJ IDEA.
  User: toan
  Date: 09/12/2022
  Time: 22:13
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
<h2>Sản phẩm theo dõi</h2>
<c:if test="${fn:length(ufps) <= 0}">
  <h3>Chưa theo dõi sản phẩm nào</h3>
</c:if>
<table>
  <thead>
  <tr>
    <th>STT</th>
    <th>Tên</th>
    <th>Giá</th>
    <th>Giá khuyến mãi</th>
    <th>Thêm vào giỏ hàng</th>
    <th>date</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="prod" items="${ufps}" varStatus="STT">
    <tr class = "odd gradeX">
      <td>${STT.index + 1}</td>
      <td>${prod.product.name}</td>
      <td>${prod.product.price}</td>
      <td>${prod.product.promotionalPrice}</td>
      <td><a href="<%=request.getContextPath()%>/product/addToCart?productId=${prod.product.id}">Add</a></td>
      <td><a href="<%=request.getContextPath()%>/followProduct?productId=${prod.product.id}">unFollow</a></td>
      <td>${prod.product.createAt}</td>

    </tr>
  </c:forEach>
  </tbody>
</table>

<h2>Cửa hàng theo dõi</h2>
<c:if test="${fn:length(ufss) <= 0}">
  <h3>Chưa theo dõi cửa hàng nào</h3>
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
  <c:forEach var="ufs" items="${ufss}" varStatus="STT">
    <tr class = "odd gradeX">
      <td>${STT.index + 1}</td>
      <td><img width="50px" height="50px"src="${ufs.store.avatar}"></td>
      <td>${ufs.store.name}</td>
      <td>${ufs.store.bio}</td>
      <td>${ufs.store.rating}</td>
      <td><a href="<%=request.getContextPath()%>/followStore?storeId=${ufs.store.id}">unFollow</a></td>
    </tr>
  </c:forEach>
  </tbody>
</table>

</body>
</html>
