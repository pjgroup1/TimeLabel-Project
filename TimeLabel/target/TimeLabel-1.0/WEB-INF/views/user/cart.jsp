<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
<link rel="stylesheet" href="/resources/css/user/cart.css">
<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous">
</script>
</head>
<body>

<div class="wrapper">
	<div class="wrap">
		<div class="top_gnb_area">
			<ul class="list">
				<!-- 로그인 하지 않은 상태 -->
				<c:if test = "${loginUser == null}">
					<li >
						<a href="/user/login">로그인</a>
					</li>
					<li>
						<a href="/user/join">회원가입</a>
					</li>
				</c:if>
				
				<!-- 로그인 한 상태 -->
				<c:if test="${loginUser != null }">
					<!-- 관리자 계정 -->
					<c:if test="${loginUser.userIndex == 1 }">
						<li><a href="/admin/main">관리자 페이지</a></li>
					</c:if>							
					<li>
						<a id="gnb_logout_button">로그아웃</a>
					</li>
					<li>
						<a href="/cart/main?userIndex=${loginUser.userIndex}">장바구니</a>
					</li>
				</c:if>				
				<li>
					고객센터
				</li>			
			</ul>			
		</div>
		<div class="top_area">
			<!-- 로고영역 -->
			<div class="logo_area">
				<a href="/main"><img src="../resources/image/Logo.png"></a>
			</div>
			<div class="search_area">
                	<div class="search_wrap">
                		<form id="searchForm" action="/search" method="get">
                			<div class="search_input">
                				<select name="type">
                					<option value="P">상품 이름</option>
                				</select>
                				<input type="text" name="keyword" value="<c:out value="${pageMaker.cri.keyword}"/>">
                    			<button class='btn search_btn'>검 색</button>                				
                			</div>
                		</form>
                	</div>
			</div>
			<div class="login_area">
			
				<!-- 로그인 하지 않은 상태 -->
				<c:if test = "${loginUser == null }">
					<div class="login_button"><a href="/user/login">로그인</a></div>
					<span><a href="/user/join">회원가입</a></span>				
				</c:if>				
				
				<!-- 로그인한 상태 -->
				<c:if test="${loginUser != null }">
					<div class="login_success_area">
						<span>회원 : ${loginUser.userName}</span>
						<span>환영합니다</span>
						<a href="/user/logout">로그아웃</a>
					</div>
				</c:if>
				
			</div>
			<div class="clearfix"></div>			
		</div>
		<div class="content_area">
			
			<div class="content_subject"><span>장바구니</span></div>
			<!-- 장바구니 리스트 -->
			<div class="content_middle_section"></div>
			<!-- 장바구니 가격 합계 -->
			<!-- cartInfo -->
			<div class="content_totalCount_section">
				
				<!-- 체크박스 전체 여부 -->
				<div class="all_check_input_div">
					<input type="checkbox" class="all_check_input input_size_20" checked="checked"><span class="all_chcek_span">전체선택</span>
				</div>				
				
				<table class="subject_table">
					<caption>상품 제목 부분</caption>
					<tbody>

						<tr>
							<th class="td_width_1"></th>
							<th class="td_width_2"></th>
							<th class="td_width_3">상품명</th>
							<th class="td_width_4">가격</th>
							<th class="td_width_4">수량</th>
							<th class="td_width_4">합계</th>
							<th class="td_width_4">삭제</th>
						</tr>
					</tbody>
				</table>
				<table class="cart_table">
					<caption>상품 내용 부분</caption>
					<tbody>
						<c:forEach items="${cartInfo}" var="ci">
							<tr>
								<td class="td_width_1 cart_info_td">
									<input type="checkbox" class="individual_cart_checkbox input_size_20" checked="checked">
									<input type="hidden" class="individual_productPrice_input" value="${ci.productPrice}">
									<input type="hidden" class="individual_productCount_input" value="${ci.productCount}">
									<input type="hidden" class="individual_discountedPrice_input" value="${ci.discountedPrice}">
									<input type="hidden" class="individual_productName_input" value="${ci.productName}">								
								</td>
								<td class="td_width_2">
									<%-- <div class="image_wrap" data-productname="${ci.productThumbImage}" data-path="${ci.productThumbImage.uploadPath}" data-uuid="${ci.productThumbImage.uuid}" data-filename="${ci.productThumbImage.fileName}"> --%>
										<img src="${ci.productThumbImage}">
								</td>

								</td>
								<td class="td_width_3">${ci.productName}</td>
								<td class="td_width_4 price_td">
									<del>정가 : <fmt:formatNumber value="${ci.productPrice}" pattern="#,### 원" /></del><br>
									판매가 : <span class="red_color"><fmt:formatNumber value="${ci.discountedPrice}" pattern="#,### 원" /></span><br>
								</td>
								<td class="td_width_4 table_text_align_center">
									<div class="table_text_align_center quantity_div">
										<input type="text" value="${ci.productCount}" class="quantity_input">	
										<button class="quantity_btn plus_btn">+</button>
										<button class="quantity_btn minus_btn">-</button>
									</div>
									<a class="quantity_modify_btn" data-cartIndex="${ci.cartIndex}">변경</a>
								</td>
								<%-- <td class="td_width_4 table_text_align_center">
									<fmt:formatNumber value="${ci.salePrice * ci.productCount}" pattern="#,### 원" />
								</td> --%>
								<td class="td_width_4 table_text_align_center">
									<button class="delete_btn" data-cartIndex="${ci.cartIndex}">삭제</button>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<table class="list_table">
				</table>
			</div>
			<!-- 가격 종합 -->
			<div class="content_total_section">
				<div class="total_wrap">
					<table>
						<tr>
							<td>
								<table>
									<tr>
										<td>총 상품 가격</td>
										<td>
											<span class="totalPrice_span">{productPrice}</span> 원
										</td>
									</tr>
									<tr>
										<td>총 주문 상품수</td>
										<td><span class="totalCount_span"></span>${cartInfo.size()}</td>
									</tr>
								</table>
							</td>
							<td>
								<table>
									<tr>
										<td></td>
										<td></td>
									</tr>
								</table>							
							</td>
						</tr>
					</table>
					<div class="boundary_div">--------------------------------------</div>
					<table>
						<tr>
							<td>
								<table>
									<tbody>
										<tr>
											<td>
												<strong>총 결제 예상 금액</strong>
											</td>
											<td>
												<span class="finalTotalPrice_span">{productPrice}</span> 원
											</td>
										</tr>
									</tbody>
								</table>
							</td>
						</tr>
					</table>
				</div>
			</div>
			<!-- 구매 버튼 영역 -->
			<div class="content_btn_section">
				<a class="order_btn">주문하기</a>
			</div>
			
			<!-- 수량 조정 form -->
			<form action="/cart/update" method="post" class="quantity_update_form">
				<input type="hidden" name="cartIndex" class="update_cartIndex">
				<input type="hidden" name="productCount" class="update_productCount">
				<input type="hidden" name="userIndex" value="${loginUser.userIndex}">
			</form>	
			
			<!-- 삭제 form -->
			<form action="/cart/delete" method="post" class="quantity_delete_form">
				<input type="hidden" name="cartIndex" class="delete_cartIndex">
				<input type="hidden" name="userIndex" value="${loginUser.userIndex}">
			</form>		
			<!-- 주문 form -->
			<form action="/order/${loginUser.userIndex}" method="get" class="order_form">
			</form>
	
			
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
				</ul>
			</div>
		</div> <!-- class="footer_nav" -->
		
		<div class="footer">
			<div class="footer_container">
				
				<div class="footer_left">
					<img src="../resources/image/Logo.png">
				</div>
				<div class="footer_right">
					(주) 더조은아카데미    대표 : 프로젝트1조
                    <br>
					대표전화 : 1234-5678
                    <br>
                    <br>
                    COPYRIGHT(C) <strong>https://github.com/pjgroup1/TimeLabel-Project</strong>    ALL RIGHTS RESERVED.
                </div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div> 		
	</div>

