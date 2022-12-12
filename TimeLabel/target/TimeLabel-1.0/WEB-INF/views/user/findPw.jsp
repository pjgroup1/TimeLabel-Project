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
        <form action="/user/findPw" method="post">
            <!-- <form id="login_form" method="post" action="User/login"> -->
            <div class="title_wrap">
                <img src="/resources/image/big_welcome.jpg">
            </div>
            <div class="login_wrap">
                <div class="id_wrap">
                    <div class="input_box">
                        <input type="text" class="id_input" name="userId" placeholder="아이디를 입력해주세요">
                    </div>
                </div>
                <div class="id_wrap">
                    <div class="input_box">
                        <input type="email" class="id_input" name="userEmail" placeholder="이메일을 입력해주세요">
                    </div>
                </div>
                <div class="join_button_wrap">
                    <button type="submit" class="join_button">비밀번호 찾기</button>
                </div>
            </div>
        </form>


    </div>

</div>
</body>
</html>
</body>
</html>