<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*"%>
<html>
<head>
<title>중복확인창</title>

</head>

	<%
	String userId = request.getParameter("userId");
	%>
	<body>
	<script>
		function useID() {
			window.opener.document.userInfo.ID.value = "<%=userId%>";
			window.opener.document.userInfo.ID.readOnly=true;
			window.opener.document.userInfo.idDuplication.value = "checked";
			window.close();
		}

		function retry() {
			location.href = "/idCheck";
		}
	</script>
	<%
	if (userId == "") {
	%>
	<span>아이디를 입력하세요</span>
	<input type="button" value="다시 시도" onclick="retry();">
	<%
	} else {
	try {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Class.forName("org.mariadb.jdbc.Driver");
		String DB_URL = "jdbc:mariadb://javalec-sat.crwq4oaekhum.ap-northeast-2.rds.amazonaws.com:3306/sang_db";
		String userName = "sang";
		String password = "sang1234";

		con = DriverManager.getConnection(DB_URL, userName, password);

		// 로그인 화면에 입력된 아이디와 비밀번호를 가져온다

		//id에 해당하는 passwd 가져오기
		String sql = "SELECT USER_NO FROM USER WHERE USER_ID=?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, userId);
	%>

	<%
	//실행  rs에 저장
	rs = pstmt.executeQuery();
	if (rs.next()) {
	%>
	<span style="color: red">"<%=userId%>"는 이미 사용 중입니다.
	</span>
	<input type="button" value="다시 시도" onclick="retry();">
	<%
	} else {
	%>
	<span style="color: blue">"<%=userId%>"는 사용 가능합니다.
	</span>
	<br>
	<input type="button" value="다시 시도" onclick="retry();">
	<input type="button" value="아이디 사용하기" onclick="useID();">

	<%
	pstmt.close();
	con.close();
	}

	} catch (ClassNotFoundException e) {
	out.println(e);
	} catch (SQLException e) {
	out.println(e);
	}
	}
	%>

</body>
</html>