<script>
$(document).ready(function(){
	
	/* 종합 정보 섹션 정보 삽입 */
	setTotalInfo();	
	
	/* 이미지 삽입 */
	/* $(".image_wrap").each(function(i, obj){
	
		const pobj = $(obj);
		
		if(pobj.data("productid")){
			const uploadPath = pobj.data("path");
			const uuid = pobj.data("uuid");
			const fileName = pobj.data("filename");
			
			const fileCallPath = encodeURIComponent(uploadPath + "/s_" + uuid + "_" + fileName);
			
			$(this).find("img").attr('src', '/display?fileName=' + fileCallPath);
		} else {
			$(this).find("img").attr('src', '../resources/image/NoImage.png');
		}
		
	}); */
	
	
});	
/* 체크여부에따른 종합 정보 변화 */
$(".individual_cart_checkbox").on("change", function(){
	/* 총 주문 정보 세팅(총 가격, 물품 수, 종류) */
	setTotalInfo($(".cart_info_td"));
});

/* 체크박스 전체 선택 */
$(".all_check_input").on("click", function(){
	
	/* 체크박스 체크/해제 */
	if($(".all_check_input").prop("checked")){
		$(".individual_cart_checkbox").attr("checked", true);
	} else{
		$(".individual_cart_checkbox").attr("checked", false);
	}
	
	/* 총 주문 정보 세팅(총 가격, 물품 수, 종류) */
	setTotalInfo($(".cart_info_td"));	
	
});

