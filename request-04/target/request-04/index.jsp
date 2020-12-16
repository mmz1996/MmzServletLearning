<%--
  Created by IntelliJ IDEA.
  User: mmz
  Date: 2020/12/16
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>

<h1>登录</h1>

<div style="text-align: center">
    <%--以post方式提交表单，提交我们的login请求--%>
    <form action="${pageContext.request.contextPath}/login" method="post">
        用户名:<input type="text" name="username"> <br>
        密码:<input type="password" name="password"> <br>
        爱好:
        <input type="checkbox" name="hobby" value="1">1
        <input type="checkbox" name="hobby" value="2">2
        <input type="checkbox" name="hobby" value="3">3
        <input type="checkbox" name="hobby" value="4">4
        <br>
        <input type="submit">提交
    </form>

</div>


</body>
</html>
