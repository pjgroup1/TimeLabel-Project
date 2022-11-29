<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>--%>
<!-- Navigation-->
<!-- header start -->
<!-- 최상단 메뉴 구성 시작 -->
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="${path}/resources/img/favicon.png" />
<!-- Bootstrap icons-->
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="/resources/css/styles.css" rel="stylesheet" />
<header>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container px-4 px-lg-5">

			<!-- 브랜드 타이틀(기능: home으로 이동) -->
			<a class="navbar-brand" href="/"><img
				src="/resources/image/Logo.png"></a>
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
					<li class="nav-item"><c:if test="${loginUser == null }">
							<a class="nav-link" href="../../user/login">Login</a>
						</c:if> <!-- 로그인 한 상태 --> <c:if test="${loginUser != null }">
							<a class="nav-link" href="../../user/logout">Logout</a>
						</c:if></li>
					<c:if test="${loginUser.userIndex != null}">
						<li>
							<a class="nav-link" href="../../order/list">orderList</a>
						</li>
						<li>
							<a class="nav-link" href="../../user/myPage">myPage</a>
						</li>
					</c:if>
					<!-- 드랍다운 메뉴(기능: 쇼핑몰 아이템 리스트 메뉴 보여주기 -->
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" id="navbarDropdown"
						href="/ProductList" role="button" data-bs-toggle="dropdown"
						aria-expanded="false">Products</a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
							<li><a class="dropdown-item" href="/ProductList">All
									Products</a></li>

							<!-- 메뉴안에서 구분선	 -->
							<li><hr class="dropdown-divider" /></li>

							<li><a class="dropdown-item" href="/ProductList?category=1">Top</a></li>
							<li><a class="dropdown-item" href="/ProductList?category=2">Bottom</a></li>
							<li><a class="dropdown-item" href="/ProductList?category=3">Shoes</a></li>
						</ul></li>
					<!-- 드랍다운 메뉴(기능: 쇼핑몰 아이템 리스트 메뉴 보여주기 -->

				</ul>
				<div class="login_area">
					<!-- 로그인한 상태 -->
					<c:if test="${loginUser != null }">
						<div class="login_success_area">
							<span>회원 : ${loginUser.userName}</span>
							<span>환영합니다</span>
						</div>
					</c:if>
				</div>
				<a href="/cart/main/${loginUser.userIndex}">
					<button class="btn btn-outline-dark" type="button">
						<i class="bi-cart-fill me-1"></i>
					</button>
				</a>
			</div>
		</div>
	</nav>
</header>
<!-- 최상단 메뉴 구성 끝 -->