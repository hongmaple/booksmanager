<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!-- 项目绝对路径-->
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>消息中心</title>
    <!-- 引入css样式和js文件-->
    <meta charset="UTF-8">
    <link rel="stylesheet" href="static/layui/css/layui.css"/>
    <link rel="stylesheet" href="static/css/pintuer.css">
    <link rel="stylesheet" href="static/css/admin.css">
    <link rel="stylesheet" href="static/layui/css/modules/layer/default/layer.css" media="all"/>

    <style>
        body .demo-class .layui-layer-title{background:#c00; color:#fff; border: none;}
        body .demo-class .layui-layer-btn{border-top:1px solid #E9E7E7}
        body .demo-class .layui-layer-btn a{background:#333;}
        body .demo-class .layui-layer-btn .layui-layer-btn1{background:#999;}
    </style>
</head>
<body>
<div class="layui-container">
    <div class="panel-head">
        <strong class="icon-reorder"> 消息列表</strong>
    </div>

    <form id="subForm1" method="post" action="/UsersMessageSevlet?type=search" name="subForm1">

        <div class="form-group">
            <div class="label">

            </div>
            <div class="field">
                消息标题
                <input type="text" class="input w50" name="title" id="title"/>

                <button type="submit" class="layui-btn" lay-submit="" >查询</button>

                <div class="tips"></div>
            </div>
        </div>


    </form>

    <table class="layui-table">
        <tbody>
        <tr class="layui-bg-blue">
            <th>ID</th>
            <th>标题</th>
            <th>消息内容</th>
            <th>操作</th>
        </tr>


        <c:forEach items="${sysMsgs}" var="v">
            <tr>
                <td>${v.id}</td>
                <td>${v.title}</td>
                <td>${v.content}</td>
                <td>
                    <a href="javascript:" onclick="chakan('${v.content}')" class="layui-btn layui-btn-danger layui-btn-sm">查看内容</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <c:if test="${msg!=null}">
        <script>
            layer.msg(${msg});
        </script>
    </c:if>
</div>
<script src="static/layui/layui.js"></script>
<script src="static/layui/lay/modules/layer.js"></script>
<script type="text/javascript">
    function chakan(content) {
        layer.open({
            type: 1,
            title:"详情",
            content: content,
            area: ['40%', '30%'],
            skin: 'demo-class',
            offset: 'auto',
            anim: 1
        });
    }
</script>
</body>
</html>
