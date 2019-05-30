<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
    <head>
        <title>$Title$</title>
    </head>
    <script src="js/jquery-3.2.1.min.js"></script>

    <script>
        // $(function () {
        //     alert(1213)
        // })
        // $(function () {
        //     alert("骄傲，绝对是，啊的杀手大家")
        // })

        $(function () {
            $("#userName").click(function () {
            alert(1);
            }).change(function () {
                alert(2);

            }).submit(function () {
                alert(3);

            })
        });

        // $(function () {
        //     $("*").css("color","red");
        // });

    </script>
    <body>
        <input type="text" id="userName" class="ad1" value="jack">
    </body>
    <script>
        // var ad1Obj = document.getElementById("userName");
        // alert("js:" + ad1Obj.value);
        // alert("js转jquery：" + $(ad1Obj).val());
        //
        //
        // // var $ad1Obj = jQuery("#userName");
        // var $ad1Obj = $("#userName");
        // alert("jquery:" + $ad1Obj.val())
        // alert("jquery转js：" + $ad1Obj[0].value);

    </script>
</html>
