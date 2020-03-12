<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户信息</title>
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
    <th>余额</th>
    </tr>
    <tr>
        <td>${customer.username}</td>
        <td>${customer.password}</td>
        <td>${customer.address}</td>
        <td>${customer.phone}</td>
        <td>${customer.balance}</td>
        <td><a href="${pageContext.request.contextPath}/customerUpdate.jsp">修改信息</a></td>
    </tr>
</table>
<div class="return">
    <a href="/panda_takeaway/customerIndex.jsp">返回主页</a>
</div>
</body>
</html>
