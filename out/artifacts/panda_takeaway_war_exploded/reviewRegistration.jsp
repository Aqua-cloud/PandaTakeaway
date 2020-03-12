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
<c:if test="${!empty shopList}">
    <h3 style="..." align="center">开户申请</h3>
    <form action="/panda_takeaway/reviewRegistrationServlet" method="post">
        <table border="1" width="50%" class="table table-bordered table-hover" cellspacing="0" cellpadding="0"
               bgcolor="#faebd7" align="center">
            <th>编号</th>
            <th>用户名</th>
            <th>地址</th>
            <th>电话</th>
            <th colspan="2" align="center">操作</th>
            </tr>
            <%!
                List<String> choices = new ArrayList<>();
                int i = 1;
            %>
            <c:forEach items="${shopList}" var="shops" varStatus="s">
                <tr>
                    <td>${s.count}</td>
                    <td>${shops.name}</td>
                    <td>${shops.address}</td>
                    <td>${shops.phone}</td>
                    <td>通过申请<input type="radio" name="choice${s.count}" value="pass"></td>
                    <td>拒绝申请<input type="radio" name="choice${s.count}" value="fail"></td>
                    <%
                        choices.add("choice" + i);
                        i = i + 1;
                        request.getSession().setAttribute("choices", choices);
                    %>
                </tr>
            </c:forEach>
            <td colspan="6" align="center"><input type="submit" value="提交"></td>
        </table>
    </form>
</c:if>
<c:if test="${empty shopList}">
    <div class="fail">
        <h2>暂时没有申请</h2><br>
    </div>
</c:if>
<div class="return">
    <a href="/panda_takeaway/webmasterIndex.jsp">返回主页</a>
</div>
</body>
</html>
