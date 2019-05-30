<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hzb
  Date: 2018/12/22
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="utf-8">
    <title>路线详情</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/common.css">
    <link rel="stylesheet" type="text/css" href="css/route-detail.css">
</head>

<body>
<!--引入头部-->
<jsp:include page="header.jsp"></jsp:include>
<!-- 详情 start -->
<div class="wrap">
    <div class="bread_box">
        <a href="/">首页</a>
        <span> &gt;</span>
        <a href="#">${route.category.cname}</a><span> &gt;</span>
        <a href="#">${route.rname}</a>
    </div>
    <div class="prosum_box">
        <dl class="prosum_left">
            <dt>
                <img alt="" class="big_img" src="http://www.jinmalvyou.com/Public/uploads/goods_img/img_size4/201703/m49788843d72171643297ccc033d9288ee.jpg">
            </dt>
            <dd>
                <a class="up_img up_img_disable"></a>
                <c:forEach items="${route.routeImgList}" var="routeImg" varStatus="status">
                    <c:if test="${status.index < 4}">
                        <a title="" class="little_img" data-bigpic="${routeImg.bigPic}">
                            <img src="${routeImg.smallPic}">
                        </a>
                    </c:if>
                    <c:if test="${status.index >= 4}">
                        <a title="" class="little_img" data-bigpic="${routeImg.bigPic}" style="display:none;">
                            <img src="${routeImg.smallPic}">
                        </a>
                    </c:if>

                </c:forEach>
                <a class="down_img down_img_disable" style="margin-bottom: 0;"></a>
            </dd>
        </dl>
        <div class="prosum_right">
            <p class="pros_title">${route.rname}</p>
            <p class="hot">${route.routeIntroduce}</p>
            <div class="pros_other">
                <p>经营商家  ：${route.seller.sname}</p>
                <p>咨询电话 : ${route.seller.consphone}</p>
                <p>地址 ： ${route.seller.address}</p>
            </div>
            <div class="pros_price">
                <p class="price"><strong>¥${route.price}</strong><span>起</span></p>
                <p class="collect">
                    <a class="btn" onclick="addFavorite('${route.rid}')"><i class="glyphicon glyphicon-heart-empty"></i>点击收藏</a>
                    <input type="hidden" id="rid" value="${route.rid}">
                   <%-- <a class="btn"><i class="glyphicon glyphicon-heart-empty"></i>点击收藏</a>
                    <a  class="btn already" disabled="disabled" ><i class="glyphicon glyphicon-heart-empty"></i>点击收藏</a>--%>
                    <span>已收藏${route.count}次</span>
                </p>
            </div>
        </div>
    </div>
    <script>

    </script>
    <div class="you_need_konw">
        <span>旅游须知</span>
        <div class="notice">
            <p>1、旅行社已投保旅行社责任险。建议游客购买旅游意外保险 <br>

            <p>2、旅游者参加打猎、潜水、海边游泳、漂流、滑水、滑雪、滑草、蹦极、跳伞、滑翔、乘热气球、骑马、赛车、攀岩、水疗、水上飞机等属于高风险性游乐项目的，敬请旅游者务必在参加前充分了解项目的安全须知并确保身体状况能适应此类活动；如旅游者不具备较好的身体条件及技能，可能会造成身体伤害。</p>

            <p>3、参加出海活动时，请务必穿着救生设备。参加水上活动应注意自己的身体状况，有心脏病、冠心病、高血压、感冒、发烧和饮酒及餐后不可以参加水上活动及潜水。在海里活动时，严禁触摸海洋中各种鱼类，水母，海胆，珊瑚等海洋生物，避免被其蛰伤。老人和小孩必须有成年人陪同才能参加合适的水上活动。在海边游玩时，注意保管好随身携带的贵重物品。</p>

            <p>4、根据中国海关总署的规定，旅客在境外购买的物品，在进入中国海关时可能需要征收关税。详细内容见《中华人民共和国海关总署公告2010年第54号文件》。</p>

            <p>5、建议出发时行李托运，贵重物品、常用物品、常用药品、御寒衣物等请随身携带，尽量不要托运。行李延误属于不可抗力因素，我司将全力协助客人跟进后续工作，但我司对此不承担任何责任。</p>
            <p>1、旅行社已投保旅行社责任险。建议游客购买旅游意外保险 <br>

            <p>2、旅游者参加打猎、潜水、海边游泳、漂流、滑水、滑雪、滑草、蹦极、跳伞、滑翔、乘热气球、骑马、赛车、攀岩、水疗、水上飞机等属于高风险性游乐项目的，敬请旅游者务必在参加前充分了解项目的安全须知并确保身体状况能适应此类活动；如旅游者不具备较好的身体条件及技能，可能会造成身体伤害。</p>

            <p>3、参加出海活动时，请务必穿着救生设备。参加水上活动应注意自己的身体状况，有心脏病、冠心病、高血压、感冒、发烧和饮酒及餐后不可以参加水上活动及潜水。在海里活动时，严禁触摸海洋中各种鱼类，水母，海胆，珊瑚等海洋生物，避免被其蛰伤。老人和小孩必须有成年人陪同才能参加合适的水上活动。在海边游玩时，注意保管好随身携带的贵重物品。</p>

            <p>4、根据中国海关总署的规定，旅客在境外购买的物品，在进入中国海关时可能需要征收关税。详细内容见《中华人民共和国海关总署公告2010年第54号文件》。</p>

            <p>5、建议出发时行李托运，贵重物品、常用物品、常用药品、御寒衣物等请随身携带，尽量不要托运。行李延误属于不可抗力因素，我司将全力协助客人跟进后续工作，但我司对此不承担任何责任。</p>
        </div>
    </div>
