<!-- 사용자 메인 페이지 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인화면</title>
<link rel="stylesheet" href="/resources/css/user/main.css">
<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous">
</script>
</head>
<body>

<div class="wrapper">
	<div class="wrap">
		<div class="top_area">
			<!-- 로고 영역 -->
			<div class="logo_area">
				<a href="/main"><img src="/resources/image/welcome.jpg"></a>
			</div>
			<div class="search_area">
				<h1>search area</h1>
			</div>
			<div class="clearfix"></div>
		</div>
		<div class="navi_bar_area">
			<h1>navi area</h1>
		</div>
		<div class="content_area">
			<h1>content area</h1>
		</div>
		
		<!-- Footer 영역 -->
        <div class="footer_nav">
            <div class="footer_nav_container">
                <ul>
                    <li>회사소개</li>
                    <span class="line">|</span>
                    <li>이용약관</li>
                    <span class="line">|</span>
                    <li>고객센터</li>
                    <span class="line">|</span>
                    <li>광고문의</li>
                    <span class="line">|</span>
                </ul>
            </div>
        </div> 
        
        <div class="footer">
            <div class="footer_container">
                
                <div class="footer_left">
                    <img src="/resources/image/welcome.jpg">
                </div>
                <div class="footer_right">
                    (주) TimeLabel    대표이사 : 이승호 강사님
                    <br>
					사업자등록번호 : 123-45-67890
                    <br>
					대표전화 : 1234-5678
                    <br>
                    <br>
                    COPYRIGHT(C) <strong>https://github.com/pjgroup1/TimeLabel-Project</strong>    ALL RIGHTS RESERVED.
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
	</div>
	
</div>

<script>
 
    /* gnb_area 로그아웃 버튼 */
    $("#gnb_logout_button").click(function(){
        // alert("로그아웃 작동");
        $.ajax({
            type:"POST",
            url:"/user/logout",
            success:function(data){
                alert("로그아웃 성공");
               /*  document.location.reload(); */     
            } 
        });
    });
    
</script>

</body>
</html>