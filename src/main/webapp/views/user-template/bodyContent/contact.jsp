<%--
  Created by IntelliJ IDEA.
  User: toan
  Date: 15/12/2022
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    </div>
  </div>
</div>
<div class="container-fluid bg-secondary mb-5">
  <div class="d-flex flex-column align-items-center justify-content-center" style="min-height: 300px">
    <h1 class="font-weight-semi-bold text-uppercase mb-3">Contact Us</h1>
    <div class="d-inline-flex">
      <p class="m-0"><a href="">Home</a></p>
      <p class="m-0 px-2">-</p>
      <p class="m-0">Contact</p>
    </div>
  </div>
</div>
<!-- Head End -->

<!-- Body Start -->
<div class="container-fluid pt-5">
  <div class="text-center mb-4">
    <h2 class="section-title px-5"><span class="px-2">Contact For Any Queries</span></h2>
  </div>
  <div class="row px-xl-5">
    <div class="col-lg-7 mb-5">
      <div class="contact-form">
        <div id="success"></div>
        <form name="sentMessage" id="contactForm" novalidate="novalidate">
          <div class="control-group">
            <input type="text" class="form-control" id="name" placeholder="Tên" value="${user.firstName} ${user.lastName}"
                   required="required" data-validation-required-message="Vui lòng nhập têm" />
            <p class="help-block text-danger"></p>
          </div>
          <div class="control-group">
            <input type="email" class="form-control" id="email" placeholder="Email" value="${user.email}"
                   required="required" data-validation-required-message="Vui lòng nhập email" />
            <p class="help-block text-danger"></p>
          </div>
          <div class="control-group">
            <input type="text" class="form-control" id="subject" placeholder="Chủ đề"
                   required="required" data-validation-required-message="Vui lòng nhập chủ đề" />
            <p class="help-block text-danger"></p>
          </div>
          <div class="control-group">
                            <textarea class="form-control" rows="6" id="message" placeholder="Nhận xét"
                                      required="required"
                                      data-validation-required-message="Vui lòng nhâ nhận xét"></textarea>
            <p class="help-block text-danger"></p>
          </div>
          <div>
            <button class="btn btn-primary py-2 px-4" type="submit" id="sendMessageButton">Gửi nhận xét</button>
          </div>
        </form>
      </div>
    </div>
    <div class="col-lg-5 mb-5">
      <h5 class="font-weight-semi-bold mb-3">Liên lạc với chúng tôi</h5>
      <p>Tổng đài luôn sẵn sàng hỗ trợ khách hàng 24/7 với tinh thần vui vẻ, thân thiện. Mong muốn đem lại những trải nghiệm mua hàng tuyệt vời nhất. Gửi tin nhắn sớm nhất để nhận đc hỗ trợ</p>
      <div class="d-flex flex-column mb-3">
        <h5 class="font-weight-semi-bold mb-3">Trụ sở chính</h5>
        <p class="mb-2"><i class="fa fa-map-marker-alt text-primary mr-3"></i>Số 1 Võ Văn Ngân, Linh Trung, Thủ Đức</p>
        <p class="mb-2"><i class="fa fa-envelope text-primary mr-3"></i>20110738@student.hcmute.com</p>
        <p class="mb-2"><i class="fa fa-phone-alt text-primary mr-3"></i>0988194601</p>
      </div>
      <div class="d-flex flex-column">
        <h5 class="font-weight-semi-bold mb-3">Trụ sở phụ</h5>
        <p class="mb-2"><i class="fa fa-map-marker-alt text-primary mr-3"></i>Số 2 Võ Văn Ngân, Linh Trung, Thủ Đức</p>
        <p class="mb-2"><i class="fa fa-envelope text-primary mr-3"></i>20110738@student.hcmute.com</p>
        <p class="mb-0"><i class="fa fa-phone-alt text-primary mr-3"></i>+012 345 67890</p>
      </div>
    </div>
  </div>
</div>

<!-- Body End -->



