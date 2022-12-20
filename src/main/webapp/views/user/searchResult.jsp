<%--
  Created by IntelliJ IDEA.
  User: toan
  Date: 22/11/2022
  Time: 15:40
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
            <a class="nav-item nav-link" data-toggle="tab" href="#tab-pane-3" style="font-size: 1.5rem;">Người dùng</a>
        </div>
        <div class="tab-content">
            <div class="tab-pane fade show active" id="tab-pane-1">
                <c:if test="${fn:length(productList) <= 0}">
                    <h3>Không tìm thấy sản phẩm</h3>
                </c:if>
                <div class="container-fluid pt-5">
                    <div class="row px-xl-5">
                        <c:forEach var="prod" items="${productList}" varStatus="STT">
                            <c:set var="prod" value="${prod}" scope="request"/>
                            <c:import url="/views/user-template/include/productBox.jsp"/>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <div class="tab-pane fade" id="tab-pane-2">
                <c:if test="${fn:length(storeList) <= 0}">
                    <h3>Không tìm thấy cửa hàng</h3>
                </c:if>
                <div class="container-fluid pt-5">
                    <div class="row px-xl-5">
                        <c:forEach var="store" items="${storeList}">
                            <c:set var="store" value="${store}" scope="request"/>
                            <c:import url="/views/user-template/include/storeBox.jsp"/>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <div class="tab-pane fade" id="tab-pane-3">
                <c:if test="${fn:length(userList) <= 0}">
                    <h3>Không tìm thấy người dùng</h3>
                </c:if>
                <table>
                    <tbody>
                    <c:forEach var="user" items="${userList}">
                        <tr class = "odd gradeX">
                            <td><img width="50px" height="50px"src="${user.avatar}"></td>
                            <td>${user.firstName} ${user.lastName}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>


