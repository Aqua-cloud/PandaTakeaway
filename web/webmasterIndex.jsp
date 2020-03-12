<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员</title>
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
            font-size: 30px;
            margin-top: 50px;
            margin-left: 100px;
        }
    </style>
</head>
<body>
<div class="success">
    <h1>欢迎您,管理员</h1><br>
</div>
<div class="order">
    <a href="/panda_takeaway/customerListServlet">查看顾客信息</a><br>
    <a href="/panda_takeaway/shopListServlet">查看商户信息</a><br>
    <a href="/panda_takeaway/reviewRegistration.jsp">审批商户申请</a><br>
    <a href="/panda_takeaway/reviewGoods.jsp">审批菜品上市</a><br>

</div>


</body>
</html>
