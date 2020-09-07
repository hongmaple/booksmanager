<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!-- 项目绝对路径-->
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Users列表页面</title>
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
        <strong class="icon-reorder"> 读者信息管理</strong>
    </div>
    <form id="subForm1" method="post" action="BookServlet?type=query1" name="subForm1">

        <div class="form-group">
            <div class="label">
            </div>
            <div class="field">
                用户姓名:
                <input type="text" class="input w50" name="name" id="name"/>


                <button type="submit" class="layui-btn" lay-submit="" >查询</button>
                <%--<input type="button" onclick="serch1()" value="查询" class="button bg-main  "style="background-color: #09F">--%>

                <div class="tips"></div>
            </div>
        </div>


    </form>


    <div class="padding border-bottom">
        <ul class="search">

            <li><a href="usersAdd.jsp" class="button border-big"> 添加用户</a></li>


        </ul>
    </div>
    <table class="layui-table">
        <tbody>
        <tr class="layui-bg-blue">
             <th>ID</th>
             <th>姓名</th>
             <th>密码</th>
             <th>性别</th>
             <th>电话号码</th>
             <th>地址</th>
             <th>类型</th>
            <th>操作</th>
        </tr>


    <c:forEach items="${usersList}" var="v">
        <tr>
            <td>${v.id}</td>
            <td>${v.name}</td>
            <td>${v.password}</td>
            <td>${v.gender}</td>
            <td>${v.phonenumber}</td>
            <td>${v.address}</td>
            <td>${v.type}</td>
            <td>
                <a href="UsersServlet?type=edit&id=${v.id}" class="layui-btn layui-btn layui-btn-sm">修改</a>
                <a href="UsersServlet?type=delete&id=${v.id}" class="layui-btn layui-btn-danger layui-btn-sm">删除</a>
            </td>
        </tr>
    </c:forEach>


        </tbody>
    </table>
</div>


</body>
</html>
