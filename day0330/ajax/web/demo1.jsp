<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
        <script type="text/javascript" src="js/jquery-3.3.1.js"></script>
        <script>
            $(function () {
                $("input[name='username']").blur(function () {
                    var url = "demo1";
                    var username = $(this).val();
                    var params = {"username": username};

                    function fun(data) {
                        $("#nameMsg").text(data)
                    }

                    $.post(url, params, fun, "text");
                })
            });
        </script>
    </head>
    <body>
        <form action="">
            <table align="center" border="1px solid red" width="300px" height="100px">
                <tr>
                    <th colspan="2" align="center">
                        用户表单
                    </th>
                </tr>
                <tr>
                    <td>用户名:</td>
                    <td>
                        <input type="text" name="username">
                        <span id="nameMsg"></span>
                    </td>
                </tr>
                <tr>
                    <td>密码:</td>
                    <td>
                        <input type="password" name="pwd">
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" id="subId" value="提交"/>
                    </td>
                </tr>
            </table>

            <br>

        </form>
    </body>
</html>
