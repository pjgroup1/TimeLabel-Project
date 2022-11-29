<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>

    <!-- 합쳐지고 최소화된 최신 CSS -->
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">

    <!-- 부가적인 테마 -->
    <link rel="stylesheet" href="/resources/css/bootstrap-theme.min.css">


    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="${path}/resources/img/favicon.png" />
    <!-- Bootstrap icons-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="../resources/css/styles.css" rel="stylesheet" />
    <!-- 합쳐지고 최소화된 최신 자바스크립트 -->
    <script src="/resources/js/bootstrap.min.js"></script>

    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="/resources/js/common.js" charset="utf-8"></script>

    <!-- 주소검색 API(카카오) -->
    <script
            src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <style>
        a {
            text-decoration: none;
            color: #666;
            text-decoration: none
        }

        h1 {
            text-align: center;
            padding: 50px 0;
            font-weight: normal;
            font-size: 2em;
            letter-spacing: 10px;
        }

        .itemTable {
            width: 70%;
            margin: 10px;
            border-top: 1px solid #6c757d;
        }

        th, td {
            margin: 10px;
            padding: 10px;
            border-bottom: 1px solid #6c757d;
        }
        table{
            width: 840px;
        }
    </style>
</head>
<%@ include file="../include/header.jsp"%>

<div class="container">

    <div
            style="width: 1140px; height: 50px; margin: 10px; padding: 12px; border: 1px solid #dcdcdc">
        <table>
            <tr>
                <td style="text-align: center; font-size: 17px; font-weight: bold;">주문작성/결제</td>
            </tr>
        </table>
    </div>
    <c:if test="${cartList.get(0).cartIndex == null}">
        <form method="post" action="/order/add">
    </c:if>
    <c:if test="${cartList.get(0).cartIndex != null}">
        <form id="orderForm" method="post" action="/order/add">
    </c:if>

    <div class="table-responsive">
        <p>
            <b>주문작성/결제</b>
        </p>
        <table class="itemTable">
            <colgroup>
                <col width="10"/>
                <col width="*"/>
                <col width="20%"/>
                <col width="20%"/>
            </colgroup>
            <thead>
            <tr>
                <th colspan="2" style="text-align: center">상품명/옵션</th>
                <th colspan="1" style="text-align:center">수량</th>
                <th style="text-align: center">주문금액</th>
            </tr>
            </thead>
            <input type="hidden" name="cartListSize" value="${cartList.size()}">

            <c:forEach var="item" items="${cartList}" varStatus="st">
                <tbody>
                <input type="hidden" value="${loginUser.userIndex}" name="userIndex"/>
                <c:if test="${item.cartIndex != null}">
                    <input type="hidden" value="${item.cartIndex}" name="cartIndex${st.count}"/>
                </c:if>
                <input type="hidden" value="${item.productIndex}" name="productIndex${st.count}"/>
                <input type="hidden" class="individual_discountedPrice_input"
                       name="discounted${st.count} " value="${item.discountedPrice}">
                <input type="hidden" class="individual_productName_input" name="productName${st.count}"
                       value="${item.productName}">
                <input type="hidden" class="individual_productIndex_input"
                       name="productThumbImage${st.count}" value="${item.productThumbImage}">
                <input type="hidden" class="individual_productOptionIndex_input"
                       name="productOptionIndex${st.count}" value="${item.productOptionIndex}">
                <tr>
                    <td><img src="${item.productThumbImage}" width="100px" height="100px"></td>
                    <td style="text-align: center"><a href="/ProductPage/${item.productIndex}">${item.productName} <br/>
                        <input type="text"
                               value="${item.productOptionValue}"
                               style="width: 60px; text-align: center; border: none;"
                               readonly>
                    </a>
                        <input type="hidden" name="productIndex" value="${item.productIndex}" readonly/>
                    </td>
                    <td style="text-align: center"><input type="text"
                                                          name="productCount${st.count}" value="${item.productCount}"
                                                          style="width: 25px; font-size: 15px; text-align: right; border: none;"
                                                          readonly>개
                    </td>
                    <td style="text-align: center"><input type="text"
                                                          name="productPrice${st.count}" value="${item.productPrice}"
                                                          style="width: 60px; font-size: 15px; text-align: right; border: none;"
                                                          readonly>원
                    </td>
                </tr>
                </tbody>
            </c:forEach>

        </table>
    </div>
    <br>
    <br>

    <div class="table-responsive">
        <table class="table table-striped" >
            <colgroup>
                <col width="11%"/>
                <col width="22%"/>
                <col width="11%"/>
                <col width="22%"/>
                <col width="12%"/>
                <col width="22%"/>
            </colgroup>
            <tr>
                <td>주문금액</td>
                <td style="text-align: right">
                    <input type="text"
                           name="ORDER_TOTAL_ORDER_PRICE" value="${totalDiscountPrice}"
                           style="width: 100px; text-align: right; border: none;"
                           readonly>원
                </td>
            </tr>
            <tr rowspan="3">
                <td></td>
                <td></td>
            </tr>
            <tr rowspan="3">
                <td>선결제배송비</td>
                <td colspan="3"><input type="text" id="ORDER_FEE"
                                       name="ORDER_FEE" value="무료"
                                       style="width: 100px; text-align: right; border: none;" readonly>
                </td>
                <td></td>
                <td></td>
            </tr>
        </table>
    </div>

    <br>
    <br>
    <div class="table-responsive">
        <p>
            <b>받으시는분(상품받으실분)</b> &nbsp;
        </p>
        <table class="table table-striped">
            <colgroup>
                <col width="15%"/>
                <col width="*"/>
            </colgroup>
            <tbody>
            <tr>
                <td>이름</td>
                <td style="text-align: left"><input type="text" name="name"
                                                    id="ORDER_NAME" readonly value="${loginUser.userName}"
                                                    style="width: 100px;">
                </td>
            </tr>
            <tr>
                <td>휴대폰번호</td>
                <td style="text-align: left"><input type="text"
                                                    name="mobile" id="ORDER_PHONE" readonly
                                                    value="${loginUser.userMobile}"
                                                    style="width: 120px;"></td>
            </tr>
            <tr>
                <td rowspan="3">주소</td>
                <td style="text-align: left"><input type="text"
                                                    name="postcode" id="ORDER_ZIPCODE" value="${loginUser.userZip}"
                                                    style="width: 80px;" readonly>
                    <%--     <button type="button" id="findAddrBtn" onclick="findAddr()">우편번호
                             찾기
                         </button>--%>
                </td>
            </tr>
            <tr>
                <td style="text-align: left"><input type="text"
                                                    name="address" id="ORDER_ADDR1" value="${loginUser.userAddress}"
                                                    style="width: 400px;"></td>
            </tr>
            <tr>
                <td style="text-align: left"><input type="text"
                                                    name="addressdetail" id="ORDER_ADDR2"
                                                    value="${loginUser.userAddressDetail}" style="width: 400px;">
                </td>
            </tr>
            </tbody>
        </table>
    </div>
    <br>
    <br>

    <div class="table-responsive">
        <label><strong>배송메세지</strong></label><br/><br/>
        <input type="text" value="${orderMessage}" name="orderMessage"/>
        <br/>
        <table class="table table-striped">
            <colgroup>
                <col width="20%"/>
                <col width="80%"/>
            </colgroup>
            <tbody>
            <tr>
                <td>총 결제금액</td>
                <td style="text-align: left"><input type="text"
                                                    name="totalDiscountPrice" id="ORDER_TOTAL_PAY_PRICE"
                                                    value="${totalDiscountPrice}" style="width: 100px;" readonly>원
                </td>
            </tr>
            <tr>
            </tr>
            <tr>
            </tr>
            <tr>
            </tr>
            </tbody>
        </table>
    </div>
    <br>
    <div style="text-align: center">
        <!-- <input type="checkbox" name="orderChk" id="orderChk">
        (필수)결제서비스 약관에 동의하며, 원활한 배송을 위한 개인정보 제공에 동의합니다. <br> <br>  -->
        <input type="button" name="all_order" value="장바구니목록"
               onClick="location.href='/cart'">
        <input type="button" name="order_pay" onclick="requestPay()" name="order_pay" value="결제진행">
    </div>

    </form>
