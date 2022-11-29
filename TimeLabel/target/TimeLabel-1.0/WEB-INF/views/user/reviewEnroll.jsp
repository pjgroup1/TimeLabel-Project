<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>댓글 등록</title>
<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous">
</script>

  <style type="text/css">
  	/* 창 여분 없애기 */
  	body{
  		margin : 0;
  	}
  	
  	/* 전체 배경화면 색상 */
  	.wrapper_div{
		background-color: #f5f5f5;
	    height: 100%;  	
  	}
  	
 	/* 팝업창 제목 */
  	.subject_div{
	    width: 100%;
	    background-color: #7b8ed1;
	    color: white;
	    padding: 10px;
	    font-weight: bold;
  	}
  	
  	/* 컨텐츠, 버튼 영역 padding */
  	.input_wrap{
  		padding: 30px;
  	}
  	.btn_wrap{
  		padding: 5px 30px 50px 30px;
  		text-align: center;
  	}
  	
  	/* 버튼 영역 */
  	.cancel_btn{
  		margin-right:5px;
  	    display: inline-block;
	    width: 130px;
	    background-color: #5e6b9f;
	    padding-top: 5px;
	    height: 40px;
	    color: #fff;
	    font-size: 14px;
	    line-height: 18px;  	
  	}
  	.enroll_btn{
   	    display: inline-block;
	    width: 130px;
	    background-color: #7b8ed1;
	    padding-top: 5px;
	    height: 40px;
	    color: #fff;
	    font-size: 14px;
	    line-height: 18px;   	
  	}

	/* 상품명 영역 */
	.productName_div h2{
		margin : 0;
	}

  	/* 리뷰 작성 영역 */
  	.content_div{
  		padding-top: 10px;
  	}
  	.content_div h4{
  		margin : 0;
  	}
  	textarea{
		width: 100%;
	    height: 100px;
	    border: 1px solid #dadada;
	    padding: 12px 8px 12px 8px;
	    font-size: 15px;
	    color: #a9a9a9;
	    resize: none;
	    margin-top: 10px;  	
  	}
  
  </style>  
</head>

<body>
	<div class="wrapper_div">
		<div class="subject_div">
			리뷰 등록
		</div>
		
		<div class="input_wrap">
			<div class="productName_div">
				<h2>${item.productName}</h2>
			</div>
		</div>
		
		<!-- <form action="/review/enroll" id="review_form" method="POST"> -->
					<div class="content_div">
						<!-- <h4>리뷰</h4> -->
						<textarea name="content"></textarea>
					</div>
					<div class="btn_wrap">
						<button type="reset" class="cancel_btn">취소</button>
						<button type="button"  class="enroll_btn">등록</button>
					</div>
					<%-- <input type="hidden" name="userIndex" value="${loginUser.userIndex}">
					<input type="hidden" name="productIndex" value="${item.productIndex}">
					<input type="hidden" name="reviewContent" value=""> --%>
		<!-- </form> -->
		
	</div>
	
	<script>
	
	/* 취소 버튼 */
	$(".cancel_btn").on("click", function(e){
		window.close();
	});	
	
	/* 등록 버튼 */
	$(".enroll_btn").on("click", function(e){

		const reviewContent = $("textarea").val();
		const userIndex=${loginUser.userIndex};
		const productIndex=${item.productIndex};
		console.log(productIndex);
		const data = {
				productIndex : productIndex,
				userIndex : userIndex,
				reviewContent : reviewContent
		}
		$.ajax({
			url:"/review/enroll",
			type:"post",
			data: data,
			success: function(result){
				if(result=="1"){
					console.log("submit 실행");
					console.log("content:"+$('input[name=reviewContent]').val());
					alert("리뷰 등록 성공");
					setTimeout(function(){
						console.log("창닫기시작");
						window.close();
					},100);
				}
					
			}
		})
		
			
			// $("#review_form").submit();
			//console.log("팝업 시작");
			/* setTimeout(function(){
				console.log("창닫기시작");
				window.close();
			},1000); */
			
			//console.log("시간지남");
	});	
	
	</script>

</body>
</html>