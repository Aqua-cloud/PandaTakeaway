<%@ page import="com.yjc.www.service.IShopService" %>
<%@ page import="com.yjc.www.service.impl.ShopServiceImpl" %>
<%@ page import="com.yjc.www.po.Shop" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>顾客界面</title>
    <style>
        * {
            margin: 0 auto;
            padding: 0px;
            box-sizing: border-box;
        }

        .success {
            color: #A6A6A6;
            font-size: 10px;
            margin: 15px;
        }

        .order {
            color: cornflowerblue;
            font-size: 20px;
            margin-left: 1000px;
        }

        .update {
            color: black;
            font-size: 20px;
            margin-left: 1000px;
            margin-top: 50px;
        }

        .pay {
            color: black;
            font-size: 20px;
            margin-left: 50px;
        }
    </style>
</head>


<body>
<div class="success">
    <h1>欢迎您,${customer.username}</h1><br>
    <h1>您的余额为${customer.balance}元</h1>
</div>
<table border="1" width="50%" class="table table-bordered table-hover" cellspacing="0" cellpadding="0" bgcolor="#faebd7"
       align="center">
    <th>编号</th>
    <th>商户</th>
    <th>地址</th>
    <th>评价</th>
    <th>操作</th>
    </tr>
    <c:forEach items="${shops}" var="shop" varStatus="s">
        <tr>
            <form action="/panda_takeaway/goodsOfShopServlet" method="post">
                <td>${s.count}</td>
                <td>${shop.name}</td>
                <td>${shop.address}</td>
                <td>${shop.evaluation}</td>
                <td>
                    <button type="submit" name="shopId" value="${s.count}">进入商店</button>
                </td>
            </form>
        </tr>
    </c:forEach>
</table>
<div class="order">
    <a href="/panda_takeaway/customerOrderServlet">您的订单</a>
</div>
<div class="update">
    <a href="/panda_takeaway/customerById.jsp">我的信息</a>
</div>
<div class="pay">
    <a href="/panda_takeaway/orderNoBalance.jsp">立即充值</a>
</div>
</body>
</html>
