<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: mr.lee--%>
<%--  Date: 2022/11/15--%>
<%--  Time: 9:57--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java"%>--%>
<%--<html>--%>
<%--<head>--%>
<%--<title>Title</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--	<div>--%>
<%--		<img src="${item.productMainImage}">--%>
<%--	</div>--%>
<%--</body>--%>
<%--</html>--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%--<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>--%>

<!DOCTYPE>
<html>
<head>
	<meta charset="utf-8">
	<title>상품 상세보기</title>
	<script src="https://code.jquery.com/jquery-3.4.1.js"
			integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
			crossorigin="anonymous"></script>
	<!-- Bootstrap icons-->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
	<!-- Core theme CSS (includes Bootstrap)-->
	<link href="../resources/css/styles.css" rel="stylesheet" />
	<%-- <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <!-- <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script> -->
        <script src="<c:url value='/js/common1.js'/>" charset="utf-8"></script>
        <script type="text/javascript"
            src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>
        <!-- CSS only -->
        <link rel="stylesheet"
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
            integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
            crossorigin="anonymous">
        <!-- JS, Popper.js, and jQuery -->
        <!-- <script src="https://code.jquery.com/jquery-3.5.1.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script> -->
        <script
            src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
        <script
            src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
            integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
            crossorigin="anonymous"></script> --%>
</head>
<style>
	#ba {
		background-color: lightgray;
	}

	.layer {
		display: none;
	}

	/* css초기화 끝 */
	.option_section {
		float: left;
		color: #777;
		font-weight: 400;
	}

	/* 상품문의 */
	.board_list th {
		padding: 14px 0;
		background: url(/css/images/ico_board_th_bar.gif) no-repeat 0 center
		#f5f5f5;
		font-size: 14px;
		color: #666;
		font-weight: 400;
		text-align: center;
	}

	.board_list {
		width: 60%;
		margin-top: 0px;
		background: #fff;
		font-size: 15px;
		line-height: 18px;
	}

	.board_list2 {
		width: 60%;
		margin-top: 0px;
		background: #fff;
		font-size: 15px;
		line-height: 18px;
	}

	.board_list2 .tit {
		background: #fff;
		font-size: 15px;
	}

	.board_list2 .tit td {
		position: relative;
		padding: 20px 0;
		box-sizing: border-box;
		border-top: 1px solid #f2f2f2;
	}

	.td {
		position: relative;
		box-sizing: border-box;
		border-top: 1px solid #f2f2f2;
		margin-left: 100px;
	}

	.align_left {
		text-align: left !important;
	}

	.board_list2 td.align_left {
		padding: 16px 110px;
	}

	.board_list td {
		padding: 16px 0;
		text-align: center;
		border-bottom: 1px solid #e0e0e0;
		font-size: 14px;
		color: #444;
		vertical-align: top;
	}

	p.a {
		cursor: pointer;
	}

	/* 리뷰리스트 */
	::selection {
		background: #888;
		/* color: #fff; */
		text-shadow: none;
	}

	.xans-product-additional div.board {
		margin: 0 auto;
		padding: 27px 0 40px;
		max-width: 1220px;
		color: #353535;
		line-height: 18px;
	}

	.ec-base-table.typeList table {
		border-top: 1px solid #e5e5e5;
	}

	.ec-base-table table {
		position: relative;
		margin: 10px 0 0;
		border: 1px solid #e5e5e5;
		border-top: 0;
		border-left: 0;
		border-right: 0;
		/* color: #fff; */
		line-height: 1.5;
	}

	.ec-base-table table:before {
		position: absolute;
		top: 0;
		left: 0;
		display: block;
		content: "";
		width: 100%;
		height: 1px;
		background: #e5e5e5;
	}

	.displaynone {
		display: none !important;
	}

	.ec-base-table thead th {
		padding: 12px 0;
		border-bottom: 1px solid #e5e5e5;
		color: #353535;
		vertical-align: middle;
		font-size: 12px;
		font-weight: 500;
		background: #f9f9f9;
	}

	.xans-product-additional div.board {
		margin: 0 auto;
		padding: 27px 0 40px;
		max-width: 1220px;
		color: #353535;
		line-height: 18px;
	}

	.ec-base-table th:first-child {
		border-left: 0;
	}

	th {
		text-align: center;
	}

	.td1 {
		text-align: center;
		color: #777;
		padding: 12px 0;
	}

	.td2 {
		color: #777;
		padding: 12px 0;
	}

	.desc {
		padding: 0 0 20px;
		color: #777;
		font-size: 12px;
		text-align: center;
	}

	.d {
		width: 100%;
		heiht: 100%;
	}

	body {
		/*  font-family: Verdana, Arial; */
		font-family: 'Open Sans', sans-serif;
	}

	a {
		text-decoration: none;
		color: #666;
	}

	h1 {
		text-align: center;
		padding: 50px 0;
		font-weight: normal;
		font-size: 2em;
		letter-spacing: 10px;
	}

	.total_price {
		color: #666;
		font-size: 14px;
		padding: 20px 0 8px;
		text-align: right;
		box-sizing: border-box;
	}

	.total_cartAdd {
		color: #666;
		font-size: 14px;
		box-sizing: border-box;
	}

	.totals-value {
		font-size: 30px;
		color: #333;
		font-style: normal;
		font-weight: bold;
		padding-left: 12px;
		text-align: right;
	}

	.selected_option {
		position: relative;
		margin-top: -1px;
		padding: 20px 22px;
		border: 1px solid #e9e9e9;
		color: #333;
		font-size: 14px;
		line-height: 20px;
		overflow: hidden;
	}

	.product .remove-product {
		border: 0;
		padding: 4px 8px;
		background-color: #c66;
		color: #fff;
		font-family: "HelveticaNeue-Medium", "Helvetica Neue Medium";
		font-size: 12px;
		border-radius: 3px;
	}

	p {
		padding-top: 5px;
	}
	
	.paging{
		color: black;
		font-size: 20px;
		text-decoration-line: none;
	}
