<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!-- 项目绝对路径-->
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Users添加页面</title>
    <!-- 引入css样式和js文件-->
    <meta charset="UTF-8">
    <link rel="stylesheet" href="static/layui/css/layui.css"/>
    <script type="text/javascript" src="static/layui/layui.js"></script>
</head>
<body>
<div class="layui-container">

    <form class="layui-form" action="UsersServlet?type=save" method="post" style="width: 500px;margin: 50px auto;">
        <div class="layui-form-item">
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-block">
                <input type="text" name="name" id="name" value="" lay-verify autocomplete="off"
                       placeholder="请输入姓名"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">密码</label>
            <div class="layui-input-block">
                <input type="text" name="password" id="password" value="" lay-verify autocomplete="off"
                       placeholder="请输入密码"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">性别</label>
            <div class="layui-input-block">
                <input type="text" name="gender" id="gender" value="" lay-verify autocomplete="off"
                       placeholder="请输入性别"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">电话号码</label>
            <div class="layui-input-block">
                <input type="text" name="phonenumber" id="phonenumber" value="" lay-verify autocomplete="off"
                       placeholder="请输入电话号码"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">地址</label>
            <div class="layui-input-block">
                <input type="text" name="address" id="address" value="" lay-verify autocomplete="off"
                       placeholder="请输入地址"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">类型</label>
            <div class="layui-input-block">
                <input type="text" name="type1" id="type1" value="" lay-verify autocomplete="off"
                       placeholder="请输入类型"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>

</div>


</body>
</html>
