<%--
  Created by IntelliJ IDEA.
  User: toan
  Date: 15/12/2022
  Time: 20:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container-fluid bg-secondary text-dark mt-5 pt-5">
  <div class="row px-xl-5 pt-5">
    <div class="col-lg-4 col-md-12 mb-5 pr-3 pr-xl-5">
      <a href="" class="text-decoration-none">
        <h1 class="mb-4 display-5 font-weight-semi-bold"><span class="text-primary font-weight-bold border border-white px-3 mr-1">E</span>Shopper</h1>
      </a>
      <p>Đem chất lượng tốt nhất đến cho khách hài, sự hài lòng của bạn là niềm vui của chúng tôi.</p>
      <p class="mb-2"><i class="fa fa-map-marker-alt text-primary mr-3"></i>Số 1 Võ Văn Ngân, Linh Trung, Thủ Đức</p>
      <p class="mb-2"><i class="fa fa-envelope text-primary mr-3"></i>20110738@student.hcmute.com</p>
      <p class="mb-0"><i class="fa fa-phone-alt text-primary mr-3"></i>0988194601</p>
    </div>
    <div class="col-lg-8 col-md-12">
      <div class="row">
        <div class="col-md-4 mb-5">
          <h5 class="font-weight-bold text-dark mb-4">Truy cập nhanh</h5>
          <div class="d-flex flex-column justify-content-start">
            <a class="text-dark mb-2" href="index.html"><i class="fa fa-angle-right mr-2"></i>Trang chủ</a>
            <a class="text-dark mb-2" href="shop.html"><i class="fa fa-angle-right mr-2"></i>Sản phẩm</a>
            <a class="text-dark mb-2" href="detail.html"><i class="fa fa-angle-right mr-2"></i>Cửa hàng</a>
            <a class="text-dark mb-2" href="cart.html"><i class="fa fa-angle-right mr-2"></i>Giỏ hàng</a>
            <a class="text-dark mb-2" href="checkout.html"><i class="fa fa-angle-right mr-2"></i>Đặt hàng</a>
            <a class="text-dark" href="contact.html"><i class="fa fa-angle-right mr-2"></i>Thông tin về chúng tôi</a>
          </div>
        </div>
        <div class="col-md-4 mb-5">
          <h5 class="font-weight-bold text-dark mb-4">Truy cập nhanh</h5>
          <div class="d-flex flex-column justify-content-start">
            <a class="text-dark mb-2" href="index.html"><i class="fa fa-angle-right mr-2"></i>Trang chủ</a>
            <a class="text-dark mb-2" href="shop.html"><i class="fa fa-angle-right mr-2"></i>Sản phẩm</a>
            <a class="text-dark mb-2" href="detail.html"><i class="fa fa-angle-right mr-2"></i>Cửa hàng</a>
            <a class="text-dark mb-2" href="cart.html"><i class="fa fa-angle-right mr-2"></i>Giỏ hàng</a>
            <a class="text-dark mb-2" href="checkout.html"><i class="fa fa-angle-right mr-2"></i>Đặt hàng</a>
            <a class="text-dark" href="contact.html"><i class="fa fa-angle-right mr-2"></i>Thông tin về chúng tôi</a>
          </div>
        </div>
        <div class="col-md-4 mb-5">
          <h5 class="font-weight-bold text-dark mb-4">Thắc mắc</h5>
          <form action="">
            <div class="form-group">
              <input type="text" class="form-control border-0 py-4" placeholder="Tên của bạn" required="required" />
            </div>
            <div class="form-group">
              <input type="email" class="form-control border-0 py-4" placeholder="Vấn đề"
                     required="required" />
            </div>
            <div>
              <button class="btn btn-primary btn-block border-0 py-3" type="submit">Gửi yêu cầu</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
  <div class="row border-top border-light mx-xl-5 py-4">
    <div class="col-md-6 px-xl-0">
      <p class="mb-md-0 text-center text-md-left text-dark">
        &copy; <a class="text-dark font-weight-semi-bold" href="#">EShop</a>. Được chứng thực và thiết kế bởi
        <a class="text-dark font-weight-semi-bold" href="https://htmlcodex.com">E-Shop It</a><br>
        Thực hiện bởi <a href="https://themewagon.com" target="_blank">E-Shop It</a>
      </p>
    </div>
    <div class="col-md-6 px-xl-0 text-center text-md-right">
      <img class="img-fluid" src="<%=request.getContextPath()%>/templates/img/payments.png" alt="">
    </div>
  </div>
</div>
<!-- Footer End -->


<!-- Back to Top -->
<a href="#" class="btn btn-primary back-to-top"><i class="fa fa-angle-double-up"></i></a>


<!-- JavaScript Libraries -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
<script src="<%=request.getContextPath()%>/templates/lib/easing/easing.min.js"></script>
<script src="<%=request.getContextPath()%>/templates/lib/owlcarousel/owl.carousel.min.js"></script>

<!-- Contact Javascript File -->
<script src="<%=request.getContextPath()%>/templates/mail/jqBootstrapValidation.min.js"></script>
<script src="<%=request.getContextPath()%>/templates/mail/contact.js"></script>

<!-- Template Javascript -->
<script src="<%=request.getContextPath()%>/templates/js/main.js"></script>
</body>

