<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>kubg Admin</title>

    <!-- <script src="/resources/jquery/jquery-3.6.0.min.js"></script> -->
    <!--   <script src="/resources/jquery/jquery-3.6.0.min.js"></script> -->
    <script src="/webjars/jquery/3.3.1/jquery.min.js"></script>

    <link rel="stylesheet" href="/webjars/bootstrap/5.2.0/css/bootstrap.min.css">
    <!-- <link rel="stylesheet" href="/webjars/bootstrap/5.2.0/css/bootstrap-theme.min.css"> -->
    <script src="/webjars/bootstrap/5.2.0/js/bootstrap.min.js"></script>

    <script src="/webjars/ckeditor/31.0.0/classic/ckeditor.js"></script>

    <style>
        body {
            font-family: '맑은 고딕', verdana;
            padding: 0;
            margin: 0;
        }

        ul {
            padding: 0;
            margin: 0;
            list-style: none;
        }

        div#root {
            width: 90%;
            margin: 0 auto;
        }

        header#header {
            font-size: 60px;
            padding: 20px 0;
        }

        header#header h1 a {
            color: #000;
            font-weight: bold;
        }

        nav#nav {
            padding: 10px;
            text-align: right;
        }

        nav#nav ul li {
            display: inline-block;
            margin-left: 10px;
        }

        section#container {
            padding: 20px 0;
            border-top: 2px solid #eee;
            border-bottom: 2px solid #eee;
        }

        section#container::after {
            content: "";
            display: block;
            clear: both;
        }

        aside {
            float: left;
            width: 200px;
        }

        div#container_box {
            float: right;
            width: calc(100% - 200px - 20px);
        }

        aside ul li {
            text-align: center;
            margin-bottom: 10px;
        }

        aside ul li a {
            display: block;
            width: 100%;
            padding: 10px 0;
        }

        aside ul li a:hover {
            background: #eee;
        }

        footer#footer {
            background: #f9f9f9;
            padding: 20px;
        }

        footer#footer ul li {
            display: inline-block;
            margin-right: 10px;
        }
    </style>


    <style>
        .inputArea {
            margin: 10px 0;
        }

        select {
            width: 100px;
        }

        label {
            display: inline-block;
            width: 70px;
            padding: 5px;
        }

        label[for='gdsDes'] {
            display: block;
        }

        input {
            width: 150px;
        }

        textarea#gdsDes {
            width: 400px;
            height: 180px;
        }

        .select_img img {
            margin: 20px 0;
        }

    </style>

</head>
<body>
<div id="root">
    <%--  <header id="header">--%>
    <%--    <div id="header_box">--%>
    <%--      <%@ include file="../include/header.jsp" %>--%>
    <%--    </div>--%>
    <%--  </header>--%>

    <%--  <nav id="nav">--%>
    <%--    <div id="nav_box">--%>
    <%--      <%@ include file="../include/nav.jsp" %>--%>
    <%--    </div>--%>
    <%--  </nav>--%>

    <section id="container">
        <%--    <aside>--%>
        <%--      <%@ include file="../include/aside.jsp" %>--%>
        <%--    </aside>--%>
        <div id="container_box">
            <h2>상품 등록</h2>

            <form role="form" method="post" autocomplete="off" enctype="multipart/form-data" action="/admin/modify/${productIndex}">

                <input type="hidden" name="productIndex" value="${product.productIndex}">
                <div class="inputArea">
                    카테고리 :  <label>${product.productCategoryName}</label>
                </div>

                <div class="inputArea">
                    <label for="productName">상품명</label>
                    <input type="text" id="productName" name="productName" value="${product.productName}"/>
                </div>

                <div class="inputArea">
                    <label for="productPrice">상품가격</label>
                    <input type="text" id="productPrice" name="productPrice" value="${product.productPrice}"/>
                </div>
                <div class="inputArea">
                    <label for="productInfo">상품소개</label>
                    <textarea rows="5" cols="50" id="productInfo" name="productInfo"
                              value="${product.productInfo}"></textarea>

                </div>


                <div class="inputArea">
                    <button type="submit" id="update_Btn" class="btn btn-primary">수정</button>
                    <button type="submit" id="back_Btn" class="btn btn-primary">취소</button>
                    <button type="submit" id="delete_Btn" class="btn btn-primary">삭제</button>

                    <script>
                        ${"#back_Btn"}.onclick(function ()
                        {
                            // history.back();
                            location.href = "/admin/view/${product.productIndex}"
                        });
                    </script>
                </div>
            </form>

        </div>
    </section>

    <footer id="footer">
        <div id="footer_box">
            <%@ include file="../include/footer.jsp" %>
        </div>
    </footer>

</div>

<script>

    ${"#delete_Btn"}.onclick(function () {
        var con = confirm("정말 삭제 하시겠습니까?")
        if (con) {
            fomObj.attributes()
        }
    });
    var regExp = /[^0-9]/gi;

    $("#gdsPrice").keyup(function () {
        numCheck($(this));
    });
    $("#gdsStock").keyup(function () {
        numCheck($(this));
    });

    function numCheck(selector) {
        var tempVal = selector.val();
        selector.val(tempVal.replace(regExp, ""));
    }

    var select_categoryIndex = '${product.productCategoryIndex}';
    var select_categoryName = '${product.productCategoryName}';

    if (select_categoryIndex != null && select_categoryIndex != '') {
        ${".category1"}.val(select_categoryIndex);
        ${".category1"}.children().remove();
        ${".category1"}.append("<option value='"
            + select_categoryIndex + "'>" + select_categoryName + "</option>");
    }
    else{
        ${".category1"}.val(select_categoryIndex);
    }
</script>
</body>
</html>