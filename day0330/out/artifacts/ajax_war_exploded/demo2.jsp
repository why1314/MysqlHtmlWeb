<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert title here</title>
        <style type="text/css">
            .content {
                width: 643px;
                margin: 200px auto;
                text-align: center;
            }

            input[type='text'] {
                width: 530px;
                height: 40px;
                font-size: 14px;
            }

            input[type='button'] {
                width: 100px;
                height: 46px;
                background: #38f;
                border: 0;
                color: #fff;
                font-size: 15px
            }

            .show {
                width: 535px;
                border: 1px solid #999;
                border-top: 0;
                display: none;
            }
        </style>
        <script type="text/javascript" src="js/jquery-3.3.1.js"></script>
        <script type="text/javascript">
            $(function () {
                $("input[name='word']").keyup(function () {

                    var keyWords = $(this).val();
                    if (keyWords != null && keyWords.length > 0) {
                        var params = {"keyWords": keyWords};
                        var url = "demo2";

                        // function fun(data) {
                        //     // alert(data)
                        //     $(".show").empty();
                        //     if (data != null && data.length > 0) {
                        //         for (var i = 0; i < data.length; i++) {
                        //             $(".show").append("<div style='cursor: pointer' onclick='checkThis(this)'>" + data[i] + "</div>");
                        //         }
                        //         $(".show").show();
                        //     } else {
                        //         $(".show").hide();
                        //     }
                        //
                        //
                        // }

                        // $.post(url, params, fun, "json");

                        $.ajax({
                            url: url,
                            type: "post",
                            data: params,
                            success: function (data) {
                                // alert(data)
                                $(".show").empty();
                                if (data != null && data.length > 0) {
                                    for (var i = 0; i < data.length; i++) {
                                        $(".show").append("<div style='cursor: pointer' onclick='checkThis(this)'>" + data[i] + "</div>");
                                    }
                                    $(".show").show();
                                } else {
                                    $(".show").hide();
                                }


                            },
                            dataType: "json",
                            async: true
                        })
                    }

                })
            });

            function checkThis(obj) {
                var word = $(obj).text();
                $("input[name='word']").val(word);
            }
        </script>
    </head>
    <body>
        <div class="content">
            <img alt="" src="img/logo.png"><br/><br/>
            <input type="text" name="word">
            <input type="button" value="搜索一下">
            <div class="show"></div>
        </div>
    </body>
</html>