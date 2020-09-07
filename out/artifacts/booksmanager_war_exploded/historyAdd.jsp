<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!-- 项目绝对路径-->
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>History添加页面</title>
    <!-- 引入css样式和js文件-->
    <meta charset="UTF-8">
    <link rel="stylesheet" href="static/layui/css/layui.css"/>
    <link rel="stylesheet" href="static/css/pintuer.css">
    <link rel="stylesheet" href="static/css/admin.css">
    <script type="text/javascript" src="static/layui/layui.js"></script>
</head>
<body>
<div class="layui-container">

    <form class="layui-form" action="HistoryServlet?type=save" method="post" style="width: 500px;margin: 50px auto;">
        <div class="layui-form-item" hidden>
            <label class="layui-form-label">借书人</label>
            <div class="layui-input-block">
                <input type="text" name="username" id="username" value="${loginAdmin.name}" lay-verify autocomplete="off"
                       placeholder="请输入借书人"
                       class="layui-input">
            </div>
        </div>



        <div class="layui-form-item">
            <label class="layui-form-label">图书名称</label>
            <div class="layui-input-block">
                <select name="bookname" lay-filter="bookname">
                    <option value=""></option>
                    <c:forEach var="book" items="${bookList}">
                        <option value="${book.bookname}">${book.bookname}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <%--<div class="layui-form-item">
            <label class="layui-form-label">书名</label>
            <div class="layui-input-block">
                <input type="text" name="bookname" id="bookname" value="" lay-verify autocomplete="off"
                       placeholder="请输入书名"
                       class="layui-input">
            </div>
        </div>--%>
        <div class="layui-form-item">
            <label class="layui-form-label">借书时间</label>
            <div class="layui-input-block">
                <input type="date" name="lendtime" id="lendtime" value="" lay-verify autocomplete="off"
                       placeholder="请输入借书时间"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">归还时间</label>
            <div class="layui-input-block">
                <input type="date" name="backtime" id="backtime" value="" lay-verify autocomplete="off"
                       placeholder="请输入归还时间"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item" hidden>
            <label class="layui-form-label">备注</label>
            <div class="layui-input-block">
                <input type="text" name="remark" id="remark" value="" lay-verify autocomplete="off"
                       placeholder="请输入备注"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item" hidden>
            <label class="layui-form-label">状态</label>
            <div class="layui-input-block">
                <input type="text" name="status" id="status" value="1" lay-verify autocomplete="off"
                       placeholder="请输入状态"
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

<script>
    layui.use(['form', 'layedit', 'laydate'], function(){
        var form = layui.form
            ,layer = layui.layer
            ,layedit = layui.layedit
            ,laydate = layui.laydate;
    });
</script>
</body>
</html>
