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
</div>
</div>
</div>
<div class="container-fluid bg-secondary mb-5">
    <div class="d-flex flex-column align-items-center justify-content-center" style="min-height: 300px">
        <h1 class="font-weight-semi-bold text-uppercase mb-3">Danh sách đơn hàng</h1>
        <div class="d-inline-flex">
            <p class="m-0"><a href="">E-Shop</a></p>
            <p class="m-0 px-2">-</p>
            <p class="m-0">Đơn hàng của tôi</p>
        </div>
    </div>
</div>
<c:if test="${fn:length(orders) <= 0}">
    <h3>Không có đơn hàng nào</h3>
</c:if>
${orderMsg}
${cancelMsg}

<div class="container-fluid pt-5">
    <div class="row px-xl-5">
        <c:forEach var="ord" items="${orders}" varStatus="STT">
            <c:set var="ord" value="${ord}" scope="request"/>
            <c:import url="/views/user-template/include/orderBox.jsp"/>
        </c:forEach>
    </div>
</div>

