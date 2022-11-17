<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"
	integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
	crossorigin="anonymous">

</script>
<link rel="stylesheet" href="/resources/css/user/login.css">
</head>
<body>

	<div class="wrapper">
		<div class="wrap">
			<form action="<c:url value = '/user/login'/>" method="post">
				<!-- <form id="login_form" method="post" action="User/login"> -->
				<div class="title_wrap">
					<span>저희 "타임라벨"에 오신 걸 환영합니다!</span>
				</div>
				<div class="login_wrap">
					<div class="id_wrap">
						<div class="input_box">
							<input class="id_input" name="userId">
						</div>
					</div>
					<div class="id_wrap">
						<div class="input_box">
							<input class="id_input" name="userPw">
						</div>
					</div>

					<%-- <c:if> 태그를 사용한 이유
					test 속성명의 값을 선언해주면 서버에서
					로그인에 실패한다면 result 변수에 0을 저장하여 페이지에 전송
					이때 test 속성 값이 true가 되어 다음과 같은 경고창 출력 --%>
					<c:if test="${result == 0 }">
						<div class="login_warn">아이디 혹은 비밀번호를 확인해주세요.</div>
					</c:if>

					<div class="login_button_wrap">
						<button type="submit" class="login_button">
							로그인
						</button>
					 		<!-- <input type="button" class="login_button" value="로그인"> -->
					 		<!-- <button onclick="location='login.jsp'" class="login_button">로그인</button> -->
					</div>
					<div class="join_button_wrap">
						<!-- <a href="/user/join"> 
							<input type="button" class="join_button" value="회원가입"> 
							<button type="button" class="join_button">회원가입</button>
						</a> -->
							<button type="button" onclick="location.href='/user/join'" class="join_button">회원가입</button>

					</div>
				</div>
			</form>
				
				
		</div>

	</div>

	<script>
		/* 로그인 버튼 클릭 메서드 */
		$(".login_button").click(function() {

			// alert("로그인 버튼 작동");

			/* 로그인 메서드 서버 요청 */
			$("#login_form").attr("action", "/user/login");
			$("#login_form").submit();

		});

	</script>

</body>
</html>