<%@ page isErrorPage="true" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>404 patch</title>
<script>
	window.onload = function() {
		alert("페이지가 존재하지 않습니다.\n홈페이지로 이동하겠습니다.");
		setTimeout(() =>location.href = "/", 100);
	} //
</script>
<%
response.setStatus(HttpServletResponse.SC_OK);
%>
</head>
<body>
</body>
</html>