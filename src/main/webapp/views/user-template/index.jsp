<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%--
  Created by IntelliJ IDEA.
  User: toan
  Date: 15/12/2022
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


    <jsp:include page="head/slider.jsp"/>
   </div>
  </div>
 </div>

 <jsp:include page="head/feature.jsp"/>
<jsp:include page="head/bestCategories.jsp">
    <jsp:param name="categories" value="${categories}"/>
</jsp:include>

 <jsp:include page="head/offer.jsp"/>
 <!-- Head End -->

 <!-- Body Start -->

<jsp:include page="include/TrendyProduct.jsp">
    <jsp:param name="trendyProd" value="${trendyProd}"/>
</jsp:include>

 <jsp:include page="include/Subcribe.jsp"/>

<jsp:include page="include/NewArrival.jsp">
    <jsp:param name="arrivalProd" value="${arrivalProd}"/>
</jsp:include>

<jsp:include page="include/vendorList.jsp">
    <jsp:param name="topVendor" value="${topVendor}"/>
</jsp:include>


 <!-- Body End -->




