<%--
  Created by IntelliJ IDEA.
  User: 88042
  Date: 2019/1/9
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
${requestScope.errMsg}
<form id="form1" method="post" action="/login">
    用户名：<input type="text" id="username" name="username"/>
    <br />
    密码：<input type="text" id="password" name="password"/>
    <br />
    <input type="submit" value="登录" />
</form>
</body>
</html>
