<%@ page contentType="text/html; charset=gb2312"%>

<html>

<body>
<h2>Hello World!</h2>

<form action="${pageContext.request.contextPath}/test" method="get">
    �û���:<input type="text" name="username"> <br>
    ����:<input type="password" name="password"> <br>
    <input type="submit">
</form>
</body>
</html>
