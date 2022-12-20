<%--
  Created by IntelliJ IDEA.
  User: toan
  Date: 07/12/2022
  Time: 21:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
</div>
</div>
</div>
<div class="container" style="width: 50%;">
<form method="post" action="changePasswd">
  <div>Mật khẩu cũ</div><input name="password" id="password" type="password" required>
  <div>Mật khẩu mới</div><input name="newPassword" id="newPassword" type="password" minlength="8" required>
  <div>Nhập lại mật khẩu mới</div><input name="confirmNewPassword" id="confirmNewPassword" type="password" minlength="8" required>
  <span id="message"></span>
  <button><a href="account">Trở lại</a></button>
  <button id="submitBtn" type="submit">Thay đổi</button>
</form>
${updateMsg}
</div>
<script>

</script>

