<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="/resources/css/user/join.css">
<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous">
</script>
</head>
<body>

<div class="wrapper">
	<form id="join_form" action="../user/join" method="post">
	<!-- NullPointExcetpion 방지 -->
	<!-- <input type="hidden" name="userIndex" value="" /> -->
	<div class="wrap">
			<div class="subjecet">
				<span>회원가입</span>
			</div>
			<div class="id_wrap">
				<div class="id_name" >아이디</div>
				<div class="id_input_box">
					<input class="id_input" name="userId">
				</div>
				<span class="id_input_re_1">사용 가능한 아이디입니다.</span>
				<span class="id_input_re_2">아이디가 이미 존재합니다.</span>
				<span style = "color:red" class="final_id_ck">아이디를 입력해주세요.</span>
			</div>
			<div class="pw_wrap">
				<div class="pw_name">비밀번호</div>
				<div class="pw_input_box">
					<input class="pw_input" name="userPw">
				</div>
				<span style = "color:red" class="final_pw_ck">비밀번호를 입력해주세요.</span>
			</div>
			<div class="pwck_wrap">
				<div class="pwck_name">비밀번호 확인</div>
				<div class="pwck_input_box">
					<input class="pwck_input">
				</div>
				<span style = "color:red" class="final_pwck_ck">비밀번호 확인을 입력해주세요.</span>
				<span style = "color:blue" class="pwck_input_re_1">비밀번호가 일치합니다.</span>
                <span style = "color:red" class="pwck_input_re_2">비밀번호가 일치하지 않습니다.</span>
			</div>
			<div class="user_wrap">
				<div class="user_name" name="userName">이름</div>
				<div class="user_input_box">
					<input class="user_input" name="userName">
				</div>
				<span style = "color:red" class="final_name_ck">이름을 입력해주세요.</span>
			</div>
			<div class="mail_wrap">
				<div class="mail_name" name="userEmail">이메일</div>
				<div class="mail_input_box">
					<input class="mail_input" name="userEmail" placeholder="ex) abcd@naver.com">
				</div>
				<span style = "color:red" class="final_mail_ck">이메일을 입력해주세요.</span>
			</div>
			<div class="mobile_wrap">
				<div class="mobile_name" name="userMobile">연락처</div>
				<div class="mobile_input_box">
					<input class="mobile_input" name="userMobile" placeholder="ex) 010-0000-0000">
				</div>
				<span style = "color:red" class="final_mobile_ck">연락처를 입력해주세요.</span>
			</div>
			<div class="address_wrap" >
				<div class="address_name">우편주소</div>
				<div class="address_input_1_wrap">
					<div class="address_input_1_box">
						<input class="address_input_1" readonly="readonly" name="userZip" placeholder="우편주소">
					</div>
					<div class="address_button" onclick="execution_daum_address()">
						<span>주소찾기</span>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class ="address_input_2_wrap">
					<div class="address_input_2_box">
						<input class="address_input_2" readonly="readonly"  name="userAddress" placeholder="주소">
					</div>
				</div>
				<div class ="address_input_3_wrap"> 
					<div class="address_input_3_box">
						<input class="address_input_3" readonly="readonly"  name="userAddressDetail" placeholder="상세주소">
					</div>
				</div>
			</div>
			<div class="join_button_wrap">
			<button type="button" class="join_button">가입하기</button>
				<!-- <input type="submit" class="join_button" value="가입하기"> -->
			</div>
		</div>
	</form>
</div>

<!-- 통합 로딩 방식 채택 -->
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<script>

/* 유효성 검사 통과유무 변수 */
var idCheck = false;            // 아이디
var idckCheck = false;          // 아이디 중복 검사
var pwCheck = false;            // 비밀번호
var pwckCheck = false;          // 비밀번호 확인
var pwckcorCheck = false;       // 비밀번호 확인 일치 여부
var nameCheck = false;          // 이름
var mailCheck = false;          // 이메일
var mobileCheck = false;		// 연락처


$(document).ready(function(){
	//회원가입 버튼(회원가입 기능 작동)
	
	$('.final_id_ck').css('display', 'block');
	$('.final_pw_ck').css('display','block');
	$('.final_pwck_ck').css('display','block');
	$('.final_name_ck').css('display', 'block');
	$('.final_mail_ck').css('display','block');
	$('.final_mobile_ck').css('display', 'block');
	
	$(".join_button").click(function(){
		
		/* 입력값 변수 */
		var id = $('.id_input').val();                // id 입력란
        var pw = $('.pw_input').val();                // 비밀번호 입력란
        var pwck = $('.pwck_input').val();            // 비밀번호 확인 입력란
        var name = $('.user_input').val();            // 이름 입력란
        var mail = $('.mail_input').val();            // 이메일 입력란
        var mobile = $('.mobile_input').val();		  // 연락처 입력란
		
        /* 아이디 유효성 검사 */
        if(id == ""){
        	
            $('.final_id_ck').css('display','block');
            idCheck = false;
            
        }else{
        	
            $('.final_id_ck').css('display', 'none');
            idCheck = true;
            
        }
        
        /* 비밀번호 유효성 검사 */
        if(pw == ""){
        	
            $('.final_pw_ck').css('display','block');
            pwCheck = false;
            
        }else{
        	
            $('.final_pw_ck').css('display', 'none');
            pwCheck = true;
            
        }
        
        /* 비밀번호 확인 유효성 검사 */
        if(pwck == ""){
        	
            $('.final_pwck_ck').css('display','block');
            pwckCheck = false;
            
        }else{
        	
            $('.final_pwck_ck').css('display', 'none');
            pwckCheck = true;
            
        }
        
        /* 이름 유효성 검사 */
        if(name == ""){
        	
            $('.final_name_ck').css('display','block');
            nameCheck = false;
            
        }else{
        	
            $('.final_name_ck').css('display', 'none');
            nameCheck = true;
            
        }
        
        /* 이메일 유효성 검사 */
        if(mail == ""){
        	
            $('.final_mail_ck').css('display','block');
            mailCheck = false;
            
        }else{
        	
            $('.final_mail_ck').css('display', 'none');
            mailCheck = true;
            
        }
        
        /* 연락처 유효성 검사 */
        if(mobile == ""){
        	
            $('.final_mobile_ck').css('display','block');
            mobileCheck = false;
            
        }else{
        	
            $('.final_mobile_ck').css('display', 'none');
            mobileCheck = true;
            
        }
        
        /* 최종 유효성 검사 */
        if(idCheck&&idckCheck&&pwCheck&&pwckCheck&&pwckcorCheck&&nameCheck&&mailCheck&&mobileCheck ){
    		$("#join_form").submit();
        }
        else
        	alert("정보가 미입력된 칸이 있습니다.");
        
        return false;
		
	});
});


