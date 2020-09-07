<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!-- 项目绝对路径-->
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>History列表页面</title>
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
        <strong class="icon-reorder"> 图书借阅记录</strong>
    </div>

    <form id="subForm1" method="post" action="HistoryServlet?type=query1" name="subForm1">

        <div class="form-group">
            <div class="label">

            </div>
            <div class="field">
                <%--<c:if test="${loginAdmin.type==0}">
                    <input name="username" hidden value="${loginAdmin.name}">
                </c:if>--%>
                图书名称:
                <input type="text" class="input w50" name="bookname" id="name"/>
                用户名称:
                <input type="text" class="input w50" name="username" id="code"/>

                <button type="submit" class="layui-btn" lay-submit="" >查询</button>
                <%--<input type="button" onclick="serch1()" value="查询" class="button bg-main  "style="background-color: #09F">--%>

                <div class="tips"></div>
            </div>
        </div>

    </form>


    <c:if test="${loginAdmin.type==0}">
        <div class="padding border-bottom">
            <ul class="search">
                <li><a href="BookServlet?type=query1" class="button border-big"> 借书</a></li>
            </ul>
        </div>
        </c:if>
        <table class="layui-table">
            <tbody>
            <tr class="layui-bg-blue">
                 <th>ID</th>
                 <th>借书人</th>
                 <th>书名</th>
                 <th>借书时间</th>
                 <th>归还时间</th>
                 <th>实际归还时间</th>
                <%--<th>状态</th>--%>
            <th>操作</th>
        </tr>


    <c:forEach items="${historyList}" var="v">
        <tr>
            <td>${v.id}</td>
            <td>${v.username}</td>
            <td>${v.bookname}</td>
            <td>${v.lendtime}</td>
            <td>${v.backtime}</td>
            <td>${v.remark}</td>
                <%--<td>${v.status}</td>--%>
            <td>
<%--                <a href="HistoryServlet?type=edit&id=${v.id}" class="layui-btn layui-btn layui-btn-sm">修改</a>--%>
<%--                <a href="HistoryServlet?type=delete&id=${v.id}" class="layui-btn layui-btn-danger layui-btn-sm">删除</a>--%>

    <c:if test="${v.status==1 &&loginAdmin.type==0}">
                <a href="HistoryServlet?type=update1&id=${v.id}" class="layui-btn  layui-btn-sm">还书</a>
                </c:if>

    <c:if test="${v.status==1 && loginAdmin.type==1}">
        <a href="#" class="layui-btn layui-btn-danger layui-btn-sm">未还</a>
    </c:if>
                <c:if test="${v.status==0}">
                    <a href="#" class="layui-btn layui-btn-disabled layui-btn-sm">已还</a>
                </c:if>
            </td>
        </tr>
    </c:forEach>


        </tbody>
    </table>
</div>


</body>
</html>
