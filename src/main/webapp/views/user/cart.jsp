<%--
  Created by IntelliJ IDEA.
  User: toan
  Date: 30/11/2022
  Time: 15:32
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
<c:if test="${fn:length(cartItems) <= 0}">
    <h3>Không có sản phâ nao trong giỏ hàng</h3>
</c:if>
<c:if test="${fn:length(cartItems) > 0}">
<form method="get" action="<%=request.getContextPath()%>/cart/checkout">
    <table>
        <thead>
            <th>STT</th>
            <th>Tên</th>
            <th>Giá</th>
            <th>Giá khuyến mãi</th>
            <th>Số lượng</th>
            <th>Xóa</th>
        </thead>
        <tbody>
        <c:set var="total" value="${0}"></c:set>
        <c:forEach var="item" items="${cartItems}" varStatus="STT">
            <tr>
                <td>${STT.index + 1}</td>
                <td>${item.product.name}</td>
                <td>${item.product.price}</td>
                <td id="promotionalPrice${item.id}">${item.product.promotionalPrice}</td>
                <td><input class="cartItemQuantity" id="${item.id}" type="number" value="${item.count}" min="1"></td>
                <input id="totalPerItem${item.id}" value="${item.product.promotionalPrice*item.count}" hidden>
                <td><a href="<%=request.getContextPath()%>/cart/delete?cartItemId=${item.id}">Xóa</a></td>
            </tr>
            <c:set var="total" value="${total + item.product.promotionalPrice*item.count}"></c:set>
        </c:forEach>
        </tbody>
    </table>
    <input id="total" name="total" value="${total}" disabled>
    <a href="<%=request.getContextPath()%>">Quay trở lại</a>
    <button type="submit"> Đặt hàng</button>
</form>
</c:if>
<script>
    $('.quantity button').on('click', function () {
        var button = $(this);
        var oldValue = button.parent().parent().find('input').val();
        var itemId = button.parent().parent().find('input').attr("id");
        if (button.hasClass('btn-plus')) {
            var newVal = parseFloat(oldValue) + 1;
        } else {
            if (oldValue > 1) {
                var newVal = parseFloat(oldValue) - 1;
            } else {
                newVal = 1;
            }
        }
        button.parent().parent().find('input').val(newVal);

        $.ajax({
            url:'<%=request.getContextPath()%>/cart/updateQuantity',
            data:{quantity: newVal, id: itemId },
            type:'post',
            cache:false,
            success:function(data){

            },
            error:function(data){
                alert("error");
            }
        })
    });
</script>

</body>
</html>
