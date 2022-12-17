<%--
  Created by IntelliJ IDEA.
  User: toan
  Date: 15/12/2022
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<body>
<div class="container-fluid">
  <div class="row bg-secondary py-2 px-xl-5">
    <div class="col-lg-6 d-none d-lg-block">
      <div class="d-inline-flex align-items-center">
        <a class="text-dark" href="">FAQs</a>
        <span class="text-muted px-2">|</span>
        <a class="text-dark" href="">Help</a>
        <span class="text-muted px-2">|</span>
        <a class="text-dark" href="">Support</a>
      </div>
    </div>
    <div class="col-lg-6 text-center text-lg-right">
      <div class="d-inline-flex align-items-center">
        <a class="text-dark px-2" href="">
          <i class="fa fa-facebook-f"></i>
        </a>
        <a class="text-dark px-2" href="">
          <i class="fa fa-twitter"></i>
        </a>
        <a class="text-dark px-2" href="">
          <i class="fa fa-linkedin-in"></i>
        </a>
        <a class="text-dark px-2" href="">
          <i class="fa fa-instagram"></i>
        </a>
        <a class="text-dark pl-2" href="">
          <i class="fa fa-youtube"></i>
        </a>
      </div>
    </div>
  </div>
  <div class="row align-items-center py-3 px-xl-5">
    <div class="col-lg-3 d-none d-lg-block">
      <a href="" class="text-decoration-none">
        <h1 class="m-0 display-5 font-weight-semi-bold"><span class="text-primary font-weight-bold border px-3 mr-1">E</span>Shopper</h1>
      </a>
    </div>
    <div class="col-lg-6 col-6 text-left">
      <form action="<%=request.getContextPath()%>/search" method="post" role="search">
        <div class="input-group">
          <input type="search" name="searchString" class="form-control" placeholder="Search for products">
          <div class="input-group-append">
                            <button type="submit" class="input-group-text bg-transparent text-primary">
                                <i class="fa fa-search"></i>
                            </button>
          </div>
        </div>
      </form>
    </div>

    <div class="col-lg-3 col-6 text-right">
      <a href="<%=request.getContextPath()%>/order" class="btn border">
        <i class="fa fa-box-open text-primary"></i>
        <span class="badge">0</span>
      </a>
      <a href="<%=request.getContextPath()%>/userFollow" class="btn border">
        <i class="fa fa-heart text-primary"></i>
        <span class="badge">0</span>
      </a>
      <a href="<%=request.getContextPath()%>/cart" class="btn border">
        <i class="fa fa-shopping-cart text-primary"></i>
        <span class="badge">0</span>
      </a>
    </div>
  </div>
</div>
