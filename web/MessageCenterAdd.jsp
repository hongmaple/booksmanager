<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!-- 项目绝对路径-->
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>消息中心添加页面</title>
    <!-- 引入css样式和js文件-->
    <meta charset="UTF-8">
    <link rel="stylesheet" href="static/layui/css/layui.css"/>
    <link rel="stylesheet" href="static/layui/css/modules/layer/default/layer.css" media="all"/>
    <script src="static/layui/layui.js"></script>
</head>
<body>
<div class="layui-container">

    <form class="layui-form" action="MessageCenterSevlet?type=save" method="post" style="width: 500px;margin: 50px auto;">
        <div class="layui-form-item">
            <label class="layui-form-label">标题</label>
            <div class="layui-input-block">
                <input type="text" name="title" id="title" value="" lay-verify autocomplete="off"
                       placeholder="请输入标题"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">消息内容</label>
            <div class="layui-input-block">
                <input type="text" name="content" id="content" value="" lay-verify autocomplete="off"
                       placeholder="请输入消息内容"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">有效期</label>
            <div class="layui-input-block">
                <input type="text" lay-verify autocomplete="off" name="indateTime" class="layui-input" id="test1">
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
<c:if test="${msg!=null}">
    <script>
        layer.msg(${msg});
    </script>
</c:if>
<script>
    function submit(){
        $.post("/MessageCenterSevlet?type=save",
            $('layui-form').serialize(),
            function(data,status){
                layer.confirm(data.msg, {
                    btn: ['关闭', '确认'] //可以无限个按钮
                }, function(index, layero){
                    //按钮【按钮一】的回调
                }, function(index){
                    //按钮【按钮二】的回调
                });
            });
    }
    layui.use('laydate', function(){
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#test1' //指定元素
        });
    });
</script>

</body>
</html>
