<%--
  Created by IntelliJ IDEA.
  User: toan
  Date: 04/12/2022
  Time: 23:01
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
<form method="post" action="<%=request.getContextPath()%>/cart/checkout">
    <input name="name" type="text" value="${sessionScope.userName}" placeholder="Tên người nhận" required>
    <input name="address" type="text" placeholder="Địa chỉ" required>
    <input name="phone" type="number" placeholder="Số điện thoại" required>

    <table>
        <thead>
        <th>STT</th>
        <th>Tên</th>
        <th>Giá</th>
        <th>Giá khuyến mãi</th>
        <th>Số lượng</th>
        </thead>
        <tbody>
        <c:set var="total" value="${0}"></c:set>
        <c:forEach var="item" items="${cartItems}" varStatus="STT">
            <tr>
                <td>${STT.index + 1}</td>
                <td>${item.product.name}</td>
                <td>${item.product.price}</td>
                <td>${item.product.promotionalPrice}</td>
                <td><input class="cartItemQuantity" id="${item.id}" type="number" value="${item.count}" min="1" disabled></td>
            </tr>
            <c:set var="total" value="${total + item.product.promotionalPrice*item.count}"></c:set>
        </c:forEach>
        <input name="total" type="number" value="${total}" readonly>

        </tbody>
    </table>

    <label for="commission">Hoa hồng</label>
    <select name="commission" id="commission" required>
        <c:forEach var="comm" items="${commissions}">
            <option value="${comm.id}">${comm.name} - ${comm.cost}</option>
        </c:forEach>
    </select>
    <label for="delivery">Phương thức giao hàng</label>
    <select name="delivery" id="delivery" required>
        <c:forEach var="deli" items="${deliveries}">
            <option value="${deli.id}">${deli.name} - ${deli.price}</option>
        </c:forEach>
    </select>
    <input name="payment" placeholder="Phương thức thanh toán">
    <a href="<%=request.getContextPath()%>/cart">Trở lại</a>
    <button type="reset">Thay đổi thông tin</button>
    <button type="submit">Đặt hàng</button>
</form>
</body>
</html>
