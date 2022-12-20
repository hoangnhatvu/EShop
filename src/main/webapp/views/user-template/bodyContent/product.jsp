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
    <h1 class="font-weight-semi-bold text-uppercase mb-3">Sản phẩm</h1>
    <div class="d-inline-flex">
      <p class="m-0"><a href="">E Shop</a></p>
      <p class="m-0 px-2">-</p>
      <p class="m-0">Danh sách sản phẩm</p>
    </div>
  </div>
</div>

<!-- Head End -->

<!-- Body Start -->
<div class="container-fluid pt-5">
  <div class="row px-xl-5">
    <jsp:include page="../include/sidebarFilter.jsp"/>
    <div class="col-lg-9 col-md-12">
      <div class="row pb-3">
        <div class="col-12 pb-1">
          <div class="d-flex align-items-center justify-content-between mb-4">
            <form action="">
              <div class="input-group">
                <input type="text" class="form-control" placeholder="Tìm kiếm theo tên">
                <div class="input-group-append">
                                        <span class="input-group-text bg-transparent text-primary">
                                            <i class="fa fa-search"></i>
                                        </span>
                </div>
              </div>
            </form>
            <div class="dropdown ml-4">
              <button class="btn border dropdown-toggle" type="button" id="triggerId" data-toggle="dropdown" aria-haspopup="true"
                      aria-expanded="false">
                Sắp xếp theo
              </button>
              <div class="dropdown-menu dropdown-menu-right" aria-labelledby="triggerId">
                <a class="dropdown-item" href="#">Mới nhất</a>
                <a class="dropdown-item" href="#">Bán chạy</a>
                <a class="dropdown-item" href="#">Đánh giá cao</a>
              </div>
            </div>
          </div>
        </div>
        <!-- foreach product !-->
        <c:forEach var="prod" items="${products}">
          <c:set var="prod" value="${prod}" scope="request"/>
          <c:import url="/views/user-template/include/productBox.jsp"/>
        </c:forEach>

        <!-- Pagination! -->
        <div class="">
          <ul class="pagination">
            <c:if test="${tag>1}">
              <li class="pagi-item"><a href="${pageContext.request.contextPath }/product?index=${tag-1}">&laquo;</a></li>
            </c:if>
            <c:forEach begin="1" end="${endP}" var="i">
              <li class="${tag==i?"active":"" } pagi-item"><a
                      href="${pageContext.request.contextPath}/product?index=${i}">${i}</a></li>
            </c:forEach>
            <c:if test="${tag<endP}">
              <li class="pagi-item"><a href="${pageContext.request.contextPath}/product?index=${tag+1}">&raquo;</a></li>
            </c:if>
          </ul>
        </div>
  </div>
</div>



<!-- Body End -->



