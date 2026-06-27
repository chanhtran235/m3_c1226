<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <c:import url="../layout/library.jsp"/>
</head>
<body>
<c:import url="../layout/my-navbar.jsp"/>
<h1>Danh sách sinh viên</h1>
<a href="/student?action=add">Thêm mới</a>
<table class="table table-dark table-striped">
    <tr>
        <th>STT</th>
        <th>Id</th>
        <th>Tên</th>
        <th>Giới tính</th>
        <th>Tên lớp</th>

    </tr>
    <c:forEach var="student" items="${studentList}" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>
                <c:if test="${student.gender}">
                    <span>Nam</span>
                </c:if>
                <c:if test="${!student.gender}">
                    <span>Nữ</span>
                </c:if>
            </td>
            <td>${student.className}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
