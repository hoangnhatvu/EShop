
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
    <h1 class="font-weight-semi-bold text-uppercase mb-3">Giỏ hàng</h1>
    <div class="d-inline-flex">
      <p class="m-0"><a href="">E Shop</a></p>
      <p class="m-0 px-2">-</p>
      <p class="m-0">Giỏ hàng của bạn</p>
    </div>
  </div>
</div>

<!-- Head End -->

<!-- Body Start -->
<form method="get" action="<%=request.getContextPath()%>/cart/checkout">
<div class="container-fluid pt-5">
  <div class="row px-xl-5">
    <div class="col-lg-8 table-responsive mb-5">
      <table class="table table-bordered text-center mb-0">
        <thead class="bg-secondary text-dark">
        <tr>
          <th>Sản phẩm</th>
          <th>Giá</th>
          <th>Số lượng</th>
          <th>Tổng cộng</th>
          <th>Xóa sản phẩm</th>
        </tr>
        </thead>
        <tbody class="align-middle">
        <c:set var="total" value="${0}"/>
        <c:set var="ogtotal" value="${0}"/>
        <c:forEach var="item" items="${cartItems}">
        <tr>
          <td class="align-middle"><img src="${item.product.listImage}" alt="" style="width: 50px;"> ${item.product.name}</td>
          <td class="align-middle">$${item.product.promotionalPrice}</td>
          <td class="align-middle">
            <div class="input-group quantity mx-auto" style="width: 100px;">
              <div class="input-group-btn">
                <button type="button" class="btn btn-sm btn-primary btn-minus btn-changeQuanity" >
                  <i class="fa fa-minus"></i>
                </button>
              </div>
              <input  type="text" class="cartItemQuantity form-control form-control-sm bg-secondary text-center" id="${item.id}" value="${item.count}" min="1">
              <div class="input-group-btn">
                <button type="button" class="btn btn-sm btn-primary btn-plus btn-changeQuanity">
                  <i class="fa fa-plus"></i>
                </button>
              </div>
            </div>
          </td>
          <td class="totalPerItem${item.id} align-middle">$${item.product.promotionalPrice*item.count}</td>
          <td class="align-middle"><a href="<%=request.getContextPath()%>/cart/delete?cartItemId=${item.id}" class="btn btn-sm btn-primary"><i class="fa fa-times"></i></a></td>
          <c:set var="total" value="${total + item.product.promotionalPrice*item.count}"/>
          <c:set var="ogtotal" value="${ogtotal + item.product.price*item.count}"/>
        </tr>
        </c:forEach>

        </tbody>
      </table>
    </div>
    <div class="col-lg-4">
      <form class="mb-5" action="">
        <div class="input-group">
          <input type="text" class="form-control p-4" placeholder="Coupon Code">
          <div class="input-group-append">
            <button class="btn btn-primary">Nhập mã giảm gas</button>
          </div>
        </div>
      </form>
      <div class="card border-secondary mb-5">
        <div class="card-header bg-secondary border-0">
          <h4 class="font-weight-semi-bold m-0">Tổng cộng giỏ họng</h4>
        </div>
        <div class="card-body">
          <div class="d-flex justify-content-between mb-3 pt-1">
            <h6 class="font-weight-medium">Trước Giảm Giá</h6>
            <h6 class="text-muted ml-2"><del>$${ogtotal}</del></h6>
          </div>

        </div>
        <div class="card-footer border-secondary bg-transparent">
          <div class="d-flex justify-content-between mt-2">
            <h5 id="total" class="font-weight-bold">Tổng cộng</h5>
            <h5 class="font-weight-bold">$${total}</h5>
          </div>
          <button type="submit" class="btn btn-block btn-primary my-3 py-3">Đặt hàng</button>
        </div>
      </div>
    </div>
  </div>
</div>
</form>
<script>

</script>
<!-- Body End -->



