<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        li {
            list-style: none;
        }
    </style>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet"/>
    <link href="../resources/css/styles.css" rel="stylesheet"/> <!-- 테이블 관련 css -->
</head>
<body>
<div id="root">
    <header id="header">
        <div id="header_box">
            <%@include file="../include/header.jsp" %>
        </div>
    </header>


    <div id="container_box">
        <h2>상품 리스트</h2>
    </div>
    </section>

    <div class="">
        <c:forEach var="item" items="${list}">
            <form action="/admin/delete/${item.productIndex}" method="post">
                <div style="display:inline;" class="container px-4 px-lg-5 mt-5">
                    <table style="width: 330px; height: 100px; border-collapse: collapse; border-spacing: 10px; margin:10px"
                           border="1">
                        <tbody>
                        <tr>
                            <td>
                                <img src="${item.productThumbImage}" style="width: 100px; height: 100px;">
                            </td>
                            <td style="width: 230px;">
                                <li>상품번호 : ${item.productIndex}</li>
                                <li>상품명 : <a href="/ProductPage/${item.productIndex}">${item.productName}</a></li>
                                <li>상품금액 : ${item.productPrice}</li>
                                <li>상품날짜 : ${item.productDate}</li>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <button type="submit" onclick="return deleteCheck()">제품삭제</button>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                    <table>
                    </table>
                </div>
            </form>
        </c:forEach>
    </div>

    <footer id="footer">
        <div id="footer_box">
            <%@ include file="../include/footer.jsp" %>
        </div>
    </footer>
</div>
<script>
    /* 컨트롤러에서 데이터 받기 */
    var jsonDate = JSON.parse('${category}'); /* 쌍따움표 사용시 에러 발생!! */
    console.log(jsonDate);
    // 리스트 생성
    var categoryArr = new Array();
    // Object 모든 타입을 담아 둘수있음
    var categoryObject = new Object();

    /* 카테고리 셀렉트 박스에 데이터 넣기 */
    for (var i = 0; i < jsonDate.length; i++) {
        if (jsonDate[i].next()) {
            categoryObject = new Object; // 초기화
            categoryObject.productCategoryIndex = jsonDate[i].productCategoryIndex;
            categoryObject.productCategoryName = jsonDate[i].productCategoryName;
            // 위에 값들을 저장후 리스트에 저장
            categoryArr.push(categoryObject);
        }
    }
    var categorySelect = $("select.category")

    for (var i = 0; i < categoryArr.length; i++) {
        categorySelect.append("<option value='" + categoryArr[i].productCategoryIndex + "'>"
            + categoryArr[i].productCategoryName + "</option>")
    }

    function deleteCheck() {
        if (confirm("정말 삭제하시겠습니까?") == true) {
            return true;
        } else {
            return false;

        }

    }
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>



