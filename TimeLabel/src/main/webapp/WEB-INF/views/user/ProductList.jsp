<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath}" />

<%-- <%@ page session="false" %> --%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />

	<title>Test</title>
	<!-- Favicon-->
	<link rel="icon" type="image/x-icon" href="${path}/resources/img/favicon.png" />
	<!-- Bootstrap icons-->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
	<!-- Core theme CSS (includes Bootstrap)-->
	<link href="../resources/css/styles.css" rel="stylesheet" />

</head>
<body>
	<!-- include -->
	<%@include file="../include/header.jsp" %>
	<!-- 최상단 메뉴 구성 끝 -->
	<!-- 메인 타이틀 간판 시작 -->
	<header class="bg-white py-3">
		<div class="container px-4 px-lg-5 my-5">
			<div class="text-center text-black">
				<h1 class="display-4 fw-bolder">TimeLabel Shop</h1>
				<br>
				<iframe src="https://giphy.com/embed/dj8rKlfX7CAcP6Kish" width="480" height="146" frameBorder="0" class="giphy-embed" allowFullScreen></iframe>
			</div>
		</div>
	</header>
	<!-- 메인 타이틀 간판 끝 -->
	<!-- 상품 Section-->
	<section class="bg-white py-5">
		<div class="container px-4 px-lg-5 mt-5">
			<div
				class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
				<c:forEach var="item" items="${itemlist}">
					<div class="col mb-5">
						<div class="card h-100">
							<!-- Product image-->
							<%-- <img src="${path}/resources/img/top_01.jpg"> --%>
<%--							<img src="${item.productThumbImage}">--%>
							<img src="${item.productThumbImage}" width="auto" height=200px />
							<!--                    <img class="card-img-top" src="img/top_01.jpg" href="#" /> &lt;!&ndash;alt="..."&ndash;&gt;-->
							<!-- Product details-->
							<div class="card-body p-4">
								<div class="text-center">
									<!-- Product name-->
									<h5 class="fw-bolder">${item.productName}</h5>
									<!-- Product price-->
									<fmt:formatNumber value="${item.productPrice}" pattern="#,###" />₩
								</div>
							</div>
							<!-- Product actions-->
							<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
								<div class="text-center">
									<a class="btn btn-outline-dark mt-auto" href="/ProductPage/${item.productIndex}">View</a>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</section>
	<!-- Footer-->
	<%@include file="../include/footer.jsp" %>
	<!-- Bootstrap core JS-->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<%-- <script src="${path}/resources/js/scripts.js"></script> --%>
</body>
</html>