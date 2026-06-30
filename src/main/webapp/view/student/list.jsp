<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <c:import url="../layout/library.jsp"/>
</head>
</head>
<body>
<c:import url="../layout/my-navbar.jsp"/>
<h1>Danh sách sinh viên</h1>
<c:if test="${param.mess}">
    <h2 class="text-danger">Xoá thành công</h2>
</c:if>

<a href="/student?action=add">Thêm mới</a>
<table id="tableStudent" class="table table-dark table-striped">
    <thead>
    <tr>
        <th>STT</th>
        <th>Id</th>
        <th>Tên</th>
        <th>Giới tính</th>
        <th>Tên lớp</th>
        <th>Xoá</th>

    </tr>
    </thead>
   <tbody>
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
           <td>
               <button onclick="getInfoToDelete('${student.id}','${student.name}')" type="button" class="btn btn-danger btn-sm" data-bs-toggle="modal" data-bs-target="#exampleModal">
                   Xoá
               </button>
           </td>
       </tr>
   </c:forEach>
   </tbody>


</table>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form action="/student?action=delete" method="post">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <input type="hidden" name="deleteId" id="deleteId">
                <span>Bạn có muốn xoá sinh viên </span><span class="text-danger" id="deleteName"></span> không?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal"> Huỷ </button>
                <button type="submit" class="btn btn-primary">Xoá</button>
            </div>
        </div>
        </form>
    </div>
</div>
<script>
    function getInfoToDelete(id,name){
        document.getElementById("deleteName").innerHTML = name;
        document.getElementById("deleteId").value = id;
    }
</script>
<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap5.min.js"></script>
<script>
    $(document).ready(function() {
        $('#tableStudent').dataTable( {
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 2,
            "info": false,
            language: {
                emptyTable: "Không có dữ liệu trong bảng",
                paginate: {
                    first: "Đầu",
                    previous: "Trước",
                    next: "Sau",
                    last: "Cuối"
                },
                aria: {
                    sortAscending: ": Sắp xếp tăng dần",
                    sortDescending: ": Sắp xếp giảm dần"
                }
            }
        });
    } );
</script>
</body>
</html>
