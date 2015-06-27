<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>
        <fmt:bundle basename="i18n">
        <fmt:message key="choose.language"/>
        </fmt:bundle>
    </title>
</head>
<body>
    <fmt:bundle basename="i18n">
    <fmt:message key="choose.language"/>
    </fmt:bundle>
<form action="${pageContext.request.contextPath}/start" method="get">
  <textarea name="locale" id="locale" cols="3" rows="1">ru</textarea>
  <div>
    <button type="submit">OK</button>
  </div>
</form>

</body>
</html>
