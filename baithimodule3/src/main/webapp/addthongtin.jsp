<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 06/09/2023
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="post" action="ThongTinHocVienServlet?action=addthongtin">
  <p>Nhập name</p>
  <input name="name" placeholder="input id" value="${thongtin.getName()}">
  <p>Nhập email</p>
  <input name="email" placeholder="input id" value="${thongtin.getEmail()}">
  <p>Nhập dateofbirth</p>
  <input name="date" placeholder="input id" value="${thongtin.getDataOfirth()}">
  <p>Nhập Address</p>
  <input name="address" placeholder="input id" value="${thongtin.getAddress()}">
  <p>Nhập Phonenumber</p>
  <input name="phone" placeholder="input name" value="${thongtin.getPhone()}">
  <p>Nhập Class</p>
  <input name="class" placeholder="Input price" value="${thongtin.getClassRoom().getNameClass()}">
  <input type="submit" value="sumit">
</form>
</body>
</html>
