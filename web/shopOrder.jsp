<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>订单</title>
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
<c:if test="${!empty ShopOrder}">
    <h3 style="..." align="center">订单信息</h3>
    <table border="1" width="50%" class="table table-bordered table-hover" cellspacing="0" cellpadding="0"
           bgcolor="#faebd7"
           align="center">
        <th>编号</th>
        <th>订单时间</th>
        <th>客户名</th>
        <th>客户地址</th>
        <th>客户电话</th>
        <th>菜品名称</th>
        <th>数量</th>
        <th>总金额</th>
        <th>处理</th>
        </tr>
        <c:forEach items="${ShopOrder}" var="order" varStatus="s">
            <tr>
                <form action="/panda_takeaway/acceptOrderServlet" method="post">
                    <td>${s.count}</td>
                    <td>
                        <fmt:formatDate value="${order.orderTime}" pattern="yyyy-MM-dd HH:mm" /></td>
                    <td>${order.customerName}</td>
                    <td>${order.customerAddress}</td>
                    <td>${order.customerPhone}</td>
                    <td>${order.goodsName}</td>
                    <td>${order.number}</td>
                    <td>${order.totalCost}</td>
                    <td>
                        <button type="submit" name="orderId" value="${order.id}">接单</button>
                    </td>
                </form>
            </tr>
        </c:forEach>
    </table>
</c:if>
<div class="return">
    <a href="/panda_takeaway/shopIndex.jsp">返回主页</a>
</div>
<c:if test="${empty ShopOrder}">
    <div class="fail">
        <h2>暂时没有订单</h2><br>
    </div>
</c:if>
</body>
</html>
