<%--
  Created by IntelliJ IDEA.
  User: yangle
  Date: 2017/10/12
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="login" method="post">
    <input type="text" value="" name="username">
    <input type="text" value="" name="password">
    <input type="text" name="code">
    <img alt="验证码" onclick = "this.src='defaultKaptcha?d='+new Date()*1" src="defaultKaptcha" />

    <input type="submit" value="登录">

</form>
${(SPRING_SECURITY_LAST_EXCEPTION.message)}
</body>
</html>
