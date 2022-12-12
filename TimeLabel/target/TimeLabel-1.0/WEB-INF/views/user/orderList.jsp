<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-3.4.1.js"
            integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
            crossorigin="anonymous"></script>
</head>
<body>
<!-- include -->
<%@include file="../include/header.jsp" %>
<h1>OrderList</h1>
<c:if test="${loginUser.userIndex != 1}">
    <div class="container">
        <div class="UserInfo">
            <h3>주문자 정보</h3>
            <label>이름 : </label>${loginUser.userName}<br/>
            <label>핸드폰번호 : </label>${loginUser.userMobile}<br/>
            <label>주소 : </label>${loginUser.userAddress}<br/>
            <label>상세주소 : </label>${loginUser.userAddressDetail}<br/>
        </div>
    </div>
</c:if>

<br>
<br>
<div class="container">
    <div class="itemInfo">
        <c:forEach items="${orderList}" var="order" varStatus="st">
        <c:if test="${loginUser.userIndex == 1}">
        <table>
            </c:if>
            <c:if test="${loginUser.userIndex != 1}">
            <table onclick="location.href='/order/detail/${order.orderIndex}'">
                </c:if>

                <thead>
                <tr>
                    <th>주문 일자 :${order.orderDate} </th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>주문번호 : ${order.orderIndex}</td>
                </tr>
                <tr>
                    <td>

                        <c:if test="${loginUser.userIndex == 1}">
                            <form action="/order/orderStateChange" method="post"  onsubmit="return stateCheck()">
                                <input type="hidden" name="orderIndex" value="${order.orderIndex}" />
                                <select class="orderState" name="orderStateIndex" id="orderStateIndex">
                                    <option value="0">배송상태 변경</option>
                                </select>
                                <button type="submit">배송상태변경</button>
                            </form>
                        </c:if>

                    </td>
                </tr>
                <tr>
                    <td>주문상태 : ${order.orderStateInfo}</td>
                </tr>
                <tr>
                    <td>결제 금액 :<fmt:formatNumber value="${order.totalPrice}" pattern="#,###"/> 원</td>
                </tr>
                <tr>
                    <td>배송메시지 : ${order.orderMessage}</td>
                </tr>

                <c:if test="${loginUser.userIndex == 1 }">
                    <tr>
                        <td>
                            주문자 : ${order.userIndex}
                        </td>
                    </tr>
                </c:if>

                </tbody>
            </table>
            <br>

            </c:forEach>


    </div>
</div>
<script>
    // 컨트롤러에서 데이터를 받아옴
    var jsonDate = JSON.parse('${orderStateList}');

    for(var i=0; i<jsonDate.length; i++){
        console.log(jsonDate[i]);
    }

    // 배열과 오브젝트 변수를 만들고 값을 넣어줄것임
    var stateArr = new Array();
    var stateObj = new Object();

    // jsonDate 받아온 데이터를 셀렉트 박스안에 넣기
    console.log("jsonDate.length : " + jsonDate.length);

    for (var i = 0; i < jsonDate.length; i++) {
        stateObj = new Object();

        // stateObj에 stateIndex와 stateInfo저장
        stateObj.orderStateIndex = jsonDate[i].orderStateIndex;
        stateObj.orderStateInfo = jsonDate[i].orderStateInfo;

        console.log("jsonDate[i].orderStateIndex : " + jsonDate[i].orderStateIndex);
        console.log("jsonDate[i].orderStateInfo : " + jsonDate[i].orderStateInfo);
        // 배열에 값을 넣어줌
        stateArr.push(stateObj);

    }
    var orderStateSelect = $("select.orderState");
    console.log("orderState.select : " + orderStateSelect.length);
    // 배송 옵션 박스에 데이터를 저장
    for (var i = 0; i < stateArr.length; i++) {
        console.log("배송옵션 : " + stateArr[i].orderStateIndex);
        console.log("배송옵션 : " + stateArr[i].orderStateInfo);
        // stateArr에 저장된 값을 orderStateIndex에 저장

        orderStateSelect.append("<option value='" + stateArr[i].orderStateIndex + "'>"
            + stateArr[i].orderStateInfo + "</option>");
    }


    function  stateCheck() {
        var orderStateIndex = $("select.orderState").val();
        console.log("orderState : " + orderStateIndex);

        if(orderStateIndex == 0){
            alert("옵션을 선택해주세요");
            return false;
        }else{
            return true;
        }
    }
</script>
<!-- Footer-->
<%@include file="../include/footer.jsp" %>
</body>
</html>