<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>중복확인창</title>
</head>
<body>
	<form action="/idCheckPro" name="checking" method="get">
		<input type="text" name="userId" placeholder="중복 체크할 ID를 입력하세요">
		<input type="submit" value="중복 체크">
	</form>
	<script>
	document.checking.userId.value = window.opener.document.userInfo.ID.value;
	</script>
</body>
</html>