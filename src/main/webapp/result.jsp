<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--@elvariable id="foundWords" type="java.lang.String"--%>
<%--@elvariable id="locale" type="java.lang.String"--%>
<%--@elvariable id="text" type="com.epam.irasov.parser.entity.Text"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>
        <fmt:setLocale value="${locale}"/>
        <fmt:setBundle basename="i18n" var="lang"/>
        <fmt:message key="result.parsing" bundle="${lang}"/>
    </title>
</head>
<body>
    <div>
        <fmt:setLocale value="${locale}"/>
        <fmt:setBundle basename="i18n" var="lang"/>
        <fmt:message key="text.after" bundle="${lang}"/>
    </div>
    <div>
        <c:forEach items="${text.elements}" var="element">
            <p>${element.buildOriginalString()}</p>
        </c:forEach>
    </div>
    <div>
        <fmt:setLocale value="${locale}"/>
        <fmt:setBundle basename="i18n" var="lang"/>
        <fmt:message key="found.words" bundle="${lang}"/>
    </div>
    <div>
            <p>${foundWords}</p>
    </div>
</body>
</html>
