<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%--@elvariable id="locale" type="java.lang.String"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>
        <fmt:setLocale value="${locale}" />
        <fmt:setBundle basename="i18n" var="lang"/>
        <fmt:message key="parse" bundle="${lang}"/>
    </title>
</head>
<body>
<div>
    <fmt:setLocale value="${locale}" />
    <fmt:setBundle basename="i18n" var="lang"/>
    <fmt:message key="enter" bundle="${lang}"/>
</div>
<form action="${pageContext.request.contextPath}/old" method="post">
        <textarea name="text" id="text" cols="100" rows="30"></textarea>
    <div>
        <button type="submit">
            <fmt:setLocale value="${locale}" />
            <fmt:setBundle basename="i18n" var="lang"/>
            <fmt:message key="parse" bundle="${lang}"/>
        </button>
    </div>
</form>
</body>
</html>
