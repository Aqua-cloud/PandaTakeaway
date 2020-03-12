<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
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

        .rg_right p a {
            color: cornflowerblue;
        }

        .td_left {
            width: 100px;
            text-align: right;
            height: 55px;
        }

        .td_right {
            padding-left: 50px;
        }

        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
        }

        li {
            display: inline;
        }

        #username, #password {
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

    </style>
</head>
<body>

<div class="rg_layout">
    <div class="rg_left">
        <p>用户登录</p>
        <p>USER LOGIN</p>
    </div>
    <div class="rg_center">
        <div class="rg_form">
            <form action="/panda_takeaway/loginServlet" method="post">
                <table>
                    <tr>
                        <td class="td_left"><label for="username">用户名</label></td>
                        <td class="td_right"><input type="text" name="username" placeholder="请输入用户名" id="username"></td>
                    </tr>
                    <tr>
                        <td class="td_left"><label for="password">密码</label></td>
                        <td class="td_right"><input type="test" name="password" placeholder="请输入密码" id="password"></td>
                    </tr>
                    <tr>
                        <td class="td_left">您是</td>
                        <td class="td_right">
                            <ul>
                                <li>顾客<input type="radio" name="user" value="customer"></li>
                                <li>商家<input type="radio" name="user" value="shop"></li>
                                <li>管理员<input type="radio" name="user" value="webmaster"></li>
                            </ul>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center"><input type="submit" value="登录" id="button"></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
    <div class="rg_right">
        <p>没有账号?<a href="customerRegister.jsp">立即注册</a></p>
        <p>加入我们?<a href="shopRegister.jsp">申请开店</a></p>
    </div>


</div>

</body>
</html>