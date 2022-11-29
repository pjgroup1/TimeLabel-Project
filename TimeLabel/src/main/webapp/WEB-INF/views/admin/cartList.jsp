<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
  <title>Title</title>
  <style>
    .input_area{margin: 10px 0;}
    select{width: 100px;}
    label{display: inline-block; width: 70px; padding: 5px;}
    label[for='productInfo'] {display:block;}
    input{width: 150px;}
    textarea#productInfo{width: 400px; height: 180px;}

    .originImage{width: 500px; height: auto;}
    .thumbImage{}
  </style>
</head>
<body>
<div id="root">
  <header id ="header">
    <div id="header_box">
      <%@include file="../include/header.jsp"%>
    </div>
  </header>

  <nav id="nav">
    <div id ="nav_box">
      <%@ include file="../include/nav.jsp"%>
    </div>
  </nav>

  <aside>
    <div id="aside_box">
      <%@include file="../include/aside.jsp"%>
    </div>
  </aside>

  <div id="container_box">
    <h2>상품 등록</h2>
  </div>

  <form role="from" method="post" autocapitalize="off">
    <div class="inputArea">
      <label>카테고리</label>
      <select class="category">
        <option value="">전체</option>
      </select>
    </div>

    <div class="inputArea">
      <label for="productName">상품명</label>
      <span>${product.productName}</span>
    </div>
    <div class="inputArea">
      <label for="productPrice">상품가격</label>
      <span><fmt:formatNumber value="${product.productPrice}" pattern="###.###.###" /></span>
    </div>
    <div class="inputArea">
      <label for="productQuantity">상품수량</label>
      <span>${product.productQuantity}</span>
    </div>
    <div class="inputArea">
      <label for="productInfo">상품소개</label>
      <span>${product.productInfo}</span>
    </div>
    <div class="inputArea">
      <label for="productMainImage">상품메인이미지</label>
      <p>원본 이미지</p>
      <img src="${product.productMainImage}" class="originImage"/>

      <p>썸네일 이미지</p>
      <img src="${product.productThumbImage}" class="thumbImage"/>
    </div>
    <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
      <div class="text-center">
        <a class="btn btn-outline-dark mt-auto" href="/admin/modify?productIndex=${product.productIndex}">수정
        </a>
      </div>
    </div>
    <div class="inputArea">
      <%--  <button type="button" id="upload_Btn" class="btn btn-warning">수정</button>--%>
      <button type="button" id="delete_Btn" calss="btn btn-danger">삭제</button>
    </div>
  </form>

  <footer id="footer">
    <div id="footer_box">
      <%@ include file="../include/footer.jsp"%>
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
  for(var i = 0; i < jsonDate.length; i++){
    if(jsonDate[i].next()){
      categoryObject = new Object; // 초기화
      categoryObject.productCategoryIndex = jsonDate[i].productCategoryIndex;
      categoryObject.productCategoryName = jsonDate[i].productCategoryName;
      // 위에 값들을 저장후 리스트에 저장
      categoryArr.push(categoryObject);
    }
  }
  var categorySelect = $("select.category")

  for(var i=0; i<categoryArr.length; i++){
    categorySelect.append("<option value='" + categoryArr[i].productCategoryIndex + "'>"
            + categoryArr[i].productCategoryName + "</option>")
  }
</script>
</body>
</html>



