<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet"/>
    <link href="../resources/css/styles.css" rel="stylesheet"/> <!-- 테이블 관련 css -->
    <style>
        .wrap {
            margin: 50px;
        }

        table {
            text-align: center;
            width: 1400px;
            height: 100px;
            border: 1px solid #444444;
            border-collapse: collapse;
            border: 0;
        }

        table th{
            text-align: center;
            border: 1px solid #aaa;
            background-clip: padding-box;
            scroll-snap-align: start;
            padding: 0.6rem;
            min-width: 6rem;
            text-align: left;
            margin: 0;
        }
        table td{
            text-align: center;
            border: 1px solid #aaa;
            background-clip: padding-box;
            scroll-snap-align: start;
            padding: 0.6rem;
            min-width: 6rem;
            text-align: left;
            margin: 0;
        }

        tbody tr:last-child th,
        tbody tr:last-child td {
            border-bottom: 0;
        }

        thead {
            z-index: 1000;
            position: relative;
        }

        thead th {
            position: sticky;
            top: 0;
            border-top: 0;
            background-clip: padding-box;
        }

        thead th.pin {
            left: 0;
            z-index: 1001;
            border-left: 0;
        }

        tbody {
            z-index: 10;
            position: relative;
        }

        tbody th {
            position: sticky;
            left: 0;
        }

        thead th,
        tbody th {
            background-color: #f8f8f8;
        }
    </style>
</head>
<body>
<header id="header">
    <div id="header_box">
        <%@include file="../include/header.jsp" %>
    </div>
</header>

<div class="wrap">

    <table>
        <thead>
        <tr>
            <th>아이디</th>
            <th>이름</th>
            <th>이메일</th>
            <th>전화번호</th>
            <th>주소</th>
            <th>주소2</th>
        </tr>
        </thead>
        <tbody style="border: 1px solid #ddd;">
        <c:forEach var="user" items="${userAllList}">
            <tr>
                <td>${user.userId}</td>
                <td>${user.userName}</td>
                <td>${user.userEmail}</td>
                <td>${user.userMobile}</td>
                <td>${user.userAddress}</td>
                <td>${user.userAddressDetail}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>


</div>


<footer id="footer">
    <div id="footer_box">
        <%@ include file="../include/footer.jsp" %>
    </div>
</footer>
</body>
</html>
