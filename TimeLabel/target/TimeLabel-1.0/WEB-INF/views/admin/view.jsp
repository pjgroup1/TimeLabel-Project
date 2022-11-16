
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>Title</title>
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
        <%--<h2>상품 목록</h2>--%>

        <table>
            <thead>
            <tr>
                <th>상품 번호</th>
                <th>상품 이름</th>
                <th>상품 카테고리 번호</th>
                <th>가격</th>
                <th>수량</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${list}" var="list">
                <tr>
                    <td>${list.productIndex}</td>
                    <td>
                        <a href="/admin/product/view=?n=${list.productIndex}">${list.productName}</a>
                        <!-- 상품번호를 통해 상품 조회 -->
                    </td>
                    <td>${list.productCategoryIndex}</td>
                    <td>
                        <fmt:formatNumber value="${list.productPrice}" pattern="###.###.###"/>
                    </td>
                    <td>${list.productQuantity}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <footer id="footer">
        <div id="footer_box">
            <%@ include file="../include/footer.jsp"%>
        </div>
    </footer>
</div>

</body>
</html>
