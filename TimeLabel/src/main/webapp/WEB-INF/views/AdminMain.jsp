<!-- 사용자 메인 페이지 -->
<%@page import="java.util.ArrayList"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 화면</title>
<style type="text/css">
.buttonContainer {
	width: 10%;
	display: flex;
	justify-content: center;
	align-items: center;
	margin-left: 5px;
	background-color: black;
	color: white;
	border-radius: 30px;
	padding: 5px;
	font-size: 0.8em;
	cursor: pointer;
}
</style>
</head>

<body>
	<form action="UploadTest" id="imageTest" name="imageTest"
		enctype="multipart/form-data" method="post">
		파일명 <input type="file" name="upload" accept="image/*"
			onchange="loadFile(this)"> <input type="submit" value="업로드">
	</form>
	<div class="buttonContainer">
		<div class="submitButton" id="submitButton">미리보기</div>
	</div>
	<div class="image-show" id="image-show"></div>
	<div class="image-show2" id="imgae-show2"></div>
	<script type="text/javascript">
		function loadFile(input) {
			console.log(input.files);
			var file = input.files[0]; //선택된 파일 가져오기
			console.log(file);
			//기존이미지 삭제
			var oldImage = document.getElementById('image-show').lastElementChild;
			if (oldImage != null)
				oldImage.parentNode.removeChild(oldImage);
			//새로운 이미지 div 추가
			var newImage = document.createElement("img");
			newImage.setAttribute("class", 'img');

			//이미지 source 가져오기
			newImage.src = URL.createObjectURL(file);

			newImage.style.width = "50%";
			newImage.style.height = "50%";
			newImage.style.visibility = "hidden"; //버튼을 누르기 전까지는 이미지를 숨긴다
			newImage.style.objectFit = "contain";

			//이미지를 image-show div에 추가
			var container = document.getElementById('image-show');
			container.appendChild(newImage);
		};
		var submit = document.getElementById('submitButton');
		submit.onclick = showImage; //Submit 버튼 클릭시 이미지 보여주기

		function showImage() {
			var newImage = document.getElementById('image-show').lastElementChild;
			//이미지는 화면에 나타나고
			newImage.style.visibility = "visible";

		}
		function loadAll() {
			console.log("이미지불러오기");
			var image = document.createElement("img2");
			console.log(image);
			image.src = "C:/Users/TJ/Documents/GitHub/TimeLabel-Project/TimeLabel/src/main/webapp/resources/img/sample_images_01.png"
			image.style.width = "50%";
			image.style.height = "50%";
			image.style.objectFit = "contain";

			var container2 = document.getElementById('image-show2');
			container2.appendChild(image);
		}
	</script>
	<br>
	<button onclick="loadAll()" style="height: 50px, width=50px">
		이미지 불러오기</button>
</body>
<%
try {
	Class.forName("org.mariadb.jdbc.Driver"); // HeidiSQL jdbc 연결
	String URL = "jdbc:mariadb://javalec-sat.crwq4oaekhum.ap-northeast-2.rds.amazonaws.com:3306/sang_db";
	String userName = "sang";
	String password = "sang1234";

	Connection con = DriverManager.getConnection(URL, userName, password);
	String sql = "SELECT image_name FROM upload_test"; // sql문 작성(입력받은 값들을 보내기 위한 작업)

	PreparedStatement pstmt = con.prepareStatement(sql);
	ResultSet rs = pstmt.executeQuery();
	List<String> names = new ArrayList<>();
	while (rs.next()) {
		String name = rs.getString(1);
		names.add(name);
	}
	pstmt.close();
	con.close();
	out.println(names.size() + " " + names);
} catch (ClassNotFoundException e) {
	out.println(e);
} catch (SQLException e) {
	out.println(e);
}
%>
</html>