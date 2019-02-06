<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>index</title>
</head>
<body>
    <!-- TODO : #4 locale을 참고하여 다국어가 지원되는 메세지. -->
    <h2><fmt:message key="hello_world" /><!--spring:message code="hello_world" /--></h2>

    <ul>
        <li><a href="?locale=ko">안녕?</a></li>
        <li><a href="?locale=en">hello?</a></li>
    </ul>
</body>
</html>
