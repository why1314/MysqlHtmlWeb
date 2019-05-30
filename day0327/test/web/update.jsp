<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
    <head>
        <base href="<%=basePath%>"/>
        <!-- 指定字符集 -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>修改用户</title>

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <script src="js/jquery-2.1.0.min.js"></script>
        <script src="js/bootstrap.min.js"></script>


    </head>
    <body>
        <div class="container" style="width: 400px;">
            <h3 style="text-align: center;">修改联系人</h3>
            <form action="${pageContext.request.contextPath}/update?curPage=${curPage}" method="post">
                <input type="hidden" name="id" value="${contact.id}">
                <div class="form-group">
                    <label for="name">姓名：</label>
                    <input type="text" class="form-control" id="name" value="${contact.name}" name="name"
                           readonly="readonly"
                           placeholder="请输入姓名"/>
                </div>

                <div class="form-group">
                    <label>性别：</label>
                    <%--<c:if test="${contact.sex=='男'}">
                        <input type="radio" name="sex" checked="checked" value="男"/>男
                        <input type="radio" name="sex" value="女"/>女
                    </c:if>
                    <c:if test="${contact.sex=='女'}">
                        <input type="radio" name="sex" value="男"/>男
                        <input type="radio" name="sex" checked="checked" value="女"/>女
                    </c:if>--%>
                    <input type="radio" name="sex" ${contact.sex == '男' ? 'checked':''} value="男"/>男
                    <input type="radio" name="sex" ${contact.sex == '女' ? 'checked':''} value="女"/>女
                </div>

                <div class="form-group">
                    <label for="age">年龄：</label>
                    <input type="text" class="form-control" id="age" value="${contact.age}" name="age"
                           placeholder="请输入年龄"/>
                </div>

                <div class="form-group">
                    <label for="address">籍贯：</label>
                    <select name="address" id="address" class="form-control">
                        <option ${contact.address == '广东' ? 'selected':''} value="广东">广东</option>
                        <option ${contact.address == '广西' ? 'selected':''} value="广西">广西</option>
                        <option ${contact.address == '湖南' ? 'selected':''} value="湖南">湖南</option>
                    </select>
                </div>

                <div class="form-group">
                    <label for="qq">QQ：</label>
                    <input type="text" class="form-control" value="${contact.qq}" name="qq" placeholder="请输入QQ号码"/>
                </div>

                <div class="form-group">
                    <label for="email">Email：</label>
                    <input type="text" class="form-control" value="${contact.email}" id="email" name="email"
                           placeholder="请输入邮箱地址"/>
                </div>

                <div class="form-group" style="text-align: center">
                    <input class="btn btn-primary" type="submit" value="提交"/>
                    <input class="btn btn-default" type="reset" value="重置"/>
                    <input class="btn btn-default" type="button" value="返回"/>
                </div>
            </form>
        </div>
    </body>
</html>