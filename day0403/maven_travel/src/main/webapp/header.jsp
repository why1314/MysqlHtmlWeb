<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Title</title>

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="css/common.css">
        <link rel="stylesheet" type="text/css" href="css/index.css">

        <script src="js/jquery-3.3.1.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.validate.min.js"></script>
        <script src="js/messages_zh.js"></script>
        <script type="text/javascript">
            $(function () {

                //用户注册表单的提交
                function submitForm() {
                    var flag = $("#registerForm").validate({
                        rules: {
                            username: {
                                required: true,
                                rangelength: [4, 8]
                            },
                            password: {
                                required: true,
                                rangelength: [6, 12]
                            },
                            email: {
                                required: true,
                                email: "email"
                            },
                            name: "required",
                            telephone: {
                                required: true,
                                number: true,
                                rangelength: [11, 11]
                            },
                            sex: "required",
                            birthday: {
                                required: true,
                                dateISO: true
                            }
                        },
                        messages: {
                            username: {
                                required: "用户名不能为空",
                                rangelength: "用户名长度在{0}-{1}之间"
                            },
                            password: {
                                required: "密码不能为空",
                                rangelength: "密码长度在{0}-{1}之间"
                            },
                            email: {
                                required: "邮箱不能为空",
                                email: "邮箱地址不符合要求"
                            },
                            name: "真实姓名不能为空",
                            telephone: {
                                required: "手机号不能为空",
                                number: "必须全部是数字",
                                rangelength: "手机号长度为11位"
                            },
                            sex: "性别不能为空",
                            birthday: {
                                required: "请选择出生日期"
                            }
                        }
                    });
                    //校验时需要经过提交才能执行校验
                    $("#registerForm").submit();
                    <%--//获得表单的数据--%>
                    <%--var url = "<%=request.getContextPath()%>/user";--%>
                    <%--var params = $("#registerForm").serialize();--%>
                    <%--$.post(url, params, function (data) {--%>

                    <%--//关闭模态框--%>
                    <%--$("#closeId").click();--%>
                    <%--if (data == 1) {--%>
                    <%--//跳转到成功注册页面--%>
                    <%--location.href = "register_ok.jsp";--%>
                    <%--} else {--%>
                    <%--location.href = "error/500.html";--%>
                    <%--}--%>

                    <%--}, "text");--%>
                }
            });
        </script>

    </head>
    <body>

        <!-- 头部 start -->
        <header id="header">
            <div class="top_banner">
                <img src="images/top_banner.jpg" alt="">
            </div>

            <div class="shortcut">
                <c:if test="${empty user}">
                    <!-- 未登录状态 -->
                    <div class="login_out">
                        <a data-toggle="modal" data-target="#loginModel">登录</a>
                        <a data-toggle="modal" data-target="#myModal">注册</a>
                    </div>
                </c:if>
                <c:if test="${not empty user}">
                    <!-- 登录状态 -->
                    <div class="login">
                        <span>欢迎回来，${user.username}</span>
                        <a class="collection"
                           href="<%=request.getContextPath()%>/favorite?method=findMyFavoriteByPage&pageNumber=1">我的收藏</a>
                        <a href="user?method=logout">退出</a>
                    </div>
                </c:if>

                <script>

                </script>
            </div>
            <div class="header_wrap">
                <div class="topbar">
                    <div class="logo">
                        <a href="/"><img src="images/logo.jpg" alt=""></a>
                    </div>
                    <div class="search">
                        <input name="" type="text" placeholder="请输入路线名称" class="search_input" id="rnameId"
                               value="${rname}"
                               autocomplete="off">
                        <a href="javascript:void(0);" onclick="searchClick()" class="search-button">搜索</a>
                    </div>
                    <div class="hottel">
                        <div class="hot_pic">
                            <img src="images/hot_tel.jpg" alt="">
                        </div>
                        <div class="hot_tel">
                            <p class="hot_time">客服热线(9:00-6:00)</p>
                            <p class="hot_num">400-618-9090</p>
                        </div>
                    </div>
                </div>
            </div>
        </header>
        <script>
            function searchClick() {
                var rname = $("#rnameId").val();
                location.href = "<%=request.getContextPath()%>/route?method=findRouteByPage&PageNumber=1&rname=" + rname;
            }
        </script>
        <!-- 头部 end -->
        <!-- 首页导航 -->
        <div class="navitem">
            <ul class="nav" id="categoryUI">
                <li class="nav-active"><a href="index.jsp">首页</a></li>
                <%--<li><a href="route_list.jsp">门票</a></li>
                <li><a href="route_list.jsp">酒店</a></li>
                <li><a href="route_list.jsp">香港车票</a></li>
                <li><a href="route_list.jsp">出境游</a></li>
                <li><a href="route_list.jsp">国内游</a></li>
                <li><a href="route_list.jsp">港澳游</a></li>
                <li><a href="route_list.jsp">抱团定制</a></li>
                <li><a href="route_list.jsp">全球自由行</a></li>
                <li><a href="favoriterank.jsp">收藏排行榜</a></li>--%>
            </ul>
        </div>
        <%--页面成功加载后，向服务器请求查询--%>
        <script>
            $(function () {

                var url = "<%=request.getContextPath()%>/category"
                var params = {"method": "findAllCategory"}
                $.post(url, params, function (data) {

                    if (data.flag) {
                        //
                        var cateArr = data.data;
                        $.each(cateArr, function (index, ele) {
                            $("#categoryUI").append("<li><a href=\"<%=request.getContextPath()%>/route?method=findRouteByPage&cid=" + ele.cid + "&PageNumber=1\" >" + ele.cname + "</a></li>")
                        })
                        $("#categoryUI").append("<li><a href='<%=request.getContextPath()%>/favorite?method=findRouteByRank&pageNumber=1'>收藏排行榜</a></li>")
                    } else {

                    }
                }, "json");
            });

        </script>

        <%--注册信息校验--%>
        <script>
            $(function () {
                $("#username").blur(function () {
                    var url = "<%=request.getContextPath()%>/user?method=checkName";
                    var params = {"username": $(this).val()};
                    $.post(url, params, function (data) {
                        $("#spanId").text(data);
                    }, "text");
                });
            })
        </script>

        <!-- 注册 modal-->
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <form id="registerForm" action="<%=request.getContextPath()%>/user" method="post">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                    aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="myModalLabel">用户注册</h4>

                        </div>
                        <div class="modal-body">

                            <%--隐藏域提交数据--%>
                            <input type="hidden" name="method" value="register">
                            <div class="form-group">
                                <label for="username">用户名</label>
                                <input type="text" class="form-control" name="username" id="username"
                                       placeholder="请输入用户名">
                                <span id="spanId"></span>
                            </div>
                            <div class="form-group">
                                <label for="password">密码</label>
                                <input type="text" class="form-control" name="password" id="password"
                                       placeholder="请输入密码">
                            </div>
                            <div class="form-group">
                                <label for="email">email</label>
                                <input type="text" class="form-control" value="1826552585@qq.com" name="email"
                                       id="email"
                                       placeholder="请输入邮箱">
                            </div>

                            <div class="form-group">
                                <label for="name">姓名</label>
                                <input type="text" class="form-control" name="name" id="name" placeholder="请输入姓名">
                            </div>
                            <div class="form-group">
                                <label for="tel">手机号</label>
                                <input type="text" class="form-control" name="telephone" id="tel"
                                       placeholder="请输入手机号">
                            </div>
                            <div class="form-group">
                                <label>性别</label>
                                <input type="radio" class="form-inline" name="sex" value="1">男
                                <input type="radio" class="form-inline" name="sex" value="0">女
                            </div>

                            <div class="form-group">
                                <label for="date">出生日期</label>
                                <input type="date" class="form-control" name="birthday" id="date">
                            </div>

                            <%--<div class="form-group">--%>
                            <%--<label for="code">验证码</label>--%>
                            <%--<input type="text" class="form-control" id="code" name="check" placeholder="请输入手机号">--%>
                            <%--</div>--%>

                        </div>
                        <div class="modal-footer">
                            <span id="errorMsg" style="color: red;"></span>
                            <button type="button" class="btn btn-default" id="closeId" data-dismiss="modal">关闭</button>
                            <button type="button" class="btn btn-primary" onclick="submitForm()">注册</button>
                            <input type="reset" class="btn btn-primary" id="resetId" value="重置">
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <!--登录 Modal -->
        <!-- 登录的模态框 Modal -->
        <div class="modal fade" id="loginModel" tabindex="-1" role="dialog" aria-labelledby="loginModelLable">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="loginModelLable">
                            用户登陆
                            <span id="loginErrorMsg" style="color: red;"></span>
                        </h4>

                    </div>
                    <form id="loginForm">
                        <div class="modal-body">
                            <%--隐藏域提交数据--%>
                            <input type="hidden" name="method" value="login">
                            <div class="form-group">
                                <label for="loginuseraname">用户名</label>
                                <input type="text" class="form-control" name="username" id="loginuseraname"
                                       placeholder="请输入用户名">
                            </div>
                            <div class="form-group">
                                <label for="password">密码</label>
                                <input type="text" class="form-control" name="password" id="loginpassword"
                                       placeholder="请输入密码">
                            </div>
                        </div>
                        <div class="modal-footer">
                            <input type="reset" class="btn btn-primary" id="loginResetId" value="重置">
                            <%--onclick="loginClose()"--%>
                            <button type="button" class="btn btn-default" data-dismiss="modal" id="loginCloseId">关闭
                            </button>
                            <button type="button" class="btn btn-primary" onclick="login()">登陆</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <script>
            function login() {
                var url = "<%=request.getContextPath()%>/user"

                var params = $("#loginForm").serialize();
                $.post(url, params, function (data) {
                    if (data == 0) {
                        $("#loginCloseId").click();
                        location.href = "loginMsg.jsp";
                    } else if (data == 1) {
                        // 关闭模态框
                        $("#loginCloseId").click();
                        // 登录成功
                        location.href = "index.jsp";

                    } else if (data == 2) {
                        // 用户名或密码错误
                        $("#loginErrorMsg").text("用户名或密码错误");
                    }

                }, "text");
            }
        </script>