</style>
<%@include file="../include/header.jsp" %>
<body>

<br>
<br>
<br>
<br>

<div
		style="width: 100%; position: relative; left: calc(50% - 600px); height: 600px; ">

	<div style="float: left; width: 500px;">
<%--	<div style="float: left;">--%>
		<table border="0">
			<tr>
				<td><img src="${item.productMainImage}" width="100%" height="auto"/></td>
			</tr>
		</table>
	</div>

	<div style="float: left; margin-left: 30px; width: 682px;">
<%--	<div style="float: left; margin-left: 30px;">--%>
		<table border="0">
			<tr>
				<td id="goodsName"><font size="5"
										 style="box-sizing: border-box; position: relative;">${item.productName}</font></td>
			</tr>

			<tr>
				<td><font size="3">${item.productCategoryIndex}</font></td>
			</tr>

			<tr>
				<td></td>
			</tr>

			<tr>
				<td id="price"
					style="font-weight: bolder; font-Size: 24px; line-height: 42px;">
<%--					style=" font-Size: 24px; line-height: 42px;">--%>
<%--					 <fmt:formatNumber value="${detail.itemcost}" pattern="#,###" />원--%>
				</td>
			</tr>
		</table>

		<table>
			<tr>
				<td><hr style="border-top: 1px solid #bbb;" width=670px>
				<td>
			</tr>
		</table>

		<br>

		<table>
			<tr class="option_section">
				<td>배송비</td>
				<td>무료배송</td>
			</tr>
		</table>

		<%--		<table>--%>
		<%--			<tr class="option_section">--%>
		<%--				<td width="537px"><font size="3">배송종류</font></td>--%>
		<%--				<td><font size="3">&nbsp;국내배송</font></td>--%>
		<%--			</tr>--%>
		<%--		</table>--%>



		<div id="item_option">
			<table>
				<tr>
					<td><select name="optionList" id="optionList" onchange="optionChange()"
								class='total_cartAdd' style="width: 600px; height: 30px;">
						<option value="">==(필수)옵션: 사이즈 선택 ==</option>
					</select></td>
				</tr>
			</table>
		</div>

		<!-- <button style="width: 124px; height: 58px;"
            class="btn btn-outline-danger" id="insertLike"
            onclick="fn_InsertLike()">
            <font size="5px">#</font>
        </button> -->
		<div  style="float: left; margin-left: 450px;">
		<br>
			<input type="text" value="1" class="quantity_input" size=5 name="quantity_input">
			<button class="btn btn-outline-secondary" id="plus_btn">+</button>
			<button class="btn btn-outline-secondary" id="minus_btn">-</button>
		</div>
		<div class="totals-item totals-item-total"
			 style="float: left; margin-left: 400px;">
			<label class="total_price">상품금액</label>
			<label id="total_price" style="font-size:30px;font-weight:bold; text-decoration:line-through"><fmt:formatNumber value="${item.productPrice}" pattern="#,###"  /></label>
			<label style="font-size:30px;font-weight:bold;">₩</label>
			<br/>
			<br/>
			<label class="total_price">할인가</label>
			<label id="discount_price" style="font-size:30px;font-weight:bold; "><fmt:formatNumber value="${item.discountedPrice}" pattern="#,###" />₩</label>
		</div>`
		<table>
			<tr>
				<td><hr style="border-top: 1px solid #bbb;" width=670px>
				<td>
			</tr>
		</table>
		<form action="../cart/add" method="post" onsubmit="return sizeCheck()">
			<input name="productCount" value="1" type="hidden">
			<input name="productOptionIndex" value=val type="hidden">
			<input name="productIndex" value=val type="hidden">
			<br>
			<button style="width: 270px; height: 58px;"
					class="btn btn-outline-secondary" id="insertBasket" type="submit">장바구니</button>
		</form>
	<form action="../order/directAdd" method="get" onsubmit="return sizeCheck()">
		<input type="hidden" class="individual_productPrice_input"
			   name="productPrice1" value="${item.productPrice}">
		<input type="hidden" class="individual_productCount_input"
			   name="productCount1" id="productCount" value="1">
		<input type="hidden" class="individual_discountedPrice_input"
			   name="discounted1" value="${item.discountedPrice}">
		<input type="hidden" class="individual_productIndex_input"
			   name="productIndex1" value="${item.productIndex}">
		<input type="hidden" class="individual_productIndex_input" name="productName1"
			   value="${item.productName}">
		<input type="hidden" class="individual_productIndex_input"
			   name="productThumbImage1" value="${item.productThumbImage}">
		<input type="hidden" class="individual_productOptionIndex_input"
			   name="productOptionIndex1" value="1">
		<input type="hidden" class="individual_productOptionIndex_input"
			   name="productOptionValue1" value="">

		<input type="hidden" class="total_price"
			   name="totalDiscountPrice" value="${item.discountedPrice * 1}">

		<button style="width: 270px; height: 58px;" class="btn btn-outline-secondary" type="submit">구매하기</button>
		<br>
	</form>
	<c:if test="${loginUser.userIndex == 1}">
		<a href="/admin/modify/${item.productIndex}">
			<button style="width: 270px; height: 58px;"
					class="btn btn-outline-secondary" id="modify_btn" type="submit">제품 수정</button>
		</a>
	</c:if>
	</div>
</div>
<br>
<br>
<br>
<div class="content_bottom">
	<div class="review_subject">
		<h2>리뷰</h2>
	</div>
	<div class="reviewInfo">
		<c:forEach items="${reviewList}" var="review">
			<div style="display:inline;" class="container px-4 px-lg-5 mt-5">
				<table style="width: 330px; height: 100px; border-collapse: collapse; border-spacing: 10px; margin:10px" border="1" >
					<tbody>
					<tr>
						<td style="width: 230px;">
							<li>작성자 : ${review.userID}</li>
							<li>작성날짜 : ${review.reviewDate}</li>
							<li>작성내용 : ${review.reviewContent}</li>
						</td>
					</tr>
					</tbody>
				</table>
			</div>
		</c:forEach>
	</div>
	<a class="paging" href="/ProductPage/${productIndex}">첫페이지</a>&nbsp;
	<!-- 현재 페이지가 1 아닐때만 이전 버튼 있음 -->
	<c:if test="${pageNum!=1}">
	<a class="paging" href="/ProductPage/${productIndex}?pageNum=${pageNum-1}">이전</a>
	</c:if>
	<!-- 페이지 번호 5개 출력 -->
	<c:forEach items="${pageList}" var="page">
		<!-- 현재페이지는 강조해서 출력 -->
		<c:if test="${pageNum==page}">
			<a class="paging" href="/ProductPage/${productIndex}?pageNum=${page}" 
				style="font-weight: bold; font-size:22px;">${page}</a>
		</c:if>
		<!--  현재페이지가 아니면 그냥 출력 -->
		<c:if test="${pageNum!=page}">
			<a class="paging" href="/ProductPage/${productIndex}?pageNum=${page}">${page}</a>
		</c:if>
	</c:forEach>
	<!-- 현재페이지가 마지막이 아닐때만 다음 버튼 있음 -->
	<c:if test="${pageNum!=lastPage}">
	<a class="paging" href="/ProductPage/${productIndex}?pageNum=${pageNum+1}">다음</a>
	</c:if>
	&nbsp; <a class="paging" href="/ProductPage/${productIndex}?pageNum=${lastPage}">끝페이지</a>
</div>
<!-- 푸터 -->
<%@include file="../include/footer.jsp" %>

</body>
</html>
<!-- ----------------------------- 스크립트 부분 --------------------------------------------->
<script>
	// 컨트롤러에서 데이터 받기
	var jsonData = JSON.parse('${options}');
	//console.log(jsonData);
	// 필요한 배열과 오브젝트 변수 생성
	var optionArr = new Array();
	var optionObj = new Object();

	//셀렉트 박스에 삽입할 데이터 준비
	for (var i = 0; i < jsonData.length; i++) {
		optionObj = new Object(); // 초기화

		// optionObj에 optionIndex와 optionName을 저장
		optionObj.productOptionIndex = jsonData[i].productOptionIndex;
		optionObj.productOptionValue = jsonData[i].productOptionValue;

		// cate1Obj에 저장된 값을 cate1Arr 배열에 저장
		optionArr.push(optionObj);
	}
	console.log(optionObj);
	// 셀렉트 박스에 데이터 삽입
	var optionSelect = $("select.total_cartAdd")
	console.log(optionSelect);
	for (var i = 0; i < optionArr.length; i++) {

		// cate1Arr에 저장된 값을 cate1Select에 추가
		optionSelect
				.append("<option value='" + optionArr[i].productOptionIndex + "'>"
						+ optionArr[i].productOptionValue + "</option>");
	}
	/* 수량버튼 */
	$('#plus_btn').on("click", function() {
		var quantity = $(this).parent("div").find("input").val();
		$(this).parent("div").find("input").val(++quantity);
		$('input[name=productCount]').val(quantity);
		$('input[name=productCount1]').val(quantity);
		$('#total_price').text(${item.productPrice}*quantity);
		$('#discount_price').text(${item.discountedPrice}*quantity+'₩');
	});

	$('#minus_btn').on("click", function() {
		var quantity = $(this).parent("div").find("input").val();
		if (quantity > 1) {
			$(this).parent("div").find("input").val(--quantity);
		}
		$('input[name=productCount]').val(quantity);
		$('input[name=productCount1]').val(quantity);
		$('#total_price').text(${item.productPrice}*quantity);
		$('#discount_price').text(${item.discountedPrice}*quantity+'₩');

	});
	function optionChange(){
		var option=document.getElementsByName("optionList")[0]	;
		console.log(option.value);
		$('input[name=productOptionIndex]').val(option.value);
		$('input[name=productIndex]').val(${item.productIndex});
		$('input[name=productOptionIndex1]').val(option.value);
		$('input[name=productOptionValue1]').val(option.textContent);
	}

	function sizeCheck(){
		var optionSelect = $("select.total_cartAdd").val();

		if(optionSelect == ""){
			alert("사이즈를 선택해주세요");
			return false;
		}else
		{
			return true;
		}
	}
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
