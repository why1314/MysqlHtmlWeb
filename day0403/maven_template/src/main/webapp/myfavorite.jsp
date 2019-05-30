<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hzb
  Date: 2018/12/22
  Time: 19:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>黑马旅游网-我的收藏</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/common.css">
    <link rel="stylesheet" href="css/index.css">
    <style>
        .tab-content .row>div {
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
                        <%--遍历数据--%>
                        <c:forEach items="${pb.data}" var="route" >
                            <div class="col-md-3">
                                <a href="route_detail.jsp">
                                    <img src="${route.rimage}" alt="">
                                    <div class="has_border">
                                        <h3>${route.rname}</h3>
                                        <div class="price">网付价<em>￥</em><strong>${route.price}</strong><em>起</em></div>
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
                <li><a href="FavoriteServlet?pageNumber=1&method=findMyFavorite">首页</a></li>
                <li class="threeword"><a href="FavoriteServlet?pageNumber=${pb.pageNumber-1}&method=findRouteByPage">上一页</a></li>
                <c:forEach begin="${pb.start}" end="${pb.end}" var="num" step="1">
                    <li ${pb.pageNumber==num ? "class='curPage'" : ""}><a  href="FavoriteServlet?pageNumber=${num}&method=findMyFavorite">${num}</a></li>
                </c:forEach>
                <li class="threeword"><a href="FavoriteServlet?pageNumber=${pb.pageNumber+1}&method=findMyFavorite">下一页</a></li>
                <li class="threeword"><a href="FavoriteServlet?pageNumber=${pb.totalPage}&method=findMyFavorite">末页</a></li>
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
