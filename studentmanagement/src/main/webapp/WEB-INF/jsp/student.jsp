<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Management</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"
          charset="utf-8">
</head>
<style>
    .table, tr, th, td {
        border-collapse: collapse;
        border: 1px solid #ccc;
        padding: 3px;
    }
</style>
<body>
<div class="container">
    <form action="/addstudent" id="studentForm" enctype="multipart/form-data" method="POST">
        <table>
            <tr>
                <td>Name</td>
                <td><input name="name"></td>
            </tr>
            <tr>
                <td>Old</td>
                <td><input name="old"></td>
            </tr>
            <tr>
                <td>Phone</td>
                <td><input name="phone"></td>
            </tr>
            <tr>
                <td>Class</td>
                <td><input name="class"></td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <button type="submit">Submit</button>
                </td>
            </tr>
        </table>
    </form>
</div>
<div class="container">
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Old</th>
            <th>Phone</th>
            <th>CLass name</th>
            <th>Create date</th>
            <th>Create by</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${studentList}" var="item">
            <tr>
                <td>${item.id}</td>
                <td>${item.name}</td>
                <td>${item.old}</td>
                <td>${item.phone}</td>
                <td>${item.className}</td>
                <td>${item.createBy}</td>
                <td>${item.createDate}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<script>
</script>
</body>
</html>