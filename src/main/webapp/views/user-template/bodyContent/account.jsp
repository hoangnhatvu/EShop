<%--
  Created by IntelliJ IDEA.
  User: toan
  Date: 07/12/2022
  Time: 18:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
</div>
</div>
</div>
<div class="container" style="width: 50%;">
<form method="post" action="<%=request.getContextPath()%>/account/update">
    <img class="img-fluid-avatar" src="${user.avatar}">
    <div>Ten</div><input name="firstName" value="${user.firstName}">
    <div>Ho</div><input name="lastName" value="${user.lastName}">
    <div>CCCD</div><input name="idCard" value="${user.idCard}">
    <div>Dia Chi</div><input name="addresses" value="${user.addresses}">
    <div>Anh dai dien</div><input name="avatar" value="${user.avatar}">
    <div>Anh Bia</div><input name="cover" value="${user.cover}">
    <div>Diem</div><input name="point" value="${user.point}" disabled>
    <button type="reset">Hủy thay đổi</button>
    <button type="submit">Thay đổi</button>
</form>
${updateMsg}
<button><a href="<%=request.getContextPath()%>/account/changePasswd">Doi Mat Khau</a></button>
</div>

