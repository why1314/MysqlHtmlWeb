<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <%--${}--%>
        <%--<%=pageContext.getRequest().getServletContext().getContextPath() %>--%>

        <%--${}--%>
        <%--<% %>--%>
            <%
                pageContext.setAttribute("a",1);
            %>
        <c:if test="${3<4}" var="flag" scope="page">
            ${flag}
            ${pageScope.flag}
            ${pageScope.a}
        </c:if>

        <%
            ArrayList<String> list = new ArrayList<>();
            list.add("1");
            list.add("2");
            list.add("3");
            list.add("4");
            list.add("5");
            list.add("6");
            request.setAttribute("strList", list);
        %>
        <%--${}--%>
        <c:forEach var="i" items="${requestScope.get('strList')}">
            ${i}
        </c:forEach>

        <a href="<%--<%=request.getContextPath() %>--%>${pageContext.servletContext.contextPath}/login">获取上一次访问时间</a>

    </body>
</html>
