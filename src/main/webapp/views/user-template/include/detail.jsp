<%--
  Created by IntelliJ IDEA.
  User: toan
  Date: 15/12/2022
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<div class="container-fluid py-5">
  <div class="row px-xl-5">
    <div class="col-lg-5 pb-5">
      <div id="product-carousel" class="carousel slide" data-ride="carousel">
        <div class="carousel-inner border">
          <div class="carousel-item active">
            <img class="w-100 h-100" src="${product.listImage}" alt="Image">
          </div>
          <div class="carousel-item">
            <img class="w-100 h-100" src="${product.listImage}" alt="Image">
          </div>
          <div class="carousel-item">
            <img class="w-100 h-100" src="${product.listImage}" alt="Image">
          </div>
          <div class="carousel-item">
            <img class="w-100 h-100" src="${product.listImage}" alt="Image">
          </div>
        </div>
        <a class="carousel-control-prev" href="#product-carousel" data-slide="prev">
          <i class="fa fa-2x fa-angle-left text-dark"></i>
        </a>
        <a class="carousel-control-next" href="#product-carousel" data-slide="next">
          <i class="fa fa-2x fa-angle-right text-dark"></i>
        </a>
      </div>
    </div>

    <div class="col-lg-7 pb-5">
      <h3 class="font-weight-semi-bold">${product.name}</h3>
      <div class="d-flex mb-3">
        <div class="text-primary mr-2">
          <c:forEach begin="${1}" end="${product.rating}">
            <small class="fa fa-star"></small>
          </c:forEach>
          <c:forEach begin="${product.rating + 1}" end="${5}">
          <small class="far fa-star"></small>
          </c:forEach>
        </div>
        <small class="pt-1">(${fn:length(reviews)})</small>
      </div>
      <h3 class="font-weight-semi-bold mb-4">$${product.promotionalPrice}   <del>${product.price}</del></h3>
      <p class="mb-4">${product.slug}</p>
      <div class="d-flex mb-3">
        <p class="text-dark font-weight-medium mb-0 mr-3">Sizes:</p>
        <form>
          <div class="custom-control custom-radio custom-control-inline">
            <input type="radio" class="custom-control-input" id="size-1" name="size">
            <label class="custom-control-label" for="size-1">XS</label>
          </div>
          <div class="custom-control custom-radio custom-control-inline">
            <input type="radio" class="custom-control-input" id="size-2" name="size">
            <label class="custom-control-label" for="size-2">S</label>
          </div>
          <div class="custom-control custom-radio custom-control-inline">
            <input type="radio" class="custom-control-input" id="size-3" name="size">
            <label class="custom-control-label" for="size-3">M</label>
          </div>
          <div class="custom-control custom-radio custom-control-inline">
            <input type="radio" class="custom-control-input" id="size-4" name="size">
            <label class="custom-control-label" for="size-4">L</label>
          </div>
          <div class="custom-control custom-radio custom-control-inline">
            <input type="radio" class="custom-control-input" id="size-5" name="size">
            <label class="custom-control-label" for="size-5">XL</label>
          </div>
        </form>
      </div>
      <div class="d-flex mb-4">
        <p class="text-dark font-weight-medium mb-0 mr-3">Màu sắc:</p>
        <form>
          <div class="custom-control custom-radio custom-control-inline">
            <input type="radio" class="custom-control-input" id="color-1" name="color">
            <label class="custom-control-label" for="color-1">Đen</label>
          </div>
          <div class="custom-control custom-radio custom-control-inline">
            <input type="radio" class="custom-control-input" id="color-2" name="color">
            <label class="custom-control-label" for="color-2">Trắng</label>
          </div>
          <div class="custom-control custom-radio custom-control-inline">
            <input type="radio" class="custom-control-input" id="color-3" name="color">
            <label class="custom-control-label" for="color-3">Đỏ</label>
          </div>
          <div class="custom-control custom-radio custom-control-inline">
            <input type="radio" class="custom-control-input" id="color-4" name="color">
            <label class="custom-control-label" for="color-4">Xanh</label>
          </div>
          <div class="custom-control custom-radio custom-control-inline">
            <input type="radio" class="custom-control-input" id="color-5" name="color">
            <label class="custom-control-label" for="color-5">Vàng</label>
          </div>
        </form>
      </div>
      <div class="d-flex align-items-center mb-4 pt-2">
        <a href="<%=request.getContextPath()%>/followProduct?productId=${requestScope.prod.id}" class="btn btn-sm text-dark px-3 mr-3"><i class="fas fa-heart mr-1"></i>Theo dõi</a>
        <div class="input-group quantity mr-3" style="width: 130px;">
          <div class="input-group-btn">
            <button class="btn btn-primary btn-minus" >
              <i class="fa fa-minus"></i>
            </button>
          </div>
          <input type="text" class="form-control bg-secondary text-center" value="1">
          <div class="input-group-btn">
            <button class="btn btn-primary btn-plus">
              <i class="fa fa-plus"></i>
            </button>
          </div>
        </div>
        <a href="<%=request.getContextPath()%>/product/addToCart?productId=${product.id}" class="btn btn-primary px-3"><i class="fa fa-shopping-cart mr-1"></i> Thêm vào giỏ hàng</a>
      </div>
      <div class="d-flex pt-2">
        <p class="text-dark font-weight-medium mb-0 mr-2">Chia sẻ:</p>
        <div class="d-inline-flex">
          <a class="text-dark px-2" href="">
            <i class="fab fa-facebook-f"></i>
          </a>
          <a class="text-dark px-2" href="">
            <i class="fab fa-twitter"></i>
          </a>
          <a class="text-dark px-2" href="">
            <i class="fab fa-linkedin-in"></i>
          </a>
          <a class="text-dark px-2" href="">
            <i class="fab fa-pinterest"></i>
          </a>
        </div>
      </div>
    </div>
  </div>
  <div class="row px-xl-5">
    <div class="col">
      <div class="nav nav-tabs justify-content-center border-secondary mb-4">
        <a class="nav-item nav-link active" data-toggle="tab" href="#tab-pane-1">Chi tiết</a>
        <a class="nav-item nav-link" data-toggle="tab" href="#tab-pane-2">Shop</a>
        <a class="nav-item nav-link" data-toggle="tab" href="#tab-pane-3">Đánh giá (${fn:length(reviews)})</a>
      </div>
      <div class="tab-content">
        <div class="tab-pane fade show active" id="tab-pane-1">
          <h4 class="mb-3">Chi tiết sản phẩm</h4>
          <p>${product.desciption}</p>
        </div>

        <div class="tab-pane fade" id="tab-pane-2">
          <div>
            <a class="d-flex mb-3" href="<%=request.getContextPath()%>/store?storeId=${requestScope.store.id}">
              <img src="${store.avatar}" class="img-fluid-avatar mr-5">
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
            </a>
          </div>
          <p>${store.bio}</p>
          </div>
        <div class="tab-pane fade" id="tab-pane-3">
          <div class="row">
            <div class="col-md-6">
              <h4 class="mb-4">${fn:length(reviews)} review for "${product.name}"</h4>
              <c:forEach var="review" items="${reviews}">
                <c:set var="review" value="${review}" scope="request"/>
                <c:import url="/views/user-template/include/commentBox.jsp"/>
              </c:forEach>
            </div>
            <div class="col-md-6">
              <h4 class="mb-4">Đánh giá sản phẩm</h4>
              <form method="post" action="<%=request.getContextPath()%>/product/addRview?prodId=${product.id}">
                <div class="form-group">
                  <label for="message">Your Review *</label>
                  <textarea name="content" id="message" cols="30" rows="5" class="form-control" required></textarea>
                </div>
                <div class="form-group mb-0">
                  <input type="submit" value="Leave Your Review" class="btn btn-primary px-3">
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
