<%--
  Created by IntelliJ IDEA.
  User: toan
  Date: 09/12/2022
  Time: 22:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
</div>
</div>
</div>
<div class="row px-xl-5">
  <div class="col">
    <div class="nav nav-tabs justify-content-center border-secondary mb-4">
      <a class="nav-item nav-link active font" data-toggle="tab" href="#tab-pane-1" style="font-size: 1.5rem;">Sản phẩm</a>
      <a class="nav-item nav-link" data-toggle="tab" href="#tab-pane-2" style="font-size: 1.5rem;">Cửa hàng</a>
    </div>
    <div class="tab-content">
      <div class="tab-pane fade show active" id="tab-pane-1">
        <c:if test="${fn:length(ufps) <= 0}">
          <h3>Chưa theo dõi sản phẩm nào !</h3>
        </c:if>
        <div class="container-fluid pt-5">
          <div class="row px-xl-5">
            <c:forEach var="prod" items="${ufps}" varStatus="STT">
              <c:set var="prod" value="${prod.product}" scope="request"/>
              <c:import url="/views/user-template/include/productBox.jsp"/>
            </c:forEach>
          </div>
        </div>
      </div>
      <div class="tab-pane fade" id="tab-pane-2">
        <c:if test="${fn:length(ufss) <= 0}">
          <h3>Chưa theo dõi cửa hàng nào !</h3>
        </c:if>
        <div class="container-fluid pt-5">
          <div class="row px-xl-5">
            <c:forEach var="ufss" items="${ufss}">
              <c:set var="store" value="${ufss.store}" scope="request"/>
              <c:import url="/views/user-template/include/storeBox.jsp"/>
            </c:forEach>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>


