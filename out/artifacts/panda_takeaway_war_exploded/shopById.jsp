<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>您的信息</title>
    <style>
        .return {
            color: cornflowerblue;
            font-size: 20px;
            margin-left: 1000px;
        }
    </style>
</head>
<body>
<h3 style="..." align="center">我的信息</h3>
<table border="1" width="50%" class="table table-bordered table-hover" cellspacing="0" cellpadding="0" bgcolor="#faebd7"
       align="center">
    <th>用户名</th>
    <th>密码</th>
    <th>地址</th>
    <th>电话</th>
    <th>营业额</th>
    <th>评价</th>
    </tr>
    <tr>
        <td>${shop.name}</td>
        <td>${shop.password}</td>
        <td>${shop.address}</td>
        <td>${shop.phone}</td>
        <td>${shop.turnover}</td>
        <td>${shop.evaluation}</td>
        <td><a href="${pageContext.request.contextPath}/shopUpdate.jsp">修改信息</a></td>
    </tr>
</table>
<div class="return">
    <a href="/panda_takeaway/shopIndex.jsp">返回主页</a>
</div>
</body>
</html>
