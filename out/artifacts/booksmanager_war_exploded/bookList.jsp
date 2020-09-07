<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!-- 项目绝对路径-->
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Book列表页面</title>
    <!-- 引入css样式和js文件-->
    <meta charset="UTF-8">
    <link rel="stylesheet" href="static/layui/css/layui.css"/>
    <link rel="stylesheet" href="static/css/pintuer.css">
    <link rel="stylesheet" href="static/css/admin.css">
    <script type="text/javascript" src="static/layui/layui.js"></script>
</head>
<body>
<div class="layui-container">
    <div class="panel-head">
        <strong class="icon-reorder"> 图书信息管理</strong>
    </div>
    <form id="subForm1" method="post" action="BookServlet?type=query2" name="subForm1">

        <div class="form-group">
            <div class="label">

            </div>
            <div class="field">
                图书名称:
                <input type="text" class="input w50" name="bookname" id="name"/>
                作者:
                <input type="text" class="input w50" name="author" id="code"/>

                <button type="submit" class="layui-btn" lay-submit="" >查询</button>
                <%--<input type="button" onclick="serch1()" value="查询" class="button bg-main  "style="background-color: #09F">--%>

                <div class="tips"></div>
            </div>
        </div>


    </form>

<c:if test="${loginAdmin.type==1}">
    <div class="padding border-bottom">
        <ul class="search">

            <li><a href="bookAdd.jsp" class="button border-big"> 添加图书</a></li>


        </ul>
    </div>
</c:if>
    <table class="layui-table">
        <tbody>
        <tr class="layui-bg-blue">
             <th>ID</th>
             <th>isbn</th>
             <th>书名</th>
             <th>作者</th>
             <th>出版社</th>
             <th>类型</th>
             <th>价格</th>
             <th>备注</th>
<c:if test="${loginAdmin.type==1}">
            <th>操作</th>
</c:if>
        </tr>


    <c:forEach items="${bookList}" var="v">
        <tr>
            <td>${v.id}</td>
            <td>${v.isbn}</td>
            <td>${v.bookname}</td>
            <td>${v.author}</td>
            <td>${v.press}</td>
            <td>${v.type}</td>
            <td>${v.money}</td>
            <td>${v.remark}</td>
            <c:if test="${loginAdmin.type==1}">
            <td>

                <a href="BookServlet?type=edit&id=${v.id}" class="layui-btn layui-btn layui-btn-sm">修改</a>
                <a href="BookServlet?type=delete&id=${v.id}" class="layui-btn layui-btn-danger layui-btn-sm">删除</a>


            </td>
            </c:if>
        </tr>
    </c:forEach>


        </tbody>
    </table>
</div>


</body>
</html>
