<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta charset="utf-8">
        <title>收藏排行榜</title>
        <link rel="stylesheet" type="text/css" href="css/common.css">
        <link rel="stylesheet" type="text/css" href="css/ranking-list.css">
        <script src="js/jquery-3.3.1.js"></script>
    </head>
    <body>
        <!--引入头部-->
        <jsp:include page="header.jsp"></jsp:include>
        <div class="contant">
            <div class="shaixuan">
                <span>线路名称</span>
                <input type="text">
                <span>金额</span>
                <input type="text">~<input type="text">
                <button>搜索</button>
            </div>
            <div class="list clearfix">
                <ul>
                    <c:forEach items="${pb.data}" var="route" varStatus="status">
                        <li>
                            <span class="num one">${status.count+pb.startIndex}</span>
                            <a href="route_detail.html"><img src="${route.rimage}" alt=""></a>
                            <h4><a href="route_detail.html">${route.rname}</a></h4>
                            <p>
                                <b class="price">&yen;<span>${route.price}</span>起</b>
                                <span class="shouchang">已收藏${route.count}次</span>
                            </p>
                        </li>
                    </c:forEach>

                </ul>
            </div>
            <div class="pageNum">
                <ul>
                    <li>
                        <a href="<%=request.getContextPath()%>/favorite?method=findRouteByRank&pageNumber=1"
                           +${cid}">首页</a></li>
                    <c:if test="${pb.pageNumber>1}">
                        <li class="threeword">
                            <a href="<%=request.getContextPath()%>/favorite?method=findRouteByRank&pageNumber=${pb.pageNumber-1}">上一页</a>
                        </li>
                    </c:if>
                    <c:if test="${pb.pageNumber<=1}">
                        <li class="threeword">
                            <a href="javaScript:void(0)">上一页</a>
                        </li>
                    </c:if>

                    <%--中间页列表--%>
                    <c:forEach begin="${pb.start}" end="${pb.end}" step="1" var="i">
                        <c:if test="${pb.pageNumber==i}">
                            <li style="background-color: yellow">
                                <a href="<%=request.getContextPath()%>/favorite?method=findRouteByRank&pageNumber=${i}">${i}</a>
                            </li>
                        </c:if>
                        <c:if test="${pb.pageNumber!=i}">
                            <li>
                                <a href="<%=request.getContextPath()%>/favorite?method=findRouteByRank&pageNumber=${i}">${i}</a>
                            </li>
                        </c:if>

                    </c:forEach>

                    <%--下一页--%>
                    <c:if test="${pb.pageNumber<pb.totalPage}">
                    <li class="threeword">
                        <a href="<%=request.getContextPath()%>/favorite?method=findRouteByRank&pageNumber=${pb.pageNumber+1}>下一页</a>
                            </li>
                        </c:if>
                        <c:if test="${pb.pageNumber>=pb.totalPage}">
                            <li class=" threeword">
                        <a href="javaScript:void(0)">下一页</a>
                    </li>
                    </c:if>
                    <%--末页--%>
                    <li class="threeword">
                        <a href="<%=request.getContextPath()%>/favorite?method=findRouteByRank&pageNumber=${pb.totalPage}">末页</a>
                    </li>
                </ul>
            </div>
        </div>

        <!--导入底部-->
        <jsp:include page="footer.jsp"></jsp:include>
        <!--导入布局js，共享header和footer-->

    </body>
</html>
