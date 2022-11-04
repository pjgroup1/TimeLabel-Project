<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<style>
#join-box {
	width: 530px;
	margin-left: auto;
	margin-right: auto;
	text-align: center;
}

table {
	border: 3px solid red
}

td {
	border: 1px solid pink
}

#title {
	background-color: pink
}
</style>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript">
	// 필수 입력정보인 아이디, 비밀번호가 입력되었는지 확인하는 함수
	function checkValue() {
		var form = document.userInfo;
		if (!form.ID.value) {
			alert("아이디를 입력하세요.");
			return false;
		}
		if (form.idDuplication.value != "checked") {
			alert("아이디 중복체크를 해주세요.");
			return false;
		}

		if (!form.PWD.value) {
			alert("비밀번호를 입력하세요.");
			return false;
		}

		// 비밀번호와 비밀번호 확인에 입력된 값이 동일한지 확인
		if (form.PWD.value != document.userInfo.PWD_RE.value) {
			alert("비밀번호를 동일하게 입력하세요.");
			return false;
		}

		if (!form.UserName.value) {
			alert("이름을 입력하세요.");
			return false;
		}

		if (!form.Email.value) {
			alert("이메일을 입력하세요.");
			return false;
		}

		if (!form.Contact.value) {
			alert("연락처를 입력하세요.");
			return false;
		}

		if (!form.Address.value) {
			alert("주소를 입력하세요.");
			return false;
		}
	}
	function id_check() {
		window.open("/idCheck", "_blank", "width=300px height=100px")

	}
	// 취소 버튼 클릭시 로그인 화면으로 이동
	function goLoginForm() {
		location.href = "http://localhost:8282/";
	}

	function getPostcodeAddress() {
		new daum.Postcode(
				{
					oncomplete : function(data) {
						// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
						// 각 주소의 노출 규칙에 따라 주소를 조합한다.
						// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
						var fullAddr = ''; // 최종 주소 변수
						var extraAddr = ''; // 조합형 주소 변수
						// 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
						if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
							fullAddr = data.roadAddress;
						} else { // 사용자가 지번 주소를 선택했을 경우(J)
							fullAddr = data.jibunAddress;
						}
						// 사용자가 선택한 주소가 도로명 타입일때 조합한다.
						if (data.userSelectedType === 'R') {
							//법정동명이 있을 경우 추가한다.
							if (data.bname !== '') {
								extraAddr += data.bname;
							}
							// 건물명이 있을 경우 추가한다.
							if (data.buildingName !== '') {
								extraAddr += (extraAddr !== '' ? ', '
										+ data.buildingName : data.buildingName);
							}
							// 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
							fullAddr += (extraAddr !== '' ? ' (' + extraAddr
									+ ')' : '');
						}
						// 주소 정보 전체 필드 및 내용 확인 : javateacher
						/*  var output = '';
						 for (var key in data) {
						   output += key + ":" +  data[key]+"\n";
						 }          
						 alert(output); */
						// 3단계 : 해당 필드들에 정보 입력
						// 우편번호와 주소 정보를 해당 필드에 넣는다.
						// document.userInfo.Address.value = data.zonecode; //5자리 새우편번호 사용
						document.userInfo.Address.value = fullAddr;
						// 커서를 상세주소 필드로 이동한다.
						document.userInfo.Address.focus();
					}
				}).open();
	}
</script>
</head>
<body>
	<!-- div 왼쪽, 오른쪽 바깥여백을 auto로 주면 중앙정렬된다.  -->
	<div id="wrap">
		<br> <br> <b><font size="6" color="gray">회원가입</font></b> <br>
		<br> <br>

		<!-- 입력한 값을 전송하기 위해 form 태그를 사용한다 -->
		<!-- 값(파라미터) 전송은 POST 방식, 전송할 페이지는 joinPro.jsp -->
		<form method="post" action="/joinPro" name="userInfo"
			onsubmit="return checkValue();">
			<table>
				<tr>
					<td id="title">아이디</td>
					<td><input type="text" name="ID" maxlength="20">
					<input type="button" value=" 중복 확인 " onclick="id_check()">
					<input type="hidden" name="idDuplication" value="unchecked"></td>
				</tr>

				<tr>
					<td id="title">비밀번호</td>
					<td><input type="password" name="PWD" maxlength="15">
					</td>
				</tr>

				<tr>
					<td id="title">비밀번호 확인</td>
					<td><input type="password" name="PWD_RE" maxlength="15">
					</td>
				</tr>

				<tr>
					<td id="title">이름</td>
					<td><input type="text" name="UserName" maxlength="40">
					</td>
				</tr>

				<tr>
					<td id="title">이메일</td>
					<td><input type="email" name="Email" maxlength="80"></td>
				</tr>

				<tr>
					<td id="title">연락처</td>
					<td><select name="Contact">  
							<option value="010">010</option>
					</select> <input type="text" name="Contact2" size="4" maxLength="4"
						oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*?)\..*/g, '$1');" />
						<input type="text" name="Contact3" size="4" maxLength="4"
						oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*?)\..*/g, '$1');" /></td>
				</tr>

				<tr>
					<td id="title">주소</td>
					<td><input type="text" size="50" name="Address" readOnly><input
						type="button" value="주소 검색" onClick="getPostcodeAddress()"></td>
				</tr>
				<tr>
					<td id="title">상세주소</td>
					<td><input type="text" size="30" name="Address_detail"></td>
				</tr>
			</table>
			<br> <input type="submit" value=" 가 입 "> <input
				type="button" value=" 취 소 " onclick="goLoginForm()">
		</form>
	</div>
</body>
</html>