</div>
<!-- 详情 end -->

<!--引入头部-->
<jsp:include page="footer.jsp"></jsp:include>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery-3.3.1.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
<!--导入布局js，共享header和footer-->

<!--收藏-->
<script>
    function addFavorite(rid){
        //发送ajax携带rid数据
        $.post("FavoriteServlet" , "method=addFavorite&rid="+rid ,
            function(resultInfo){
                if(resultInfo.flag){//true 返回是正常
                    if(resultInfo.data){//true 添加数据正常
                        //显示置灰状态
                        $(".collect a").addClass("already");
                        //不可点击
                        $(".collect a").removeAttr("onclick");
                        $(".collect a").prop("disabled",true);//置灰
                        $(".collect span").html("已收藏"+(count+1)+"次");
                    }else{//未登陆
                        //去登陆页面
                        showLoginDialog();
                    }

                }else{//false服务器报错
                    alert(resultInfo.errorMsg);
                }
            } , "json")
    }
</script>


<!--查看是否收藏-->
<script>
    $(function(){
        //1.获得地址栏的数据
        var rid = $("#rid").val();
        var count = parseInt('${route.count}');
        alert(count)
        //2. 发送ajax
        $.post("FavoriteServlet" , {"method":"findFavoriteByRid" , "rid":rid},
            function(resultInfo){//如果返回的数据需要判断 resultInfo
                if(resultInfo.flag){ //表示正常的返回
                    //正常(不报错)响应数据
                    if(resultInfo.data){//true 表示数据库有记录 显示置灰状态 不可点击
                        //显示置灰状态
                        $(".collect a").addClass("already");
                        //不可点击
                        $(".collect a").removeAttr("onclick");
                        $(".collect a").prop("disabled",true);//置灰
                        $(".collect span").html("已收藏"+(count+1)+"次");
                    }
                }else{//表示异常的返回
                    alert("异常情况")
                }
            }
            ,"json")
    })
</script>

<script>
    $(document).ready(function() {
        //焦点图效果
        //点击图片切换图片
        $('.little_img').on('mousemove', function() {
            $('.little_img').removeClass('cur_img');
            var big_pic = $(this).data('bigpic');
            $('.big_img').attr('src', big_pic);
            $(this).addClass('cur_img');
        });
        //上下切换
        var picindex = 0;
        var nextindex = 4;
        $('.down_img').on('click',function(){
            var num = $('.little_img').length;
            if((nextindex + 1) <= num){
                $('.little_img:eq('+picindex+')').hide();
                $('.little_img:eq('+nextindex+')').show();
                picindex = picindex + 1;
                nextindex = nextindex + 1;
            }
        });
        $('.up_img').on('click',function(){
            var num = $('.little_img').length;
            if(picindex > 0){
                $('.little_img:eq('+(nextindex-1)+')').hide();
                $('.little_img:eq('+(picindex-1)+')').show();
                picindex = picindex - 1;
                nextindex = nextindex - 1;
            }
        });
        //自动播放
        // var timer = setInterval("auto_play()", 5000);
    });

    //自动轮播方法
    function auto_play() {
        var cur_index = $('.prosum_left dd').find('a.cur_img').index();
        cur_index = cur_index - 1;
        var num = $('.little_img').length;
        var max_index = 3;
        if ((num - 1) < 3) {
            max_index = num - 1;
        }
        if (cur_index < max_index) {
            var next_index = cur_index + 1;
            var big_pic = $('.little_img:eq(' + next_index + ')').data('bigpic');
            $('.little_img').removeClass('cur_img');
            $('.little_img:eq(' + next_index + ')').addClass('cur_img');
            $('.big_img').attr('src', big_pic);
        } else {
            var big_pic = $('.little_img:eq(0)').data('bigpic');
            $('.little_img').removeClass('cur_img');
            $('.little_img:eq(0)').addClass('cur_img');
            $('.big_img').attr('src', big_pic);
        }
    }
</script>
</body>
</html>
