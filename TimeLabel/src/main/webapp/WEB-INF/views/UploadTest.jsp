<!-- 업로드테스트 페이지 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*,java.io.*"%>
<%@ page import="com.oreilly.servlet.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>업로드화면</title>
</head>
<body>
	<%
	//BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
	//String read = "";
	//while ((read = br.readLine()) != null) {
	//	out.print(read + "<br>");
	//}
	//br.close();
	String savePath = "C:/Users/TJ/Documents/GitHub/TimeLabel-Project/TimeLabel/src/main/webapp/resources/img";
	MultipartRequest multi = new MultipartRequest(request, savePath, 1000000, "utf-8");
	//out.println(multi.getFilesystemName((String) multi.getFileNames().nextElement()));

	try {
		Class.forName("org.mariadb.jdbc.Driver"); // HeidiSQL jdbc 연결
		String URL = "jdbc:mariadb://javalec-sat.crwq4oaekhum.ap-northeast-2.rds.amazonaws.com:3306/sang_db";
		String userName = "sang";
		String password = "sang1234";

		Connection con = DriverManager.getConnection(URL, userName, password);
		String sql = "INSERT INTO upload_test(image_name) VALUES (?)"; // sql문 작성(입력받은 값들을 보내기 위한 작업)

		PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.setString(1, multi.getFilesystemName((String) multi.getFileNames().nextElement()));
		pstmt.executeUpdate();

		pstmt.close();
		con.close();
	} catch (ClassNotFoundException e) {
		out.println(e);
	} catch (SQLException e) {
		out.println(e);
	}
	%>
	<script>
		alert("업로드 성공");
		location.href = "/AdminMain";
	</script>
	<%=multi.getFilesystemName((String) multi.getFileNames().nextElement())%>
</body>
</html>