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

    </style>
</head>
<body>
<div class="rg_layout">
    <div class="rg_left">
        <p>修改菜品</p>
        <p>UPDATE </p>
    </div>
    <div class="rg_center">
        <div class="rg_form">
            <form action="/panda_takeaway/goodsUpdateServlet" method="post">
                <table>
                    <tr>
                        <td class="td_left"><label for="username">菜名</label></td>
                        <td class="td_right"><input type="text" name="name" value="${goods.name}" id="username"></td>
                    </tr>
                    <tr>
                        <td class="td_left"><label for="password">价格</label></td>
                        <td class="td_right"><input type="test" name="price" value="${goods.price}" id="password"></td>
                    </tr>
                    <tr>
                        <td class="td_left"><label for="address">数量</label></td>
                        <td class="td_right"><input type="text" name="limitNum" value="${goods.limitNum}" id="address">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <button type="submit" name="goodsId" value="${goods.id}" id="button">修改</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>

</div>
</body>
</html>