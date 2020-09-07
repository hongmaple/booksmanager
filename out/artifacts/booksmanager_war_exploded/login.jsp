<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>管理员登录</title>
<link rel="stylesheet" href="static/css/pintuer.css">
<link rel="stylesheet" href="static/css/admin.css">
<script src="static/js/jquery.js"></script>
<script src="static/js/pintuer.js"></script>
</head>
<body>
	<div class=" bg bg-yellow-light" style="background: url('static/img/bg2.jpg'); background-size: 100% 100%;">
		<div class="container">
			
		</div>
	</div>
	<div class="container">
		<div class="line bouncein">
			<div class="xs6 xm4 xs3-move xm4-move">
				<div style="height: 150px;"></div>
				<div class="media media-y margin-big-bottom"></div>
				<a href="#"><div style="padding: 0px;">
						<input type="submit"
							class="button button-block bg-main text-big input-big"
							value="欢迎使用图书管理系统">
					</div></a>
				<form id="form1" action="login" method="post">
					<div class="panel loginbox">

						<div class="panel-body"
							style="padding: 30px; padding-bottom: 10px; padding-top: 10px;">
							<div class="form-group">
								<div class="field field-icon-right">
									<input type="text" class="input input-big" name="name"
										placeholder="请输账号" data-validate="required:请填写账号" /> <span
										class="icon icon-user margin-small"></span>
								</div>
							</div>
							<div class="form-group">
								<div class="field field-icon-right">
									<input type="password" class="input input-big" name="password"
										placeholder="登录密码" data-validate="required:请填写密码" /> <span
										class="icon icon-key margin-small"></span>
								</div>
							</div>
						</div>
						<div style="padding: 30px;">
							<input type="button" id="login"
								class="button button-block bg-main text-big input-big"
								value="登录">
							<br>
							<%--<button type="button"
									class="button button-block bg-main text-big input-big"
							><a href="register.jsp">注册</a></button>--%>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<c:if test="${msg!=null}">
		<script>
			alert("${msg}");
		</script>
	</c:if>
<script>
    $("#login").click(function(){
        $.post("/login",
            $('#form1').serialize(),
            function(data,status){
                alert("Data: " + data + "\nStatus: " + status);
            });
    });
</script>
</body>

</html>

