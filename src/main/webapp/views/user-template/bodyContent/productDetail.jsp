<%--
  Created by IntelliJ IDEA.
  User: toan
  Date: 15/12/2022
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<!-- Head Start -->
<jsp:include page="../header.jsp"/>
<jsp:include page="../head/topBar.jsp"/>
<div class="container-fluid mb-5">
  <div class="row border-top px-xl-5">
    <jsp:include page="../head/categoryList.jsp"/>
    <div class="col-lg-9">
      <jsp:include page="../head/navMember.jsp"/>
    </div>
  </div>
</div>

<div class="container-fluid bg-secondary mb-5">
  <div class="d-flex flex-column align-items-center justify-content-center" style="min-height: 300px">
    <h1 class="font-weight-semi-bold text-uppercase mb-3">Shop Detail</h1>
    <div class="d-inline-flex">
      <p class="m-0"><a href="">Home</a></p>
      <p class="m-0 px-2">-</p>
      <p class="m-0">Shop Detail</p>
    </div>
  </div>
</div>
<!-- Head End -->

<!-- Body Start -->
<jsp:include page="../include/detail.jsp"/>
<jsp:include page="../include/relatedProd.jsp"/>

<!-- Body End -->

<!-- Footer Start -->

<jsp:include page="../footer.jsp"/>

<!-- Footer End -->

</html>
