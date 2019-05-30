<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta charset="utf-8">
        <title>黑马旅游网-我的收藏</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="css/common.css">
        <link rel="stylesheet" href="css/index.css">
        <style>
            .tab-content .row > div {
                margin-top: 16px;
            }

            .tab-content {
                margin-bottom: 36px;
            }
        </style>
        <script src="js/jquery-3.3.1.js"></script>
    </head>
    <body>
        <!--引入头部-->
        <jsp:include page="header.jsp"></jsp:include>
        <!-- 排行榜 start-->
        <!-- 排行榜 start-->
        <section id="content">
            <section class="hemai_jx">
                <div class="jx_top">
                    <div class="jx_tit">
                        <img src="images/icon_5.jpg" alt="">
                        <span>我的收藏</span>
                    </div>
                </div>
                <div class="jx_content">
                    <!-- Tab panes -->
                    <div class="tab-content">
                        <div role="tabpanel" class="tab-pane active" id="home">
                            <div class="row">
                                <c:forEach items="${pb.data}" var="fa">
                                    <div class="col-md-3">
                                        <a href="route_detail.html">
                                            <img src="${fa.route.rimage}" alt="">
                                            <div class="has_border">
                                                <h3>${fa.route.rname}</h3>
                                                <div class="price">
                                                    网付价<em>￥</em><strong>${fa.route.price}</strong><em>起</em></div>
                                            </div>
                                        </a>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="pageNum">
                    <ul>
                        <li>
                            <a href="<%=request.getContextPath()%>/favorite?method=findMyFavoriteByPage&pageNumber=1"
                               +${cid}">首页</a></li>
                        <c:if test="${pb.pageNumber>1}">
                            <li class="threeword">
                                <a href="<%=request.getContextPath()%>/favorite?method=findMyFavoriteByPage&pageNumber=${pb.pageNumber-1}">上一页</a>
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
                                    <a href="<%=request.getContextPath()%>/favorite?method=findMyFavoriteByPage&pageNumber=${i}">${i}</a>
                                </li>
                            </c:if>
                            <c:if test="${pb.pageNumber!=i}">
                                <li>
                                    <a href="<%=request.getContextPath()%>/favorite?method=findMyFavoriteByPage&pageNumber=${i}">${i}</a>
                                </li>
                            </c:if>

                        </c:forEach>

                        <%--下一页--%>
                        <c:if test="${pb.pageNumber<pb.totalPage}">
                        <li class="threeword">
                            <a href="<%=request.getContextPath()%>/favorite?method=findMyFavoriteByPage&pageNumber=${pb.pageNumber+1}>下一页</a>
                            </li>
                        </c:if>
                        <c:if test="${pb.pageNumber>=pb.totalPage}">
                            <li class=" threeword">
                            <a href="javaScript:void(0)">下一页</a>
                        </li>
                        </c:if>
                        <%--末页--%>
                        <li class="threeword">
                            <a href="<%=request.getContextPath()%>/favorite?method=findMyFavoriteByPage&pageNumber=${pb.totalPage}">末页</a>
                        </li>
                    </ul>
                </div>
            </section>
        </section>
        <!-- 排行榜 end-->

        <!--引入尾部-->
        <jsp:include page="footer.jsp"></jsp:include>
        <!--导入布局js，共享header和footer-->

    </body>
</html>
