<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <%--
        在jspServlet转换jsp也年时，如果遇到html标签，直接以响应流的形式返回

        --%>
        <%
            for (int i = 0; i < 3; i++) {


        %>
        <h3>在jsp中编写java代码</h3>
        <%
            }
            System.out.println("这是jsp页面");
        %>
        <%="hdsgggds"%>



    </body>
</html>
