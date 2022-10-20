<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<style>
	#login-box {
		width:420px;
		margin-left:auto;
		margin-right:auto;
		text-align:center;
		white-space:nowrap;
	}
	
	table{
		border:3px solid #d49466;
		margin-left:auto;
		margin-right:auto;
		text-align:center;
	}
	
	td{
		border:1px solid #d49466;
		text-align:center;
	}
	
	#title{
		backgroud-color:#d49466
	}
</style>

<script>
        function checkValue() {
            inputForm = eval("document.loginInfo");
            if(!inputForm.ID.value) {
                alert("아이디를 입력하세요");    
                inputForm.ID.focus();
                return false;
            }
            if(!inputForm.PWD.value) {
                alert("비밀번호를 입력하세요");    
                inputForm.PWD.focus();
                return false;
            }
        } 
        
        // 회원가입 버튼 클릭시 회원가입 화면으로 이동
		function goJoinForm() {
			location.href="http://localhost:8282/join.do";
		}	
		
/* 		function goAdminLoginPro() {
			location.href="../admin/AdminLoginPro()";
		} */
		
    </script>
</head>
 
<body>
	<body bgcolor="#e1eff2">
	
    <div id="wrap">
    	<center><b><font size="6" color="gray">저희 "타임라벨"에 오신 걸 환영합니다!</font></b></center>
        <br><br><br>
        <form name="loginInfo" method="post" onsubmit="return checkValue()" action="/loginPro">
       		
       		<!-- 이미지 추가 -->
			<center><img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRxvbb28oyIcTfCHqnSegWvHOU9s7CY_cEozA&usqp=CAU" width="40%", height="20%"></center>
			<%-- <center><img src="img/welcome.jpg"></center> --%>
			<br><br>
 
       		<table>
               <tr>
	               <td>아이디</td>
	               <td><input type="text" name="ID" maxlength="20"></td>
               </tr>
               
               <tr>
	               <td>비밀번호</td>
	               <td><input type="password" name="PWD" maxlength="20"></td>
               </tr>
            </table>
            <br>
            <input type="submit" value=" 로그인 " > 
            <input type="button" value=" 회원가입 " onClick="goJoinForm()" >
            </div>
            <br><br>
        </form>
    </div>    
</body>
</html>