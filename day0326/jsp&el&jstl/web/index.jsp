<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>$Title$</title>
    </head>
    <body>

        <%
            request.setAttribute("a",5);
            session.setAttribute("b",6);
        %>
        ${a+b}
        <a href="/jsp/body">访问servlet返回数据表格</a><br>
        <a href="hello.jsp">访问hello.jsp返回数据表格</a><br>
        <a href="1.jsp">访问1.jsp返回数据表格</a><br>
        <a href="2.jsp">访问2.jsp执行简单运算</a><br>

    </body>
</html>