/* 총 주문 정보 세팅(총 가격, 물품 수, 종류) */
function setTotalInfo(){
	
	let totalPrice = 0;				// 총 가격
	let totalCount = 0;				// 총 개수
	let totalKind = 0;				// 총 종류
	
	$(".cart_info_td").each(function(index, element){
		
		if($(element).find(".individual_cart_checkbox").is(":checked") === true){	//체크여부
			// 총 가격
			totalPrice += parseInt($(element).find(".individual_totalPrice_input").val());
			// 총 갯수
			totalCount += parseInt($(element).find(".individual_productCount_input").val());
			// 총 종류
			totalKind += 1;	
		}
	});
	
}

/* 수량버튼 */
$(".plus_btn").on("click", function(){
	let quantity = $(this).parent("div").find("input").val();
	$(this).parent("div").find("input").val(++quantity);
});
$(".minus_btn").on("click", function(){
	let quantity = $(this).parent("div").find("input").val();
	if(quantity > 1){
		$(this).parent("div").find("input").val(--quantity);		
	}
});

/* 수량 수정 버튼 */
$(".quantity_modify_btn").on("click", function(){
	let cartIndex = $(this).data("cartindex");
	let productCount = $(this).parent("td").find("input").val();
	$(".update_cartIndex").val(cartIndex);
	$(".update_productCount").val(productCount);
	$(".quantity_update_form").submit();
	
});

/* 장바구니 삭제 버튼 */
$(".delete_btn").on("click", function(e){
	e.preventDefault();
	const cartIndex = $(this).data("cartindex");
	$(".delete_cartIndex").val(cartIndex);
	$(".quantity_delete_form").submit();
});

/* 주문 페이지 이동 */	
$(".order_btn").on("click", function(){
	
	let form_contents ='';
	let orderIndex = 0;
	
	$(".cart_info_td").each(function(index, element){
		
		if($(element).find(".individual_cart_checkbox").is(":checked") === true){	//체크여부
			
			let productIndex = $(element).find(".individual_productIndex_input").val();
			let productCount = $(element).find(".individual_productCount_input").val();
			
			let productIndex_input = "<input name='orders[" + orderIndex + "].productIndex' type='hidden' value='" + productIndex + "'>";
			form_contents += productIndex_input;
			
			let productCount_input = "<input name='orders[" + orderIndex + "].productCount' type='hidden' value='" + productCount + "'>";
			form_contents += productCount_input;
			
			orderNumber += 1;
			
		}
	});	
	$(".order_form").html(form_contents);
	$(".order_form").submit();
	
});

</script>

</body>
</html>