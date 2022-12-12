<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <script src="https://code.jquery.com/jquery-3.4.1.js"
            integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
            crossorigin="anonymous"></script>
    <title>주문 상세</title>
    <style>
        li{
            list-style:none;
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

        /* 전체 배경화면 색상 */
        .wrapper_div{
            background-color: #f5f5f5;

        }

        /* 팝업창 제목 */
        .subject_div{

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
            margin-bottom: 20px;
        }
    </style>
    <!-- include -->
    <%@include file="../include/header.jsp" %>
</head>
<body>

<h1>OrderList</h1>
<div class="container">
    <div class="UserInfo">
        <h3>주문자 정보</h3>
        <label>이름 : </label>${loginUser.userName}<br/>
        <label>핸드폰번호 : </label>${loginUser.userMobile}<br/>
        <label>주소 : </label>${loginUser.userAddress}<br/>
        <label>상세주소 : </label>${loginUser.userAddressDetail}<br/>
    </div>
</div>
<br>
<br>
<div class="container">
    <div class="itemInfo">
        <c:forEach items="${orderDetails}" var="order">
            <div style="display:inline;" class="container px-4 px-lg-5 mt-5">
                <form action="../../review/enroll" id="review_form" target="reviewEnroll" onsubmit="window.open('../../review/enroll', 'reviewEnroll', 'width=500, height=300')" method="GET">
                    <table style="width: 330px; height: 100px; border-collapse: collapse; border-spacing: 10px; margin:10px" border="1" >
                        <tbody>
                        <tr>
                            <td>
                                <img src="${order.productThumbImage}" style="width: 100px; height: 100px;">
                            </td>
                            <td style="width: 230px;">
                                <ul>
                                    <li>상품명 : <a href="/ProductPage/${order.productIndex}">${order.productName}</a></li>
                                    <li>상품사이즈 : ${order.productOptionValue}</li>
                                    <li>상품 수량 : ${order.productCount}</li>
                                    <li>상품금액 : <fmt:formatNumber value="${order.productPrice}" pattern="#,###"/> 원</li>
                                    <li><button type="submit">리뷰쓰기</button></li>
                                </ul>
                                <input type="hidden" name="userIndex" value="${loginUser.userIndex}"></input>
                                <input type="hidden" name="productIndex" value="${order.productIndex}"></input>
                                <input type="hidden" name="productName" value="${order.productName}"></input>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </form>
            </div>
        </c:forEach>
    </div>
</div>
<!-- Footer-->
<%@include file="../include/footer.jsp" %>
</body>
</html>