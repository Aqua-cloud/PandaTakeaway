<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商户界面</title>
    <style>
        * {
            margin: 0 auto;
            padding: 0px;
            box-sizing: border-box;
        }

        .success {
            color: #A6A6A6;
            font-size: 20px;
            margin: 15px;
        }

        .order {
            color: cornflowerblue;
            font-size: 30px;
            margin: 100px;
        }

        .update {
            color: black;
            font-size: 20px;
            margin-left: 1000px;
            margin-top: 50px;
        }

        .goods {
            color: black;
            font-size: 20px;
            margin-left: 1000px;
            margin-top: 50px;
        }
    </style>
</head>
<body>
<div class="success">
    <h2>欢迎您,${shop.name}</h2><br>
    <h2>您现在的营业额为${shop.turnover}元</h2><br>
</div>
<h3 style="..." align="center">菜单</h3>
<table border="1" width="50%" class="table table-bordered table-hover" cellspacing="0" cellpadding="0" bgcolor="#faebd7"
       align="center">
    <th>编号</th>
    <th>菜品</th>
    <th>价格</th>
    <th>数量</th>
    <th>操作</th>
    </tr>
    <c:forEach items="${goodsList}" var="goods" varStatus="s">
        <tr>
            <td>${s.count}</td>
            <td>${goods.name}</td>
            <td>${goods.price}</td>
            <td>${goods.limitNum}</td>
            <td>
                <a href="/panda_takeaway/goodsByIdServlet?goodsId=${goods.id}">修改</a>
                <a href="/panda_takeaway/deleteGoodsServlet?goodsId=${goods.id}">删除</a>
            </td>
            </form>
        </tr>
    </c:forEach>
</table>
<div class="order">
    <a href="/panda_takeaway/shopOrderServlet">查看订单信息</a>
</div>
<div class="update">
    <a href="/panda_takeaway/shopById.jsp">我的信息</a>
</div>
<div class="goods">
    <a href="/panda_takeaway/addGoods.jsp">上市新菜</a>
</div>
</body>
</html>

