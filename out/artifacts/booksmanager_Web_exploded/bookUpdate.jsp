<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!-- 项目绝对路径-->
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Book修改页面</title>
    <!-- 引入css样式和js文件-->
    <meta charset="UTF-8">
    <link rel="stylesheet" href="static/layui/css/layui.css"/>
    <script type="text/javascript" src="static/layui/layui.js"></script>
</head>
<body>
<div class="layui-container">

    <form class="layui-form" action="BookServlet?type=update" method="post" style="width: 500px;margin: 50px auto;">
        <input type="hidden" name="id" value="${book.id}"/>
        <div class="layui-form-item">
            <label class="layui-form-label">isbn</label>
            <div class="layui-input-block">
                <input type="text" name="isbn" id="isbn" value="${book.isbn}" lay-verify autocomplete="off"
                       placeholder="请输入isbn"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">书名</label>
            <div class="layui-input-block">
                <input type="text" name="bookname" id="bookname" value="${book.bookname}" lay-verify autocomplete="off"
                       placeholder="请输入书名"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">作者</label>
            <div class="layui-input-block">
                <input type="text" name="author" id="author" value="${book.author}" lay-verify autocomplete="off"
                       placeholder="请输入作者"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">出版社</label>
            <div class="layui-input-block">
                <input type="text" name="press" id="press" value="${book.press}" lay-verify autocomplete="off"
                       placeholder="请输入出版社"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">类型</label>
            <div class="layui-input-block">
                <input type="text" name="type" id="type" value="${book.type}" lay-verify autocomplete="off"
                       placeholder="请输入类型"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">价格</label>
            <div class="layui-input-block">
                <input type="text" name="money" id="money" value="${book.money}" lay-verify autocomplete="off"
                       placeholder="请输入价格"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">备注</label>
            <div class="layui-input-block">
                <input type="text" name="remark" id="remark" value="${book.remark}" lay-verify autocomplete="off"
                       placeholder="请输入备注"
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
