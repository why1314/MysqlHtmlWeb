<%--
  Created by IntelliJ IDEA.
  User: 许帅
  Date: 2018/8/18
  Time: 0:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-3.3.1.js"></script>

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
