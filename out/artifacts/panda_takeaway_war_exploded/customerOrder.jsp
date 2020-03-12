<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>订单信息</title>
    <style>
        .return {
            color: cornflowerblue;
            font-size: 20px;
            margin-left: 1000px;
        }

        .fail {
            color: #A6A6A6;
            font-size: 25px;
            margin: 15px;
        }
    </style>
</head>
<body>
<c:if test="${!empty CustomerOrder}">
    <h3 style="..." align="center">订单信息</h3>
    <table border="1" width="50%" class="table table-bordered table-hover" cellspacing="0" cellpadding="0"
           bgcolor="#faebd7"
           align="center">
        <th>编号</th>
        <th>订单时间</th>
        <th>商户</th>
        <th>菜品</th>
        <th>数量</th>
        <th>总金额</th>
        </tr>
        <c:forEach items="${CustomerOrder}" var="order" varStatus="s">
            <tr>
                <td>${s.count}</td>
                <td>${order.orderTime}</td>
                <td>${order.goodsName}</td>
                <td>${order.shopName}</td>
                <td>${order.number}</td>
                <td>${order.totalCost}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<div class="return">
    <a href="/panda_takeaway/customerIndex.jsp">返回主页</a>
</div>
<c:if test="${empty CustomerOrder}">
    <div class="fail">
        <h2>您还未下单哦</h2><br>
    </div>
</c:if>
</body>
</html>
