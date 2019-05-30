<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
    <head>
        <!-- 指定字符集 -->
        <meta charset="utf-8">
        <!-- 使用Edge最新的浏览器的渲染方式 -->
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
        width: 默认宽度与设备的宽度相同
        initial-scale: 初始的缩放比，为1:1 -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
        <title>Bootstrap模板</title>

        <!-- 1. 导入CSS的全局样式 -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
        <script src="js/jquery-2.1.0.min.js"></script>
        <!-- 3. 导入bootstrap的js文件 -->
        <script src="js/bootstrap.min.js"></script>
        <script>
            function checkAll() {
                var ckbox = document.getElementById("ckbox");
                var cids = document.getElementsByName("cid");
                for (var i = 0; i < cids.length; i++) {
                    cids[i].checked = ckbox.checked;
                }
            }

            function delecteChecked() {
                if (confirm("您确定要删除吗？")) {
                    document.getElementById("formId").submit();
                }
            }
        </script>
        <style type="text/css">
            td, th {
                text-align: center;
            }
        </style>
    </head>
    <body>
        <div class="container-fluid">
            <h3 style="text-align: center">显示所有联系人</h3>

            <table border="1" class="table table-bordered table-hover">
                <tr class="success">
                    <td colspan="9">
                        <form action="${pageContext.request.contextPath}/queryByConditions?curPage=${curPage}"
                              method="post">
                            <label for="uName">姓名：</label><input type="text" value="${name}" name="uName" id="uName">&nbsp;&nbsp;
                            <label for="qq">QQ：</label><input type="text" value="${qq}" name="qq" id="qq">
                            <input type="submit" value="查询" class="btn-success">
                        </form>
                    </td>
                </tr>
                <tr class="success">
                    <th><input type="checkbox" id="ckbox" onclick="checkAll()"></th>
                    <th>编号</th>
                    <th>姓名</th>
                    <th>性别</th>
                    <th>年龄</th>
                    <th>籍贯</th>
                    <th>QQ</th>
                    <th>邮箱</th>
                    <th>操作</th>
                </tr>

                <c:if test="${empty list}" var="flag" scope="request">
                    ${"您查询的结果为空"}
                </c:if>

                <c:if test="${!flag}">
                    <form id="formId" action="${pageContext.request.contextPath}/deleteChecked?curPage=${curPage}"
                          method="post">
                        <c:forEach items="${list}" var="contact">
                            <tr>
                                <td><input type="checkbox" name="cid" value="${contact.id}"></td>
                                <td>${contact.id}</td>
                                <td>${contact.name}</td>
                                <td>${contact.sex}</td>
                                <td>${contact.age}</td>
                                <td>${contact.address}</td>
                                <td>${contact.qq}</td>
                                <td>${contact.email}</td>
                                <td><a class="btn btn-default btn-sm"
                                       href="${pageContext.request.contextPath}/findById?id=${contact.id}&curPage=${curPage}">修改</a>&nbsp;
                                    <a class="btn btn-default btn-sm"
                                       href="${pageContext.request.contextPath}/deleteById?id=${contact.id}&curPage=${curPage}&uName=${name}&qq=${qq}">删除</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </form>
                </c:if>
                <tr>
                    <td colspan="9" align="center">
                        <a class="btn btn-primary" href="add.jsp?curPage=${curPage}">添加联系人</a>
                        <a class="btn btn-primary" href="javascript:void(0);<%--当前超链接失效 --%>"
                           onclick="delecteChecked()">删除选中</a>
                    </td>
                </tr>
            </table>

            <nav class="text-center">
                <ul class="pagination">
                    <c:if test="${curPage>1}">
                        <li>
                            <a href="<%=request.getContextPath()%>/queryByPage?curPage=${curPage-1}">
                                <span>&laquo;</span>
                            </a>
                        </li>
                    </c:if>
                    <c:if test="${curPage==1}">
                        <li class="disabled">
                            <a href="javascript:void(0);">&laquo;</a>
                        </li>
                    </c:if>
                    <c:forEach begin="${start}" end="${end}" step="1" var="i">
                        <c:if test="${curPage==i}">
                            <li class="active">
                                <a href="<%=request.getContextPath()%>/queryByPage?curPage=${i}">${i}</a>
                            </li>
                        </c:if>
                        <c:if test="${curPage!=i}">
                            <li>
                                <a href="<%=request.getContextPath()%>/queryByPage?curPage=${i}">${i}</a>
                            </li>
                        </c:if>
                    </c:forEach>
                    <c:if test="${curPage<totalPage}">
                        <li>
                            <a href="<%=request.getContextPath()%>/queryByPage?curPage=${curPage+1}">
                                <span>&raquo;</span>
                            </a>
                        </li>
                    </c:if>

                    <c:if test="${curPage==totalPage}">
                        <li class="disabled">
                            <a href="javascript:void(0);">
                                <span>&raquo;</span>
                            </a>
                        </li>
                    </c:if>
                </ul>
            </nav>

        </div>
    </body>
</html>
