<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="css/index.css">
<script src="js/jquery-3.3.1.js"></script>
<script src="js/jquery-3.3.1.js"></script>
<script src="js/getParameter.js"></script>
<!-- 头部 start -->
<header id="header">
    <div class="top_banner">
        <img src="images/top_banner.jpg" alt="">
    </div>

    <div class="shortcut">
        <c:if test="${empty user}">
            <!-- 未登录状态  -->
            <div class="login_out">
                <a data-toggle="modal" data-target="#loginModel">登录</a>
                <a  data-toggle="modal" data-target="#myModal">注册</a>
            </div>
        </c:if>
       <c:if test="${not empty user}">
           <!-- 登录状态  -->
           <div class="login">
               <span>欢迎回来，${user.username}</span>
               <a href="FavoriteServlet?method=findMyFavorite&pageNumber=1" class="collection">我的收藏</a>
               <a href="javascript:;" onclick="loginout()">退出</a>
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
                <input name="" type="text" placeholder="请输入路线名称" class="search_input" id="rnameId" value="${rname}" autocomplete="off">
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
<!-- 头部 end -->
<!-- 首页导航 -->
<div class="navitem">
    <ul class="nav" id="categoryUI">
        <%--<li class="nav-active"><a href="index.html">首页</a></li>
        <li><a href="route_list.jsp">门票</a></li>
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



<!-- 注册 -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <form id="registerForm">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">用户注册</h4>

                </div>
                <div class="modal-body">

                        <%--隐藏域提交数据--%>
                        <input type="hidden" name="method" value="register">
                        <div class="form-group">
                            <label for="useraname">用户名</label>
                            <input type="text" class="form-control" name="username" id="useraname" placeholder="请输入用户名">
                        </div>
                        <div class="form-group">
                            <label for="password">密码</label>
                            <input type="text" class="form-control" name="password" id="password" placeholder="请输入密码">
                        </div>
                        <div class="form-group">
                            <label for="email">email</label>
                            <input type="text" class="form-control" name="email" id="email" placeholder="请输入邮箱">
                        </div>

                        <div class="form-group">
                            <label for="name">姓名</label>
                            <input type="text" class="form-control" name="name" id="name" placeholder="请输入姓名">
                        </div>
                        <div class="form-group">
                            <label for="tel">手机号</label>
                            <input type="text" class="form-control" name="telephone" id="tel" placeholder="请输入手机号">
                        </div>
                        <div class="form-group">
                            <label>性别</label>
                            <input type="radio" class="form-inline" name="sex" value="1" >男
                            <input type="radio" class="form-inline" name="sex"  value="0">女
                        </div>
                        <div class="form-group">
                            <label for="date">出生日期</label>
                            <input type="date" class="form-control" name="birthday" id="date">
                        </div>
                        <div class="form-group">
                            <label for="code">验证码</label>
                            <input type="text" class="form-control" id="code" name="check" placeholder="请输入手机号">
                        </div>

                </div>
                <div class="modal-footer">
                    <span id="errorMsg" style="color: red;"></span>
                    <button type="button" class="btn btn-default" id="closeId" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary"  onclick="closeDialog()">注册</button>
                    <input type="reset" class="btn btn-primary" id="resetId"  value="重置">
                </div>
            </form>
        </div>
    </div>
</div>
<script>
    //动态打开登陆窗口
    function showLoginDialog(){
        //登陆模态框打开
        $('#loginModel').modal('show')
    }
    function closeDialog(){
        //获得表单的数据
        var params = $("#registerForm").serialize();

        $.post("UserServlet" , params , function(resultInfo){
            //重置表单的内容
            if(resultInfo.flag){
                //执行关闭的按钮 关闭当前窗口
                $("#closeId").click();
                //跳转首页
                location.href="register_ok.jsp";
            }else{
                //给页面手动提示信息
                $("#errorMsg").html(resultInfo.errorMsg)
            }
        },"json");
    }
</script>







<!-- Modal -->
<div class="modal fade" id="loginModel" tabindex="-1" role="dialog" aria-labelledby="loginModelLable">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
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
                        <input type="text" class="form-control" name="username" id="loginuseraname" placeholder="请输入用户名">
                    </div>
                    <div class="form-group">
                        <label for="password">密码</label>
                        <input type="text" class="form-control" name="password" id="loginpassword" placeholder="请输入密码">
                    </div>
                </div>
                <div class="modal-footer">
                    <input type="reset" class="btn btn-primary" id="loginResetId"  value="重置">
                    <%--onclick="loginClose()"--%>
                    <button type="button" class="btn btn-default" data-dismiss="modal" id="loginCloseId" >关闭</button>
                    <button type="button" class="btn btn-primary" onclick="login()" >登陆</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script>
    function login(){
        //获得表单的数据
        var params = $("#loginForm").serialize();
        //提交给servlet
        $.post("UserServlet" , params , function(resultInfo){
            //判断返回结果
            if(resultInfo.flag){
                //关闭当前页面
                $("#loginCloseId").click();
                //跳转首页
                location.href="index.jsp";
            }else{
                //添加错误提示信息
                $("#loginErrorMsg").html(resultInfo.errorMsg);
            }
        } , "json");
    }
</script>



<script>
    //加载导航条数据
    $(function(){
        //发送ajax数据
        $.post("CategoryServlet" , {"method" : "findCategory" } , function(data){//resultInfo一般用于判断成功或者失败
            //遍历数据
            var tempStr = "<li class=\"nav-active\"><a href=\"index.html\">首页</a></li>";
            //每一个this表示当前遍历的category对象
            $(data).each(function(){
                //拼接字符串
                tempStr+="<li><a href=\"RouteServlet?cid="+this.cid+"&pageNumber=1&method=findRouteByPage\">"+this.cname+"</a></li>";
            })
            //收藏排行榜
            tempStr += "<li class=\"nav-active\"><a href=\"FavoriteServlet?pageNumber=1&method=favoriteRank\">收藏排行榜</a></li>";
            //覆盖ul下的li
            $("#categoryUI").html(tempStr);
        } , "json");
    })
</script>
<script>
    function searchClick(){
        var rname=$("#rnameId").val();
        //alert(rname)
        var cid = getParameter("cid");
         rname = decodeURI(rname);
        location.href="RouteServlet?method=findRouteByPage&cid="+cid+"&rname="+rname+"&pageNumber=1";
    }
</script>