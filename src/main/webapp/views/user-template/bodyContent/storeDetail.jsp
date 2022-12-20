<%--
  Created by IntelliJ IDEA.
  User: toan
  Date: 15/12/2022
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

</div>
</div>
</div>

<div class="container-fluid bg-secondary mb-5">
  <div class="d-flex flex-column align-items-center justify-content-center" style="min-height: 300px">
    <h1 class="font-weight-semi-bold text-uppercase mb-3">Chi tiết cửa hàng</h1>
    <div class="d-inline-flex">
      <p class="m-0"><a href="">E Shop</a></p>
      <p class="m-0 px-2">-</p>
      <p class="m-0">Cửa hàng</p>
    </div>
  </div>
</div>

<!-- Head End -->

<!-- Body Start -->
<div class="container-fluid offer pt-5">
  <div class="row px-xl-5" style="background-color: beige;">
    <div class="d-flex" style="margin-top: 30px">
      <div class="d-flex mb-3">
        <img src="${store.avatar}" class="img-fluid-store-avatar mr-5" style="position: unset;">
        <div class="d-block">
          <h4 class="font-weight-semi-bold">${store.name}</h4>
          <div class="text-primary mr-2">
            <c:forEach begin="${1}" end="${store.rating}">
              <small class="fa fa-star"></small>
            </c:forEach>
            <c:forEach begin="${store.rating + 1}" end="${5}">
              <small class="far fa-star"></small>
            </c:forEach>
          </div>
        </div>
      </div>
      <a style="font-size: 1.3rem;margin-top: 15px;margin-left: auto;" href="<%=request.getContextPath()%>/followStore?storeId=${store.id}"><span class="badge" style="color: black;">${fn:length(store.userFollowStores)}</span>Follow</a>
    </div>
    <p>${requestScope.store.bio}</p>
  </div>
</div>


<jsp:include page="/views/user-template/head/offer.jsp"/>

<jsp:include page="/views/user-template/include/TrendyProduct.jsp">
  <jsp:param name="trendyProd" value="${trendyProd}"/>
</jsp:include>

<jsp:include page="/views/user-template/include/Subcribe.jsp"/>

<jsp:include page="/views/user-template/include/NewArrival.jsp">
  <jsp:param name="arrivalProd" value="${arrivalProd}"/>
</jsp:include>

<div class="container-fluid bg-secondary mb-5">
  <div class="d-flex flex-column align-items-center justify-content-center" style="min-height: 300px">
    <h1 class="font-weight-semi-bold text-uppercase mb-3">Tất cả sản phẩm</h1>
  </div>
</div>

<div class="container-fluid pt-5">
  <div class="row px-xl-5">
    <c:forEach var="prod" items="${products}">
      <c:set var="prod" value="${prod}" scope="request"/>
      <c:import url="/views/user-template/include/productBox.jsp"/>
    </c:forEach>
  </div>
</div>



<!-- Body End -->



