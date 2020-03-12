<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>修改信息</title>
    <style>
        * {
            margin: 0px;
            padding: 0px;
            box-sizing: border-box;
        }

        body {
            background: url("img/registerBackground.png");
        }

        .rg_layout {
            width: 900px;
            height: 500px;
            border: 5px solid #EEEEEE;
            background-color: lightcyan;
            margin: auto;
            margin-top: 30px;
        }

        .rg_left {
            /*border: 1px solid red;*/
            float: left;
        }

        .rg_left > p:first-child {
            color: #FFD026;
            font-size: 25px;
            margin: 15px;
        }

        .rg_left > p:last-child {
            color: #A6A6A6;
            font-size: 25px;
            margin: 15px;
        }

        .rg_center {
            /*border: 1px solid red;*/
            float: left;

            width: 500px;
        }

        .rg_right {
            border: 1px;
            float: right;
            margin: 15px;
        }

        .rg_right > p:first-child {
            color: #A6A6A6;
            font-size: 20px;
        }

        .td_left {
            width: 100px;
            text-align: right;
            height: 55px;
        }

        .td_right {
            padding-left: 50px;
        }

        #username, #password, #address, #phone {
            width: 252px;
            height: 25px;
            border: #A6A6A6;
            border-radius: 5px;
            padding-left: 10px;
        }

        #button {
            width: 60px;
            height: 30px;
            background: #FFD026;
        }

        .rg_right {
            color: #A6A6A6;
            font-size: 20px;
        }
    </style>
</head>
<body>
<div class="rg_layout">
    <div class="rg_left">
        <p>修改信息</p>
        <p>UPDATE INFORMATION</p>
    </div>
    <div class="rg_center">
        <div class="rg_form">
            <form action="/panda_takeaway/customerUpdateServlet" method="post">
                <table>
                    <tr>
                        <td class="td_left"><label for="username">用户名</label></td>
                        <td class="td_right"><input type="text" name="username" value="${customer.username}"
                                                    id="username"></td>
                    </tr>
                    <tr>
                        <td class="td_left"><label for="password">密码</label></td>
                        <td class="td_right"><input type="test" name="password" value="${customer.password}"
                                                    id="password"></td>
                    </tr>
                    <tr>
                        <td class="td_left"><label for="address">地址</label></td>
                        <td class="td_right"><input type="text" name="address" value="${customer.address}" id="address">
                        </td>
                    </tr>
                    <tr>
                        <td class="td_left"><label for="phone">手机号</label></td>
                        <td class="td_right"><input type="text" name="phone" value="${customer.phone}" id="phone"></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center"><input type="submit" value="修改" id="button"></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
    <div class="rg_right">
        <p><a href="customerById.jsp">返回</a></p>
    </div>
</div>
</body>
</html>