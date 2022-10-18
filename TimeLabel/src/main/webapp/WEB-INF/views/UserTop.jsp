<!-- 상단바(반응형 웹 구현) -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/TopNav.css">
    <script src="https://kit.fontawesome.com/8351000410.js" crossorigin="anonymous"></script>
    <title>메인메뉴 상단</title>
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro:wght@300&display=swap" rel="stylesheet">   
	
</head>

<body>
    <nav class="navbar">
        <div class="navbar_logo">
            <i class="fas fa-cookie-bite"></i>
            <a href="UserMain">TimeLabel</a>
        </div>

        <ul class="navbar_menu">
            <li><a href="">메인메뉴</a></li>
            <li><a href="">상의</a></li>
            <li><a href="">하의</a></li>
            <li><a href="">신발</a></li>
        </ul>

        <ul class="navbar_usermenu">
<%
        // 현재 로그인된 아이디가 없다면 (= session에 저장된 id가 없다면)
        String id = (String) session.getAttribute("ID");
        if(id == null) {
%>
            <li><a href="../../join.jsp">회원가입</a></li>
            <li><a href="../../login.jsp">로그인</a></li>
            <li><a href="../../CartView.jsp">장바구니</a></li>
<%          
            }
		
        // 현재 로그인된 아이디가 있다면 (= session에 저장된 id가 있다면)
        else {
%>
            <li><a href="../../logoutPro.jsp">로그아웃</a></li>
            <li><a href="../../CartView.jsp">장바구니</a></li>
            <li><a href="">마이페이지</a></li>
<%			
        }
%>
        </ul>

        <a href="#" class="navbar_toggleBtn">   
            <i class="fas fa-bars"></i>
        </a>
    </nav>
    
    <script> //윈도우 창의 사이즈를 줄였을 시 나오는 햄버거 모양 토글바
	const toggleBtn = document.querySelector('.navbar_toggleBtn');
	const menu = document.querySelector('.navbar_menu');
	const icons = document.querySelector('.navbar_icons');
	
	toggleBtn.addEventListener('click',()=>{
	    menu.classList.toggle('active');
	    icons.classList.toggle('active');
	});
	</script>
	
</body>
</html>


<!-- 참고 영상 드림코딩 by 엘리님 [웹 사이트 따라 만들기, 반응형 헤더편]: https://youtu.be/X91jsJyZofw -->