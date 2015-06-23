<%--@elvariable id="bundle" type="javax.servlet.jstl"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${bundle.getInternationalization("parse")}</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/old" method="post">
        <textarea name="text" id="text" cols="100" rows="30"></textarea>
    <div>
        <button type="submit">${bundle.getInternationalization("parse")}</button>
    </div>
</form>
</body>
</html>
