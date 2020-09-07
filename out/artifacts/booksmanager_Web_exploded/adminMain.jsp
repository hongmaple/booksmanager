<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-cn">
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <meta name="renderer" content="webkit">
    <title>图书管理系统</title>

    <link rel="stylesheet" href="static/css/pintuer.css">
    <link rel="stylesheet" href="static/css/admin.css">
    <script src="static/js/jquery.js"></script>
    <script src="static/layui/layui.js"></script>
    <link rel="stylesheet" href="static/layui/css/layui.css" media="all">
    <link id="layuicss-layer" rel="stylesheet" href="https://res.layui.com/layui/rc/css/modules/layer/default/layer.css?v=3.1.1" media="all">
</head>
<body style="background-color: #fdf9f9;">

<ul class="layui-nav">

    <div class="logo margin-big-left fadein-top">
        <h1>
            图书管理系统
        </h1>
    </div>

    <li class="layui-nav-item"><a href="#">首页</a></li>
    <li class="layui-nav-item" lay-unselect="" style="float: right">
        <a href="#"><img src="static/img/user.jpg" class="layui-nav-img">欢迎您，${loginAdmin.name}</a>
        <dl class="layui-nav-child">
<c:if test="${loginAdmin.type==1}">
            <dd><a href="/UsersServlet?type=get&id=${loginAdmin.id}" target="myiframe">修改信息</a></dd>
</c:if>

            <dd><a href="/LoginOutServlet">注销用户</a></dd>
        </dl>
    </li>
</ul>


<div class="leftnav">

    <h2>
        <span class="icon-adjust"></span>图书管理菜单
    </h2>
    <ul style="display: block">
        <%--<c:if test="${type==0}">
            <a class="nav-link" href="<%=basePath%>/kskm">在线考试</a>
            <a class="nav-link" href="<%=basePath%>/grade">成绩查询</a>
        </c:if>
        <c:if test="${type==1}">
            <a class="nav-link" href="<%=basePath%>/PaperContentServlet?type=query">题目管理</a>
            <a class="nav-link" href="<%=basePath%>/grade1">成绩管理</a>
        </c:if>--%>
        <%--            <li class="layui-nav-item"><a href="UserinfoServlet?type=query&id=1" target="myiframe">会员管理</a></li>--%>
        <c:if test="${loginAdmin.type==1}">
            <li class="layui-nav-item"><a href="/BookServlet?type=query" target="myiframe"><span
                    class="icon-caret-right"></span>图书信息管理</a></li>
            <li><a href="/UsersServlet?type=query" target="myiframe"><span
                    class="icon-caret-right"></span>读者信息管理</a></li>
            <li><a href="/HistoryServlet?type=query" target="myiframe"><span
                    class="icon-caret-right"></span>图书借阅管理</a></li>
            <%--<li><a href="#" target="myiframe"><span
                    class="icon-caret-right" target="myiframe"></span>用户管理</a></li>--%>
            <li><a href="/HistoryServlet?type=query2" target="myiframe"><span
                class="icon-caret-right"></span>用户逾期管理</a></li>
            <li><a href="/MessageCenterSevlet?type=search" target="myiframe"><span
                class="icon-caret-right"></span>消息中心</a></li>
        </c:if>

        <c:if test="${loginAdmin.type==0}">
        <li class="layui-nav-item"><a href="/UsersServlet?type=get&id=${loginAdmin.id}" target="myiframe1"><span
                class="icon-caret-right"></span>个人信息管理</a></li>
        <li class="layui-nav-item"><a href="/BookServlet?type=query" target="myiframe1"><span
                class="icon-caret-right"></span>图书查询</a></li>
        <li class="layui-nav-item"><a href="/HistoryServlet?type=get1&name=${loginAdmin.name}" target="myiframe1"><span
                class="icon-caret-right"></span>图书借还</a></li>
        <li class="layui-nav-item"><a href="/HistoryServlet?type=query3&name=${loginAdmin.name}" target="myiframe1"><span
                class="icon-caret-right"></span>逾期查询</a></li>
        <li><a href="/UsersMessageSevlet?type=search&userId=${loginAdmin.id}" target="myiframe1"><span
                class="icon-caret-right"></span>消息中心</a></li>
    </ul>
    </c:if>
</div>
<script src="layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    layui.use('element', function () {
        var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块

        //监听导航点击
        element.on('nav(demo)', function (elem) {
            //console.log(elem)
            layer.msg(elem.text());
        });
    });
</script>

<script type="text/javascript">
    $(function () {
        $(".leftnav h2").click(function () {
            $(this).next().slideToggle(200);
            $(this).toggleClass("on");
        })
        $(".leftnav ul li a").click(function () {
            $("#a_leader_txt").text($(this).text());
            $(".leftnav ul li a").removeClass("on");
            $(this).addClass("on");
        })
    });
    //注意：折叠面板 依赖 element 模块，否则无法进行功能性操作
    layui.use('element', function(){
        var element = layui.element;

        //…
    });
</script>

<div class="admin" style="left: 180px">
    <c:if test="${loginAdmin.type==1}">
        <iframe scrolling="auto" rameborder="0" src="BookServlet?type=query"
                name="myiframe" width="100%" height="100%">
        </iframe>
    </c:if>
    <c:if test="${loginAdmin.type==0}">
        <iframe scrolling="auto" rameborder="0" src="BookServlet?type=query"
                name="myiframe1" width="100%" height="100%">


        </iframe>
    </c:if>
    <%-- <iframe scrolling="auto" rameborder="0" src="UserinfoServlet?type=query&id=${loginAdmin.id}"
             name="myiframe" width="100%" height="100%" id =“myiframe”></iframe>--%>
</div>
</body>
</html>


