<%--
  Created by IntelliJ IDEA.
  User: toan
  Date: 15/12/2022
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    </div>
  </div>
</div>

<div class="container-fluid bg-secondary mb-5">
  <div class="d-flex flex-column align-items-center justify-content-center" style="min-height: 300px">
    <h1 class="font-weight-semi-bold text-uppercase mb-3">Chi tiết sản phẩm</h1>
    <div class="d-inline-flex">
      <p class="m-0"><a href="">E Shop</a></p>
      <p class="m-0 px-2">-</p>
      <p class="m-0">Chi tiết</p>
    </div>
  </div>
</div>
<!-- Head End -->

<!-- Body Start -->
<jsp:include page="../include/detail.jsp">
  <jsp:param name="product" value="${product}"/>
  <jsp:param name="reviews" value="${reviews}"/>
  <jsp:param name="store" value="${store}"/>
</jsp:include>

<jsp:include page="../include/relatedProd.jsp">
  <jsp:param name="relatedProduct" value="${relatedProduct}"/>
</jsp:include>


<!-- Body End -->



