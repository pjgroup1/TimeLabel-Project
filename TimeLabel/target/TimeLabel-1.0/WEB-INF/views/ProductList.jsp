<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="path" value="${pageContext.request.contextPath}" />

<%-- <%@ page session="false" %> --%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<%--    <meta name="description" content="" />--%>
<%--    <meta name="author" content="" />--%>

<title>Test</title>
<!-- Favicon-->
<%-- <link rel="icon" type="image/x-icon" href="${path}/resources/img/favicon.png" /> --%>
<!-- Bootstrap icons-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="../resources/css/styles.css" rel="stylesheet" />
</head>
<body>
	<!-- Navigation-->
	<!-- 최상단 메뉴 구성 시작 -->
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container px-4 px-lg-5">

			<!-- 브랜드 타이틀(기능: home으로 이동) -->
			<a class="navbar-brand" href="/">Shop in TL</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">

					<!-- 메뉴 home(기능: home으로 이동) -->
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="/">Home</a></li>
					<!-- 메뉴 Login(기능: 쇼핑몰 login페이지로 이동) -->
					<li class="nav-item"><a class="nav-link" href="/login">Login</a></li>

					<!-- 드랍다운 메뉴(기능: 쇼핑몰 아이템 리스트 메뉴 보여주기 -->
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" id="navbarDropdown" href="#"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">Shop</a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
							<li><a class="dropdown-item" href="/ProductsAll">전체상품</a></li>

							<!-- 메뉴안에서 구분선 -->
							<li><hr class="dropdown-divider" /></li>

							<li><a class="dropdown-item" href="/TopProducts">Top</a></li>
							<li><a class="dropdown-item" href="/BottomProducts">Bottom</a></li>
							<li><a class="dropdown-item" href="/ShoesProducts">Shoes</a></li>
						</ul></li>
					<!-- 드랍다운 메뉴(기능: 쇼핑몰 아이템 리스트 메뉴 보여주기 -->
				</ul>
				<form class="d-flex">
					<button class="btn btn-outline-dark" type="submit">
						<i class="bi-cart-fill me-1"></i> 장바구니 <span
							class="badge bg-dark text-white ms-1 rounded-pill">0</span>
					</button>
				</form>
			</div>
		</div>
	</nav>
	<!-- 최상단 메뉴 구성 끝 -->
	<!-- 메인 타이틀 간판 시작 -->
	<header class="bg-dark py-3">
		<div class="container px-4 px-lg-5 my-5">
			<div class="text-center text-white">
				<h1 class="display-4 fw-bolder">Daily Shop</h1>
				<p class="lead fw-normal text-white-50 mb-0">With this shop
					homepage</p>
			</div>
		</div>
	</header>
	<!-- 메인 타이틀 간판 끝 -->
	<!-- 상품 Section-->
	<section class="bg-primary py-5">
		<div class="container px-4 px-lg-5 mt-5">
			<div
				class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
				<c:forEach var="item" items="${itemlist}">
					<div class="col mb-5">
						<div class="card h-100">
							<!-- Product image-->
							<%-- <img src="${path}/resources/img/top_01.jpg"> --%>
							<img src="${item.productThumbImage}">
							<!--                    <img class="card-img-top" src="img/top_01.jpg" href="#" /> &lt;!&ndash;alt="..."&ndash;&gt;-->
							<!-- Product details-->
							<div class="card-body p-4">
								<div class="text-center">
									<!-- Product name-->
									<h5 class="fw-bolder">${item.productName}</h5>
									<!-- Product price-->
									${item.productPrice}₩
								</div>
							</div>
							<!-- Product actions-->
							<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
								<div class="text-center">
									<a class="btn btn-outline-dark mt-auto" href="/ProductPage/productIndex=${item.productIndex}">View
										</a>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
				<%-- <div class="col mb-5">
					<div class="card h-100">
						<!-- Sale badge-->
						<div class="badge bg-dark text-white position-absolute"
							style="top: 0.5rem; right: 0.5rem">Sale</div>
						<!-- Product image-->
						<img class="card-img-top" src="${path}/resources/img/top_02.jpg" alt="..." />
						<!-- Product details-->
						<div class="card-body p-4">
							<div class="text-center">
								<!-- Product name-->
								<h5 class="fw-bolder">회색 후드티</h5>
								<!-- Product reviews-->
								<div
									class="d-flex justify-content-center small text-warning mb-2">
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
								</div>
								<!-- Product price-->
								<span class="text-muted text-decoration-line-through">90,000원</span>
								70,000원
							</div>
						</div>
						<!-- Product actions-->
						<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
							<div class="text-center">
								<a class="btn btn-outline-dark mt-auto" href="#">Add to cart</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col mb-5">
					<div class="card h-100">
						Sale badge
						<div class="badge bg-dark text-white position-absolute"
							style="top: 0.5rem; right: 0.5rem">Sale</div>
						Product image
						<img class="card-img-top"
							src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
						Product details
						<div class="card-body p-4">
							<div class="text-center">
								Product name
								<h5 class="fw-bolder">Sale Item</h5>
								Product price
								<span class="text-muted text-decoration-line-through">$50.00</span>
								$25.00
							</div>
						</div>
						Product actions
						<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
							<div class="text-center">
								<a class="btn btn-outline-dark mt-auto" href="#">Add to cart</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col mb-5">
					<div class="card h-100">
						Product image
						<img class="card-img-top"
							src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
						Product details
						<div class="card-body p-4">
							<div class="text-center">
								Product name
								<h5 class="fw-bolder">Popular Item</h5>
								Product reviews
								<div
									class="d-flex justify-content-center small text-warning mb-2">
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
								</div>
								Product price
								$40.00
							</div>
						</div>
						Product actions
						<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
							<div class="text-center">
								<a class="btn btn-outline-dark mt-auto" href="#">Add to cart</a>
							</div>
						</div>
					</div>
				</div> --%>
				<!--col mb -5 끝  -->
			</div>
		</div>
	</section>
	<!-- Footer-->
	<footer class="py-5 bg-dark">
		<div class="container">
			<p class="m-0 text-center text-white">Copyright &copy; Your
				Website 2022</p>
		</div>
	</footer>
	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<%-- <script src="${path}/resources/js/scripts.js"></script> --%>
</body>
</html>