<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="member" scope="session" class="com.nhnent.edu.spring_mvc.domain.Member" />

<!doctype html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>회원 목록</title>
</head>
<body>
<jsp:include page="../fragments/login_info.jsp" />
<h1>회원 목록</h1>

<c:forEach var="member" items="${members}">
    <a href="/member/detail/${member.id}">${member.id}</a>,
    <a href="/member/detail?id=${member.id}">*****</a>
    <br />
</c:forEach>
</body>
</html>
