<%--
  Created by IntelliJ IDEA.
  User: toan
  Date: 15/12/2022
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<div class="container-fluid py-5">
  <div class="row px-xl-5">
    <div class="col">
      <div class="owl-carousel vendor-carousel">
      <c:forEach var="vendor" items="${topVendor}" varStatus="STT">
          <div class="vendor-item border p-4">
            <a href="<%=request.getContextPath()%>/store?storeId=${vendor.id}">
              <img class="vendor-img" src="${vendor.avatar}" alt="${vendor.name}">
            </a>
          </div>
      </c:forEach>
      </div>
    </div>
  </div>
</div>
