<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>黑马旅游-搜索</title>
    <link rel="stylesheet" type="text/css" href="css/common.css">
    <link rel="stylesheet" href="css/search.css">
    <script src="js/jquery-3.3.1.js"></script>
</head>
<body>
<!--引入头部-->

<jsp:include page="header.jsp"></jsp:include>
<div class="page_one">
    <div class="contant">
        <div class="crumbs">
            <img src="images/search.png" alt="">
            <p>黑马旅行><span>搜索结果</span></p>
        </div>
        <div class="xinxi clearfix">
            <div class="left">
                <div class="header">
                    <span>商品信息</span>
                    <span class="jg">价格</span>
                </div>
                <ul>
                    <%--遍历数据--%>
                    <c:forEach items="${pb.data}" var="route">
                        <li>
                            <div class="img"><img src="${route.rimage}" alt=""></div>
                            <div class="text1">
                                <p>${route.rname}</p>
                                <br/>
                                <p>${route.routeIntroduce}</p>
                            </div>
                            <div class="price">
                                <p class="price_num">
                                    <span>&yen;</span>
                                    <span>${route.price}</span>
                                    <span>起</span>
                                </p>
                                <p><a href="RouteServlet?rid=${route.rid}&method=findRouteByRid">查看详情</a></p>
                            </div>
                        </li>
                    </c:forEach>
                </ul>
                <div class="page_num_inf">
                    <i></i> 共
                    <span>${pb.totalPage}</span>页<span>${pb.totalRecord}</span>条
                </div>
                <div class="pageNum">
                    <ul>
                        <li><a href="RouteServlet?cid=${cid}&pageNumber=1&method=findRouteByPage&rname=${rname}">首页</a></li>
                        <li class="threeword"><a href="RouteServlet?cid=${cid}&pageNumber=${pb.pageNumber-1}&method=findRouteByPage&rname=${rname}">上一页</a></li>
                        <c:forEach begin="${pb.start}" end="${pb.end}" var="num" step="1">
                            <li ${pb.pageNumber==num ? "class='curPage'" : ""}><a  href="RouteServlet?cid=${cid}&pageNumber=${num}&method=findRouteByPage&rname=${rname}">${num}</a></li>
                        </c:forEach>
                        <li class="threeword"><a href="RouteServlet?cid=${cid}&pageNumber=${pb.pageNumber+1}&method=findRouteByPage&rname=${rname}">下一页</a></li>
                        <li class="threeword"><a href="RouteServlet?cid=${cid}&pageNumber=${pb.totalPage}&method=findRouteByPage&rname=${rname}">末页</a></li>
                    </ul>
                </div>
            </div>
            <div class="right">
                <div class="top">
                    <div class="hot">HOT</div>
                    <span>热门推荐</span>
                </div>
                <ul>
                    <li>
                        <div class="left"><img src="images/04-search_09.jpg" alt=""></div>
                        <div class="right">
                            <p>清远新银盏温泉度假村酒店/自由行套...</p>
                            <p>网付价<span>&yen;<span>899</span>起</span>
                            </p>
                        </div>
                    </li>
                    <li>
                        <div class="left"><img src="images/04-search_09.jpg" alt=""></div>
                        <div class="right">
                            <p>清远新银盏温泉度假村酒店/自由行套...</p>
                            <p>网付价<span>&yen;<span>899</span>起</span>
                            </p>
                        </div>
                    </li>
                    <li>
                        <div class="left"><img src="images/04-search_09.jpg" alt=""></div>
                        <div class="right">
                            <p>清远新银盏温泉度假村酒店/自由行套...</p>
                            <p>网付价<span>&yen;<span>899</span>起</span>
                            </p>
                        </div>
                    </li>
                    <li>
                        <div class="left"><img src="images/04-search_09.jpg" alt=""></div>
                        <div class="right">
                            <p>清远新银盏温泉度假村酒店/自由行套...</p>
                            <p>网付价<span>&yen;<span>899</span>起</span>
                            </p>
                        </div>
                    </li>
                    <li>
                        <div class="left"><img src="images/04-search_09.jpg" alt=""></div>
                        <div class="right">
                            <p>清远新银盏温泉度假村酒店/自由行套...</p>
                            <p>网付价<span>&yen;<span>899</span>起</span>
                            </p>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>

<!--引入头部-->
<%--<div id="footer"></div>--%>
<jsp:include page="footer.jsp"></jsp:include>
<!--导入布局js，共享header和footer-->
<%--<script type="text/javascript" src="js/include.js"></script>--%>
</body>
</html>
