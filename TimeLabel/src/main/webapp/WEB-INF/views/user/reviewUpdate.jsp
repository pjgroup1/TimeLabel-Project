<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>댓글 수정</title>
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
  		padding: 5px 30px 30px 30px;
  		text-align: center;
  	}
  	
  	/* 버튼 영역 */
  	.cancel_btn{
  		margin-right:5px;
  	    display: inline-block;
	    width: 130px;
	    background-color: #5e6b9f;
	    padding-top: 10px;
	    height: 27px;
	    color: #fff;
	    font-size: 14px;
	    line-height: 18px;  	
  	}
  	.enroll_btn{
   	    display: inline-block;
	    width: 130px;
	    background-color: #7b8ed1;
	    padding-top: 10px;
	    height: 27px;
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
  	
  	.update_btn{
   	    display: inline-block;
	    width: 130px;
	    background-color: #7b8ed1;
	    padding-top: 10px;
	    height: 27px;
	    color: #fff;
	    font-size: 14px;
	    line-height: 18px;   	
  	}  	
  
  </style>  
</head>

<body>
	<div class="wrapper_div">
		<div class="subject_div">
			리뷰 수정
		</div>
		
		<div class="input_wrap">			
			<div class="productName_div">
				<h2>${productInfo.productName}</h2>
			</div>
			<div class="content_div">
				<h4>리뷰</h4>
				<textarea name="content">${reviewInfo.content}</textarea>
			</div>
		</div>
		
		<div class="btn_wrap">
			<a class="cancel_btn">취소</a><a class="update_btn">수정</a>
		</div>
		
	</div>
	
	<script>

	/* $(document).ready(function(){

		let rating = '${reviewInfo.rating}';		
	
		$("option").each(function(i,obj){
			if(rating === $(obj).val()){
				$(obj).attr("selected", "selected");
			}
		});		
		
	});	 */
	
	/* 취소 버튼 */
	$(".cancel_btn").on("click", function(e){
		window.close();
	});	
	
	/* 등록 버튼 */
	$(".update_btn").on("click", function(e){
		
		const reviewIndex = '${reviewInfo.reviewIndex}';
		const productIndex = '${reviewInfo.productIndex}';
		const userIndex = '${userIndex}';
		const reviewContent = $("textarea").val();		
		
		const data = {
				reviewIndex : reviewIndex,
				productIndex : productIndex,
				userIndex : userIndex,
				reviewContent : reviewContent
		}	
		
		$.ajax({
			data : data,
			type : 'POST',
			url : '/review/update',
			success : function(result){
				$(opener.location).attr("href", "javascript:reviewListInit();");
				window.close();
			}			
		});		

	});	
	
	</script>

</body>
</html>