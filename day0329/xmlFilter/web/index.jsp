<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
    <head>
        <title>$Title$</title>
    </head>
    <body>
        <h3>filter过滤器</h3>
        <a href="${pageContext.request.contextPath}/demo1">过滤器-配置文件方式实现</a>
        <a href="${pageContext.request.contextPath}/demo3">过滤器连-配置文件方式实现</a>
        <hr>
        <form action="${pageContext.request.contextPath}/text" method="post">
            <textarea name="msg" cols="30" rows="10"></textarea><br>
            <input type="submit" value="发布">
        </form>
    </body>
</html>
