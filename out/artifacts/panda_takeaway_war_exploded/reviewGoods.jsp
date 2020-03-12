<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>审核申请</title>
    <style>
        * {
            margin: 0 auto;
            padding: 0px;
            box-sizing: border-box;
        }

        .fail {
            color: #A6A6A6;
            font-size: 25px;
            margin: 15px;
        }

        .return {
            color: cornflowerblue;
            font-size: 20px;
            margin-left: 1000px;
        }
    </style>
</head>
<body>
<c:if test="${!empty newGoods}">
    <h3 style="..." align="center">新品上市申请</h3>
    <table border="1" width="50%" class="table table-bordered table-hover" cellspacing="0" cellpadding="0"
           bgcolor="#faebd7" align="center">
        <th>编号</th>
        <th>菜名</th>
        <th>价格</th>
        <th>数量</th>
        <th>商家</th>
        <th colspan="2" align="center">操作</th>
        </tr>
        <c:forEach items="${newGoods}" var="goods" varStatus="s">
            <tr>
                <td>${s.count}</td>
                <td>${goods.name}</td>
                <td>${goods.price}</td>
                <td>${goods.limitNum}</td>
                <td>${goods.shopName}</td>
                <td><a href="/panda_takeaway/reviewGoodsServlet?choice=pass&id=${s.count}">通过申请</a></td>
                <td><a href="/panda_takeaway/reviewGoodsServlet?choice=fail&id=${s.count}">拒绝申请</a></td>
            </tr>
        </c:forEach>
    </table>
    </form>
</c:if>
<c:if test="${empty newGoods}">
    <div class="fail">
        <h2>暂时没有申请</h2><br>
    </div>
</c:if>
<div class="return">
    <a href="/panda_takeaway/webmasterIndex.jsp">返回主页</a>
</div>
</body>
</html>
