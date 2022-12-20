<%--
  Created by IntelliJ IDEA.
  User: toan
  Date: 19/12/2022
  Time: 22:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="col-lg-3 col-md-6 col-sm-12 pb-1">
  <div class="card product-item border-0 mb-4">

    <div class="card-body border-left border-right text-center p-0 pt-4 pb-3 bg-primary">
      <h6 class="text-truncate mb-3">${requestScope.ord.address}</h6>
      <div class="d-flex justify-content-center">
        <h6>${requestScope.ord.phone}</h6>
      </div>
    </div>

    <div class="card-header position-relative overflow-hidden bg-transparent border p-0 text-center">
      <c:forEach var="prod" items="${requestScope.ord.orderItems}">
        <p>${prod.product.name} - $${prod.product.promotionalPrice}x${prod.count}</p>
      </c:forEach>
    </div>

    <div class="card-body border-left border-right text-center p-0 pt-4 pb-3">
      <h6 class="text-truncate mb-3">$${requestScope.ord.amountFromUser}</h6>
      <div class="d-flex justify-content-center">
        <h6>${requestScope.ord.status}</h6>
      </div>
    </div>

    <div class="card-footer d-flex justify-content-between bg-light border">
      <a href="<c:if test="${ord.status == 'not precessed'}"> <%=request.getContextPath()%>/order/delete?ordId=${requestScope.ord.id} </c:if>" class="btn btn-sm text-dark p-0"><i class="fa fa-trash text-primary mr-1"></i>Hủy đơn hàng</a>
      <a href="<%=request.getContextPath()%>/order/addReview?ordId=${requestScope.ord.id}&content=qua tuyet&stars=4" class="btn btn-sm text-dark p-0"><i class="fa fa-smile text-primary mr-1"></i>Đánh giá </a>
    </div>

  </div>
</div>

