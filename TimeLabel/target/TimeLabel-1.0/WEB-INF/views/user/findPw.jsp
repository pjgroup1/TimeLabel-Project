<%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2022-11-29
  Time: 오후 5:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/user/findPw" method="post">
    아이디 : <input type="text" name="userId">
    이메일 : <input type="text" name="userEmail">
    <button type="submit">전송</button>
</form>

</body>
</html>
