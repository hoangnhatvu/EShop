<%--
  Created by IntelliJ IDEA.
  User: toan
  Date: 20/12/2022
  Time: 09:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<tr class = "odd gradeX">
  <div>
    <div class="d-flex">
      <div>
        <a class="d-flex mb-3" href="<%=request.getContextPath()%>/store?storeId=${requestScope.store.id}">
          <img src="${requestScope.store.avatar}" class="img-fluid-avatar mr-5">
          <div class="d-block">
            <h4 class="font-weight-semi-bold">${requestScope.store.name}</h4>
            <div class="text-primary mr-2">
              <c:forEach begin="${1}" end="${requestScope.store.rating}">
                <small class="fa fa-star"></small>
              </c:forEach>
              <c:forEach begin="${requestScope.store.rating + 1}" end="${5}">
                <small class="far fa-star"></small>
              </c:forEach>
            </div>
          </div>
        </a>
      </div>
      <a style="margin-top: 15px;margin-left: auto;" href="<%=request.getContextPath()%>/followStore?storeId=${requestScope.store.id}">Follow</a>
    </div>
    <p>${requestScope.store.bio}</p>
  </div>
</tr>
