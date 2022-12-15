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
<jsp:include page="header.jsp"/>
 <jsp:include page="head/topBar.jsp"/>
 <div class="container-fluid mb-5">
  <div class="row border-top px-xl-5">
   <jsp:include page="head/categoryList.jsp"/>
   <div class="col-lg-9">
    <jsp:include page="head/navMember.jsp"/>

    <jsp:include page="head/slider.jsp"/>
   </div>
  </div>
 </div>

 <jsp:include page="head/feature.jsp"/>
 <jsp:include page="head/bestCategories.jsp"/>
 <jsp:include page="head/offer.jsp"/>
 <!-- Head End -->

 <!-- Body Start -->

 <jsp:include page="include/TrendyProduct.jsp"/>
 <jsp:include page="include/Subcribe.jsp"/>
 <jsp:include page="include/NewArrival.jsp"/>
 <jsp:include page="include/vendorList.jsp"/>

 <!-- Body End -->

 <!-- Footer Start -->

<jsp:include page="footer.jsp"/>

 <!-- Footer End -->

</html>

