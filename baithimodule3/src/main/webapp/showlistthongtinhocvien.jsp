<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 06/09/2023
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>

<table class="table table-striped">
    <h1> List category</h1>
    <button >
        <a class="btn btn-warning" href="ThongTinHocVienServlet?action=addThongTin">Add Thông Tin</a>
    </button>
    <tr>
        <th>Name</th>
        <th>Email</th>
        <th>Date of Birth</th>
        <th>Address</th>
        <th>Phone</th>
        <th>Class room</th>
    </tr>
    <c:forEach items="${listthongtin}" var="t">
        <tr>
            <td><c:out value="${t.getName()}"></c:out></td>
            <td><c:out value="${t.getEmail()}"></c:out></td>
            <td><c:out value="${t.getDateOfBirth()}"></c:out></td>
            <td><c:out value="${t.getAddress()}"></c:out></td>
            <td><c:out value="${t.getPhone()}"></c:out></td>
            <td><c:out value="${t.getClassRoom().getNameClass()}"></c:out></td>
            <a class="btn btn-danger" href="ThongTinHocVienServlet?action=update&&name=${t.getName()}">update</a>
            <a class="btn btn-danger" href="ThongTinHocVienServlet?action=delete&&name=${t.getName()}">delete</a>
        </tr>
    </c:forEach>
</table>
<td><a class="btn btn-danger" href="ThongTinHocVienServlet?action=">BacktoList</a></td>
</body>
</html>
