<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/commonattributes.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<meta http-equiv="Pragma" content="no-cache"> 
<meta http-equiv="Cache-Control" content="no-cache"> 
<meta http-equiv="Expires" content="0"> 
<title>后台登录</title>
<link href="${ctx}/css/login.css" type="text/css" rel="stylesheet">
</head> 
<body> 

<div class="login">
    <div class="message">登录界面</div>
    <div id="darkbannerwrap"></div>
    
    <form method="post" action="${ctx}/login">
		<input name="username" placeholder="用户名" required="" type="text">
		<hr class="hr15">
		<input name="password" placeholder="密码" required="" type="password">
		<hr class="hr15">
		<div><input name="code" placeholder="验证码" required="" type="text"><img class="imgcode" alt="验证码" onclick = "this.src='defaultKaptcha?d='+new Date()*1" src="defaultKaptcha" /></div>
		<hr class="hr15">
		<input value="登录" style="width:100%;" type="submit">
		<hr class="hr20">
		<p style="color: red;float: right;font-size: 15px">${(SPRING_SECURITY_LAST_EXCEPTION.message)}</p>
		<!-- 帮助 <a onClick="alert('请联系管理员')">忘记密码</a> -->
	</form>

	
</div>


</body>
</html>