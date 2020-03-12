<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        #number {
            width: 40px;
        }

        .return {
            color: cornflowerblue;
            font-size: 20px;
            margin-left: 1000px;
        }
    </style>
</head>
<body>
<h3 style="..." align="center">菜单</h3>
<table border="1" width="50%" class="table table-bordered table-hover" cellspacing="0" cellpadding="0" bgcolor="#faebd7"
       align="center">
    <th>编号</th>
    <th>菜品</th>
    <th>价格</th>
    <th>数量</th>
    <th></th>
    </tr>
    <c:forEach items="${goodsList}" var="goods" varStatus="s">
        <tr>
            <form action="/panda_takeaway/businessServlet" method="post">
                <td>${s.count}</td>
                <td>${goods.name}</td>
                <td>${goods.price}</td>
                <td>${goods.limitNum}</td>
                <td>数量<input type="number" name="num" id="number" value="0"></input>
                    <button type="submit" name="goodsId" value="${goods.id}">下单</button>
                </td>
            </form>
        </tr>
    </c:forEach>
</table>
<div class="return">
    <a href="/panda_takeaway/customerIndex.jsp">返回主页</a>
</div>
</body>
</html>
