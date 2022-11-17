
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul>
    <c:if test="${user == null}">
        <li>
            <a href="/user/login">로그인</a>
        </li>
        <li>
            <a href="/user/logout">회원가입</a>
        </li>
    </c:if>

    <c:if test="${user.userIndex == 1}">
        <li>
            <a href="/admin/main">관리자 화면</a>
        </li>
    </c:if>

    <c:if test="${user != null}">
        <li>
                ${user.userName}님 환영합니다.
        </li>
        <li>
            <a href="/user/logout">로그아웃</a>
        </li>
    </c:if>

</ul>