</div>
<!-- iamport.payment.js -->
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
<script>
    // var IMP = window.IMP; // 생략 가능
    <%--var Name = "<c:out value='${item.productName}'/>";--%>
    <%--var Price = "<c:out value='${item.productPrice}'/>";--%>
    var Name = '${loginUser.userName}'; // js에서 el 사용법
    // var Price = '${fn:length(item)}';
    IMP.init('imp80445812'); //iamport 대신 자신의 "가맹점 식별코드"를 사용

    function requestPay() {
        IMP.request_pay({
            pg: "kakaopay",
            pay_method: "kpay",
            merchant_uid: "ORD20180131-0000013",
            // name: $(".individual_productName_input").val(),
            name: Name,
            amount: 10000,
            // name: "king",
            // amount: 10000,
            buyer_email: "gildong@gmail.com",
            buyer_name: "홍길동",
            buyer_tel: "010-4242-4242",
            buyer_addr: "서울특별시 강남구 신사동",
            buyer_postcode: "01181"
        }, function (rsp) { // callback
            if (rsp.success) {
                alert("결제 완료, 마이페이지로 이동합니다.");
                $('#orderForm').submit();
                // 결제 성공 시 로직,
            } else {
                console.log(Name);
                console.log(rsp)
                alert("결제 실패");
                // 결제 실패 시 로직,
            }
        });
    }
</script>
<%@ include file="../include/footer.jsp"%>
</body>
</html>