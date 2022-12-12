<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/user/join.css">
    <script
            src="https://code.jquery.com/jquery-3.4.1.js"
            integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
            crossorigin="anonymous">
    </script>
    <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>

<div class="wrapper">
    <!-- NullPointExcetpion 방지 -->
    <!-- <input type="hidden" name="userIndex" value="" /> -->
    <div class="wrap">
        <form action="/user/modifyUser" method="post">
            <div class="subjecet">
                <span>마이 페이지</span>
            </div>
            <div class="id_wrap">
                <input type="hidden" name="userIndex" readonly value="${loginUser.userIndex}">
                <div class="id_name">아이디</div>
                <div class="id_input_box">
                    <input class="id_input" name="userId" readonly value="${user.userId}" type="text">
                </div>
            </div>
            <div class="id_wrap">
                <div class="id_password">패스워드</div>
                <div class="id_input_box">
                    <input class="id_input" name="userPw" type="text" value="${user.userPw} ">
                </div>
            </div>
            <div class="user_wrap">
                <div class="user_name" name="userName">이름</div>
                <div class="user_input_box">
                    <input class="user_input" name="userName" value="${user.userName}" type="text">
                </div>
            </div>
            <div class="mail_wrap">
                <div class="mail_name" name="userEmail">이메일</div>
                <div class="mail_input_box">
                    <input class="mail_input" name="userEmail" value="${user.userEmail}" type="text">
                </div>
            </div>
            <div class="mobile_wrap">
                <div class="mobile_name" name="userContact">연락처</div>
                <div class="mobile_input_box">
                    <input class="mobile_input" name="userMobile" value="${user.userMobile}" type="text">
                </div>
            </div>
            <div class="address_wrap">
                <div class="address_name">우편주소</div>
                <div class="address_input_1_wrap">
                    <div class="address_input_1_box">
                        <input class="address_input_1" name="userZip" value="${user.userZip}" type="text">
                    </div>
                    <div class="address_button" onclick="execution_daum_address()">
						<span>주소찾기</span>
					</div>
					<div class="clearfix"></div>
                </div>
                <div class="address_input_2_wrap">
                    <div class="address_input_2_box">
                        <input class="address_input_2" name="userAddress" value="${user.userAddress}" type="text">
                    </div>
                </div>
                <div class="address_input_3_wrap">
                    <div class="address_input_3_box">
                        <input class="address_input_3" name="userAddressDetail" value="${user.userAddressDetail}"
                               type="text">
                    </div>
                </div>
            </div>
            <div class="join_button_wrap">
            <button type="submit" class="join_button">회원 정보 수정</button>
			</div>        
        </form>
    </div>
</div>
</body>
</html>
