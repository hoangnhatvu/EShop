<%--
  Created by IntelliJ IDEA.
  User: toan
  Date: 06/12/2022
  Time: 14:29
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
<c:if test="${fn:length(orders) <= 0}">
    <h3>Không có đơn hàng nào</h3>
</c:if>
${orderMsg}
${cancelMsg}
<table>
    <thead>
    <th>Địa chỉ</th>
    <th>SDT</th>
    <th>trạng thái đơn hàng</th>
    <th>Sản phẩm</th>
    <th>Tổng tiền</th>
    <th>Ngày đặt</th>
    <th></th>

    </thead>
<c:forEach var="ord" items="${orders}" varStatus="STT">
<tr>
    <th>${ord.address}</th>
    <th>${ord.phone}</th>
    <th>${ord.status}</th>
    <th>
    <c:forEach var="prod" items="${ord.orderItems}">
        ${prod.product.name}
        ${prod.product.price}
        ${prod.product.promotionalPrice}
        ${prod.count}
    </c:forEach>
    </th>
    <th>${ord.amountFromUser}</th>
    <th>${ord.createAt}</th>
    <th><c:if test="${ord.status == 'not precessed'}"><a href="<%=request.getContextPath()%>/order/delete?ordId=${ord.id}">Hủy đơn hàng</a></c:if></th>
</tr>
</c:forEach>
</table>

</body>
</html>
