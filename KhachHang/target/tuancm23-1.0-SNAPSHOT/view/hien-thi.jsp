<%--
  Created by IntelliJ IDEA.
  User: chutu
  Date: 3/19/2023
  Time: 8:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body class="container">
<form action="/khach-hang/add" method="post">
    <div class="row mb-3">
        <label class="col-sm-2 col-form-label">ID</label>
        <div class="col-sm-10">
            <input type="number" class="form-control" name="id">
        </div>
    </div>
    <div class="row mb-3">
        <label class="col-sm-2 col-form-label">Name</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" name="name">
        </div>
    </div>
    <div class="row mb-3">
        <label class="col-sm-2 col-form-label">Address</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" name="address">
        </div>
    </div>
    <div class="row mb-3">
        <label class="col-sm-2 col-form-label">Status</label>
        <div class="col-sm-10">
            <select class="form-select" aria-label="Default select example" name="status">
                <option selected value="0">Đang hoạt động</option>
                <option value="1">Không hoạt động</option>
            </select>
        </div>
    </div>
    <fieldset class="row mb-3">
        <legend class="col-form-label col-sm-2 pt-0">Giới tính</legend>
        <div class="col-sm-10">
            <div class="form-check">
                <input class="form-check-input" type="radio" name="gioiTinh" value="0" checked >
                <label class="form-check-label">
                    Nam
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="gioiTinh" value="1">
                <label class="form-check-label">
                    Nữ
                </label>
            </div>
        </div>
    </fieldset>
    <button type="submit" class="btn btn-success">Thêm</button>
</form>
<table class="table">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Name</th>
        <th scope="col">Address</th>
        <th scope="col">Status</th>
        <th scope="col">Gioi tinh</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${khachHangs}" var="kh">
        <tr>
            <td>${kh.id}</td>
            <td>${kh.name}</td>
            <td>${kh.address}</td>
            <td>
                <c:if test="${kh.status == 0}">
                    Đang hoạt động
                </c:if>
                <c:if test="${kh.status == 1}">
                    Không hoạt động
                </c:if>
            </td>
            <td>
                <c:if test="${kh.gender == 0}">
                    Nam
                </c:if>
                <c:if test="${kh.gender == 1}">
                    Nữ
                </c:if>
            </td>
            <td>
                <a href="/khach-hang/detail?id=${kh.id}">Detail</a>
                <a href="/khach-hang/delete?id=${kh.id}">Xoa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
