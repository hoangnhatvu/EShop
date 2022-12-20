<%--
  Created by IntelliJ IDEA.
  User: toan
  Date: 18/12/2022
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="col-lg-3 col-md-6 col-sm-12 pb-1">
  <div class="card product-item border-0 mb-4">
    <a href="<%=request.getContextPath()%>/product/detail?productId=${requestScope.prod.id}">
    <div class="card-header product-img position-relative overflow-hidden bg-transparent border p-0">
      <img class="img-fluid-prod w-100" src="${requestScope.prod.listImage}" alt="">
    </div>
    <div class="card-body border-left border-right text-center p-0 pt-4 pb-3">
      <h6 class="text-truncate mb-3">${requestScope.prod.name}</h6>
      <div class="d-flex justify-content-center">
        <h6>$${requestScope.prod.promotionalPrice}</h6><h6 class="text-muted ml-2"><del>$${requestScope.prod.price}</del></h6>
      </div>
    </div>
    </a>
    <div class="card-footer d-flex justify-content-between bg-light border">
      <a href="<%=request.getContextPath()%>/followProduct?productId=${requestScope.prod.id}" class="btn btn-sm text-dark p-0"><i class="fas fa-heart text-primary mr-1"></i>Theo dõi</a>
      <a href="<%=request.getContextPath()%>/product/addToCart?productId=${requestScope.prod.id}" class="btn btn-sm text-dark p-0"><i class="fa fa-shopping-cart text-primary mr-1"></i>Thêm vào giỏ hàng</a>
    </div>
  </div>
</div>