//아이디 중복검사
$('.id_input').on("propertychange change keyup paste input", function(){
	
	var userId = $('.id_input').val();		// .id_input에 입력되는 값
	if(userId!=="")
		$('.final_id_ck').css('display', 'none');
	else
		{
		$('.final_id_ck').css('display', 'block');
		$('.id_input_re_1').css('display', 'none');
		}
	var data = {userId : userId}				// '컨트롤러에 넘길 데이터 이름' : '데이터(.id_input에 입력되는 값)'
	if(userId!=="")
	$.ajax({
		type : "post",
		url : "/user/userIdCheck",
		data : data,
		success : function(result){
			
			// console.log("성공 여부" + result);
			if(result != 'fail'){
				
				$('.id_input_re_1').css("display","inline-block");
				$('.id_input_re_2').css("display", "none");	
				idckCheck = true;
				
			} else {
				
				$('.id_input_re_2').css("display","inline-block");
				$('.id_input_re_1').css("display", "none");		
				idckCheck = false;
				
			}
			
		}// success 종료
	}); // ajax 종료

});// function 종료

/* 다음 주소 연동 */
function execution_daum_address(){
    
	new daum.Postcode({
		
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분
            
        	// 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져옴
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
            	
                addr = data.roadAddress;
            
            } else { 							 // 사용자가 지번 주소를 선택했을 경우
            	
                addr = data.jibunAddress;
            
            }

            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합
            if(data.userSelectedType === 'R'){
                // 법정동명이 있을 경우 추가 (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝남
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                	
                    extraAddr += data.bname;
                    
                }
                // 건물명이 있고, 공동주택일 경우 추가
                if(data.buildingName !== '' && data.apartment === 'Y'){
                	
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 생성
                if(extraAddr !== ''){
                	
                    extraAddr = ' (' + extraAddr + ')';
                    
                }
                // 주소변수 문자열과 참고항목 문자열 합치기
                addr += extraAddr;
            
            } else {
            	
                addr += ' ';
                
            }

            // 우편번호와 주소 정보를 해당 필드에 넣음
            $(".address_input_1").val(data.zonecode);
            //$("[name=memberAddr1]").val(data.zonecode);    // 대체가능
            $(".address_input_2").val(addr);
            //$("[name=memberAddr2]").val(addr);             // 대체가능
            
            // 상세주소 입력란 disabled 속성 변경 및 커서를 상세주소 필드로 이동한다.
            $(".address_input_3").attr("readonly",false);
            $(".address_input_3").focus();
 
        }
	
    }).open();  
	
}


$('.pw_input').on("propertychange change keyup paste input", function(){
	var pw = $('.pw_input').val();
	if(pw!=="")
	 $('.final_pw_ck').css('display', 'none');
	else
		$('.final_pw_ck').css('display', 'block');
});

$('.user_input').on("propertychange change keyup paste input", function(){
	var userId = $('.user_input').val();
	if(userId!=="")
	 $('.final_name_ck').css('display', 'none');
	else 
	$('.final_name_ck').css('display', 'block');
});

$('.mail_input').on("propertychange change keyup paste input", function(){
	var mail=$('.mail_input').val();
	if(mail!=="")
	 $('.final_mail_ck').css('display', 'none');
	else 
	$('.final_mail_ck').css('display', 'block');
});

$('.mobile_input').on("propertychange change keyup paste input", function(){
	var mobile=$('.mobile_input').val();
	if(mobile!=="")
	 $('.final_mobile_ck').css('display', 'none');
	else 
	$('.final_mobile_ck').css('display', 'block');
});


/* 비밀번호 확인 일치 여부 */

$('.pwck_input').on("propertychange change keyup paste input", function(){
        
	var pw = $('.pw_input').val();
    var pwck = $('.pwck_input').val();
    $('.final_pwck_ck').css('display', 'none');
    if(pwck==="")
    	{
    	 $('.pwck_input_re_1').css('display','none');
    	 $('.pwck_input_re_2').css('display','none');
    	 $('.final_pwck_ck').css('display','block');
    	}
    else{
    if(pw == pwck){
    	
        $('.pwck_input_re_1').css('display','block');
        $('.pwck_input_re_2').css('display','none');
        pwckcorCheck = true;
        
    }else{
    	
        $('.pwck_input_re_1').css('display','none');
        $('.pwck_input_re_2').css('display','block');
        pwckcorCheck = false;
        
    }        
    }	
});  


</script>

</body>
</html>