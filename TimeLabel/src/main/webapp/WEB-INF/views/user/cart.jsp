<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
<link rel="stylesheet" href="/resources/css/user/cart.css">
<script src="https://code.jquery.com/jquery-3.4.1.js"
	integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
	crossorigin="anonymous">
    </script>
<%@include file="../include/header.jsp"%>
<style>
.subject_table th,td {
	border-bottom: thin groove;
}
</style>
</head>

<body>

	<div class="wrapper">
		<div class="wrap">

			<div class="top_area">
				<!-- 로고영역 -->
				<%-- <div class="logo_area">
            <a href="/user/main"><img src="/resources/image/Logo.png"></a>
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
        </div>--%>

				<div class="clearfix"></div>
			</div>
			<div class="content_area">

				<div class="content_subject">
					<span style="font-size: 25px;">장바구니</span>
				</div>
				<!-- 장바구니 리스트 -->
				<div class="content_middle_section"></div>
				<!-- 장바구니 가격 합계 -->
				<!-- cartInfo -->
				<div class="content_totalCount_section">

					<form name="orderForm" id="orderForm" action="/order/payment"
						method="post">
						<!-- 체크박스 전체 여부 -->
						<div class="all_check_input_div">
							<input type="checkbox" class="all_check_input input_size_20"
								checked="checked" style="zoom:2.0;"><span class="all_chcek_span" style="font-size: 20px;"> 전체선택</span>
						</div>
						<table class="subject_table"
							style=" width: 1200px; height: 250px; text-align: center;">
							<%-- <caption>상품 제목 부분</caption> --%>
							<thead>
								<tr style="font-size: 20px;">
									<th class="td_width_1">선택</th>
									<th class="td_width_2">상품이미지</th>
									<th class="td_width_3">상품명</th>
									<th class="td_width_4">사이즈</th>
									<th class="td_width_4">가격</th>
									<th class="td_width_4">수량</th>
									<th class="td_width_4">삭제</th>
								</tr>
							</thead>
							<tbody>
								<c:set var="totalPrice" value="0" />
								<c:set var="totalDiscountPrice" value="0" />

								<c:forEach items="${cartInfo}" var="ci" varStatus="st">
									<c:set var="totalPrice"
										value="${totalPrice + ci.productPrice * ci.productCount}" />
									<c:set var="totalDiscountPrice"
										value="${totalDiscountPrice + ci.discountedPrice * ci.productCount}" />
									<tr id="itemRow${st.count}">
										<td class="td_width_1 cart_info_td"><input
											type="checkbox"
											class="individual_cart_checkbox input_size_20" name="check"
											checked="checked" value="${st.count}"
											data-cartNum="${ci.cartIndex}"
											style="zoom:2.0;"> <input type="hidden"
											class="individual_cart_checkbox input_size_20"
											name="cartIndex${st.count}" value="${ci.cartIndex}">
											<input type="hidden" class="individual_productPrice_input"
											name="productPrice${st.count}" value="${ci.productPrice}">
											<input type="hidden" class="individual_productCount_input"
											name="productCount${st.count}" id="productCount"
											value="${ci.productCount}"> <input type="hidden"
											class="individual_discountedPrice_input"
											name="discounted${st.count} " value="${ci.discountedPrice}">
											<input type="hidden" class="individual_productIndex_input"
											name="productIndex${st.count}" value="${ci.productIndex}">
											<input type="hidden" class="individual_productName_input"
											name="productName${st.count}" value="${ci.productName}">
											<input type="hidden" class="individual_productIndex_input"
											name="productThumbImage${st.count}"
											value="${ci.productThumbImage}"> <input type="hidden"
											class="individual_productOptionIndex_input"
											name="productOptionIndex${st.count}"
											value="${ci.productOptionIndex}"> <input
											type="hidden" class="individual_productOptionIndex_input"
											name="productOptionValue${st.count}"
											value="${ci.productOptionValue}"></td>
										<td class="td_width_2">
											<%-- <div class="image_wrap" data-productname="${ci.productThumbImage}" data-path="${ci.productThumbImage.uploadPath}" data-uuid="${ci.productThumbImage.uuid}" data-filename="${ci.productThumbImage.fileName}"> --%>
											<img src="${ci.productThumbImage}"
											style="width: 300px; height: 250px;" alt="상품 이미지">
										</td>
										<td class="td_width_3">${ci.productName}</td>
										<td class="td_width_3">${ci.productOptionValue}</td>
										<td class="td_width_4 price_td"><del>
												정가 :
												<fmt:formatNumber value="${ci.productPrice}"
													pattern="#,### 원" />
											</del> <br> 판매가 : <span class="red_color"><fmt:formatNumber
													value="${ci.discountedPrice}" pattern="#,### 원" /></span><br>
										</td>
										<td class="td_width_4 table_text_align_center">
											<div class="table_text_align_center quantity_div">
												<input type="text" value="${ci.productCount}"
													class="quantity_input" size="3">
												<button type="button" id="${st.count}"
													class="quantity_btn plus_btn">+</button>
												<button type="button" id="${st.count}"
													class="quantity_btn minus_btn">-</button>
											</div>
										</td>
										<%-- <td class="td_width_4 table_text_align_center">
                                    <fmt:formatNumber value="${ci.salePrice * ci.productCount}" pattern="#,### 원" />
                                </td> --%>
										<td class="td_width_4 table_text_align_center">

											<div class="checkBox">
												<input type="hidden" name="cartIndex${st.count}"
													value="${ci.cartIndex}">
												<script>
                                            $(".ckBox").click(function (){
                                                $("allCheck").prop("checked", false);
                                            });
                                        </script>
											</div>
											<div class="delete_btn">
												<button type="button"
													class="selectDelete_btn${ci.cartIndex}"
													data-cartNum="${ci.cartIndex}">삭제</button>
												<script>
                                            $(".selectDelete_btn${ci.cartIndex}").on("click", function() {
                                                var confirm_val = confirm("정말 삭제하시겠습니까?");
                                                const cartIndex = $(this).data("cartNum");
                                                if(confirm_val){
                                                    var checkArr = new Array();

                                                    $("input[name='check']:checked").each(function () {
                                                        checkArr.push($(this).attr("data-cartNum"));
                                                    });
                                                    $.ajax({
                                                        url : "/cart/delete",
                                                        type : "get",
                                                        data : { check : checkArr},
                                                        success : function (result){
                                                            console.log("result"+ result);
                                                            if(result == '1'){
                                                                location.href = "/cart/main/${loginUser.userIndex}";

                                                            }else{
                                                                alert("실패");
                                                            }
                                                        }

                                                    });
                                                }
                                            });

                                        </script>
											</div>

										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<br /> <br /> <input type="hidden" value="${totalDiscountPrice}"
							name="totalDiscountPrice" /> <br />
						<textarea cols="30" rows="5"
							style="font-size: 15px; text-align: start;" type="text"
							class="individual_order_message_input" name="orderMessage">shipping Message</textarea>
						<br />
						<button type="submit">구매하기</button>

					</form>


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
											<td><span class="totalPrice_span">${totalPrice}</span>
												원</td>
										</tr>
										<tr>
											<td>총 주문 상품수</td>
											<td> <span class="totalCount_span">${cartInfo.size()}</span> </td>
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
												<td><strong>총 결제 예상 금액</strong></td>
												<td><span class="finalTotalPrice_span"> ${totalDiscountPrice}</span>
													원</td>
											</tr>
										</tbody>
									</table>
								</td>
							</tr>
						</table>
					</div>
				</div>
				<!-- 구매 버튼 영역 -->
				<%--

                <!-- 수량 조정 form -->
                <form action="/cart/update" method="post" class="quantity_update_form">
                    <input type="hidden" name="cartIndex" class="update_cartIndex">
                    <input type="hidden" name="productCount" class="update_productCount">
                    <input type="hidden" name="userIndex" value="${loginUser.userIndex}">
                </form>

                <!-- 삭제 form -->
                <form action="/cart/devare" method="post" class="quantity_devare_form">
                    <input type="hidden" name="cartIndex" class="devare_cartIndex">
                    <input type="hidden" name="userIndex" value="${loginUser.userIndex}">
                </form>
                <!-- 주문 form -->
                <form action="/order/${loginUser.userIndex}" method="get" class="order_form">e
                <form action="/order/${loginUser.userIndex}" method="get" class="order_form">e
                </form>
        --%>

			</div>
		</div>
	</div>
	</div>
	<%@include file="../include/footer.jsp"%>
	<script>

    // 체크 박스에서 체크된 정보만 넘기기기
    function goOrder() {
        // 1. 장바구니에 담긴 상품이 없는 경우
        var chk = $('input[name="orderIndex"]')
        if (chk.length == 0) {
            return;
        }
        // 2. 담긴 상품이 있다면 체크박스 갯수 만큼 반복문 돌면서 체크한 상품과 체크 안된 상품을 구분하여,
        // 체크 안된상품은 서버에 넘어가지 않도록 disable하도록 한다.
        var cnt = 0;
        $.each(chk, function (i, ch) {
            if ($(ch).is(":checked")) {
                cnt++;
                $('#productCount' + (i + 1)).prop('disabled', false); // 비활성화
            } else {
                // 체크 안된 상품의 주문 수량  disable 활성화
                $('#productCount' + (i + 1)).prop('disabled', true); // 활성화
            }
        });

        if (cnt == 0) {
            alert('주문할 수량을 체크하세요');
            $('input[name="productCount"]').prop('disabled', false); // 비활성화
            return;
        }
        orderForm.submit();
    }


    $(document).ready(function () {

        /* 종합 정보 섹션 정보 삽입 */
        setTotalInfo();

    });
    /* 체크여부에따른 종합 정보 변화 */
    $(".individual_cart_checkbox").on("change", function () {
        /* 총 주문 정보 세팅(총 가격, 물품 수, 종류) */
        setTotalInfo($(".cart_info_td"));
    });

    /* 체크박스 전체 선택 */
    $(".all_check_input").on("click", function () {

        /* 체크박스 체크/해제 */
        if ($(".all_check_input").prop("checked")) {
            $(".individual_cart_checkbox").attr("checked", true);
        } else {
            $(".individual_cart_checkbox").attr("checked", false);
        }
        /* 총 주문 정보 세팅(총 가격, 물품 수, 종류) */
        setTotalInfo();

    });

    /* 총 주문 정보 세팅(총 가격, 물품 수, 종류) */
    function setTotalInfo() {
    	var sum = 0;
        var discountSum = 0;
		var count=0;
    	//.is(":checked") === true
    	var checks=$("input[name='check']");
        <c:forEach items="${cartInfo}" var="ci" varStatus="st">
        var checked=checks.eq('${st.count-1}').is(':checked');
        if(checked)
        	{
        	console.log(checked);
            sum += ${ci.productPrice} * $('[name=productCount' + ${st.count} + ']').val();
            discountSum += ${ci.discountedPrice} * $('[name=productCount' + ${st.count} + ']').val();
            count+=$('[name=productCount' + ${st.count} + ']').val()*1;
            console.log(discountSum);
        	}
        console.log(checked);
        </c:forEach>

        $(".totalPrice_span").text(sum);
        $(".finalTotalPrice_span").text(discountSum);
        $('[name=totalDiscountPrice]').val(discountSum);	
        $(".totalCount_span").text(count);

    }
	$('input[name=check]').on("click",function(){
		setTotalInfo();
	})
	
    /* 수량버튼 */
    $(".plus_btn").on("click", function () {
        var quantity = $(this).parent("div").find("input").val();
        $(this).parent("div").find("input").val(++quantity);
        var count=$(this).attr('id');
        $('[name=productCount' + count + ']').val(quantity);

        setTotalInfo();

    });

    $(".minus_btn").on("click", function () {
        var quantity = $(this).parent("div").find("input").val();
        if (quantity > 1) {
            $(this).parent("div").find("input").val(--quantity);
            var count=$(this).attr('id');
            $('[name=productCount' + count + ']').val(quantity);
        }
        setTotalInfo();
    });

    /* 바뀐 수량에 따라 결재 금액 변경 */

    // 장바구니 삭제 버튼

    /* 주문 페이지 이동 */
    $(".order_btn").on("click", function () {

        var form_contents = '';
        var orderIndex = 0;

        $(".cart_info_td").each(function (index, element) {

            if ($(element).find(".individual_cart_checkbox").is(":checked") === true) {	//체크여부

                var productIndex = $(element).find(".individual_productIndex_input").val();
                var productCount = $(element).find(".individual_productCount_input").val();

                var productIndex_input = "<input name='orders[" + orderIndex + "].productIndex' type='hidden' value='" + productIndex + "'>";
                form_contents += productIndex_input;

                var productCount_input = "<input name='orders[" + orderIndex + "].productCount' type='hidden' value='" + productCount + "'>";
                form_contents += productCount_input;

                orderNumber += 1;

            }
        });
        $(".orderForm").html(form_contents);
        $(".orderForm").submit();

    });

</script>

</body>
</html>