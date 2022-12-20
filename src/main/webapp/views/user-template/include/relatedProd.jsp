<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: toan
  Date: 15/12/2022
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container-fluid py-5">
  <div class="text-center mb-4">
    <h2 class="section-title px-5"><span class="px-2">Sản phẩm tương tự</span></h2>
  </div>
  <div class="row px-xl-5">
    <div class="col">
      <div class="owl-carousel related-carousel">
        <c:forEach var="prod" items="${requestScope.relatedProduct}">
          <div class="card product-item border-0">
            <div class="card-header product-img position-relative overflow-hidden bg-transparent border p-0">
              <img class="img-fluid w-100" src="${prod.listImage}" alt="">
            </div>
            <div class="card-body border-left border-right text-center p-0 pt-4 pb-3">
              <h6 class="text-truncate mb-3">${prod.name}</h6>
              <div class="d-flex justify-content-center">
                <h6>$${prod.price}</h6><h6 class="text-muted ml-2"><del>$${prod.promotionalPrice}</del></h6>
              </div>
            </div>
            <div class="card-footer d-flex justify-content-between bg-light border">
              <a href="<%=request.getContextPath()%>/followProduct?productId=${requestScope.prod.id}" class="btn btn-sm text-dark p-0"><i class="fas fa-heart text-primary mr-1"></i>Like</a>
              <a href="<%=request.getContextPath()%>/product/addToCart?productId=${requestScope.prod.id}" class="btn btn-sm text-dark p-0"><i class="fa fa-shopping-cart text-primary mr-1"></i>Add To Cart</a>
            </div>
          </div>
        </c:forEach>
      </div>
    </div>
  </div>
</div>
