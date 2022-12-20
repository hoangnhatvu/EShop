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
        <h1 class="font-weight-semi-bold text-uppercase mb-3">Đặt hàng</h1>
        <div class="d-inline-flex">
            <p class="m-0"><a href="">E Shop</a></p>
            <p class="m-0 px-2">-</p>
            <p class="m-0">Đặt hàng</p>
        </div>
    </div>
</div>
<!-- Head End -->

<!-- Body Start -->
<form method="post" action="<%=request.getContextPath()%>/cart/checkout">
<div class="container-fluid pt-5">
    <div class="row px-xl-5">
        <div class="col-lg-8">
            <div class="mb-4">
                <h4 class="font-weight-semi-bold mb-4">Địa chỉ</h4>
                <div class="row">
                    <div class="col-md-6 form-group">
                        <label>Tên người nhận</label>
                        <input name="name" class="form-control" type="text" value="${sessionScope.userName}" placeholder="Tên người nhận" required>
                    </div>
                    <div class="col-md-6 form-group">
                        <label>Số điện thoai</label>
                        <input name="phone" type="number" class="form-control" type="text" placeholder="Số điện thoại" required>
                    </div>
                    <div class="col-md-6 form-group">
                        <label>Địa chỉ</label>
                        <input name="address" class="form-control" type="text" placeholder="Địa chỉ" required>
                    </div>
                    <div class="col-md-6 form-group">
                        <label for="delivery">Phương thức giao hàng</label>
                        <select name="delivery" id="delivery" required>
                            <c:forEach var="deli" items="${deliveries}">
                                <option value="${deli.id}">${deli.name} - ${deli.price}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="col-md-6 form-group">
                        <label for="commission">Hoa hồng</label>
                        <select name="commission" id="commission" required>
                            <c:forEach var="comm" items="${commissions}">
                                <option value="${comm.id}">${comm.name} - ${comm.cost}</option>
                            </c:forEach>
                        </select>
                    </div>

                </div>
            </div>
        </div>
        <div class="col-lg-4">
            <div class="card border-secondary mb-5">
                <div class="card-header bg-primary border-0">
                    <h4 class="font-weight-semi-bold m-0">Tổng cộng</h4>
                </div>
                <div class="card-body">
                    <h5 class="font-weight-medium mb-3">Sản phẩm</h5>
                    <c:set var="total" value="${0}"/>
                    <c:forEach var="item" items="${cartItems}">
                        <div class="d-flex justify-content-between">
                            <p>${item.product.name} - ${item.count}</p>
                            <p>$${item.product.promotionalPrice*item.count}</p>
                        </div>
                        <c:set var="total" value="${total + item.product.promotionalPrice*item.count}"/>
                    </c:forEach>

                    <hr class="mt-0">
                    <div class="d-flex justify-content-between mb-3 pt-1">
                        <h6 class="font-weight-medium">Tổng cộg</h6>
                        <h6 class="font-weight-medium">$${total}</h6>
                    </div>
                </div>
                <div class="card-footer border-secondary bg-transparent">
                    <div class="d-flex justify-content-between mt-2">
                        <h5 class="font-weight-bold">Tổng cộng</h5>
                        <h5 class="font-weight-bold">$${total}</h5>
                    </div>
                </div>
            </div>
            <div class="card border-secondary mb-5">
                <div class="card-header bg-primary border-0">
                    <h4 class="font-weight-semi-bold m-0">Phương thức thanh toán</h4>
                </div>
                <div class="card-body">
                    <div class="form-group">
                        <div class="custom-control custom-radio">
                            <input type="radio" class="custom-control-input" name="payment" id="paypal">
                            <label class="custom-control-label" for="paypal">Paypal</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="custom-control custom-radio">
                            <input type="radio" class="custom-control-input" name="payment" id="directcheck">
                            <label class="custom-control-label" for="directcheck">COD</label>
                        </div>
                    </div>
                    <div class="">
                        <div class="custom-control custom-radio">
                            <input type="radio" class="custom-control-input" name="payment" id="banktransfer">
                            <label class="custom-control-label" for="banktransfer">Chuyển khoản</label>
                        </div>
                    </div>
                </div>
                <div class="card-footer border-secondary bg-transparent">
                    <button class="btn btn-lg btn-block btn-primary font-weight-bold my-3 py-3">Đặt hàng</button>
                </div>
            </div>
        </div>
    </div>
</div>
</form>
<!-- Body End -->


