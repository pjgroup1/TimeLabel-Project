<!-- 로그아웃 처리 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	// 세션초기화
	session.invalidate();
	// "로그아웃됨"
%>
	<script>
		alert("로그아웃 되었습니다.");
		location.href = "http://localhost:8282/TimeLabel/UserMain";
	</script>
</body>
</html>