<!-- /* 회원가입 처리, mysql 연동 */-->
<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*"%>

<%
request.setCharacterEncoding("UTF-8");
%>

<%
//join.jsp에서 입력받은 값들을 받아옴
String ID = request.getParameter("ID");
String PWD = request.getParameter("PWD");
String UserName = request.getParameter("UserName");
String Email = request.getParameter("Email");
String Contact = request.getParameter("Contact") + "-" + request.getParameter("Contact2") + "-"
		+ request.getParameter("Contact3");
String Address = request.getParameter("Address");
String Address_Detail=request.getParameter("Address_Detail");

try {
	Class.forName("org.mariadb.jdbc.Driver"); // HeidiSQL jdbc 연결
	String DB_URL = "jdbc:mariadb://javalec-sat.crwq4oaekhum.ap-northeast-2.rds.amazonaws.com:3306/sang_db";

	//String DB_URL = "jdbc:mysql://localhost:1234/TimeLabel?characterEncoding=UTF-8&serverTimezone=UTC";

	//기본: "jdbc:mysql://localhost:1234/TimeLabel"
	//"jdbc:mysql://localhost:1234/TimeLabel?user=user&password=password&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	//?characterEncoding=UTF-8&serverTimezone=UTC
	//?useUnicode=true&characterEncoding=utf8

	String userName = "sang";
	String password = "sang1234";

	Connection con = DriverManager.getConnection(DB_URL, userName, password);
	String sql = "INSERT INTO USER(USER_ID, USER_PW, USER_NAME, USER_EMAIL, USER_MOBILE, USER_ADDRESS,USER_DATE,USER_ADDRESS_DETAI) VALUES (?,?,?,?,?,?,?,?)"; // sql문 작성(입력받은 값들을 보내기 위한 작업)

	PreparedStatement pstmt = con.prepareStatement(sql);

	// values에 들어갈 각각의 ID, PWD, UserName, Email, Contact, Address 설정
	pstmt.setString(1, ID);
	pstmt.setString(2, PWD);
	pstmt.setString(3, UserName);
	pstmt.setString(4, Email);
	pstmt.setString(5, Contact);
	pstmt.setString(6, Address);
	pstmt.setString(7, LocalDateTime.now().toString());
	pstmt.setString(8, Address_Detail);

	pstmt.executeUpdate();

	pstmt.close();
	con.close();
}

catch (ClassNotFoundException e) {
	out.println(e);
} catch (SQLException e) {
	out.println(e);
}
%>

<script>
	alert("저희 쇼핑몰과 함께 해주셔서 감사합니다!");
	location.href = "/";
</script>