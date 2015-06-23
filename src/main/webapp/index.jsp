<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Found Words</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/old" method="post">
    <%--@elvariable id="text" type="com.epam.irasov.parser.entity.Text"--%>
    <%--<textarea name="text" id="text" cols="80" rows="30">${text.buildOriginalString()}</textarea>--%>
        <textarea name="text" id="text" cols="100" rows="30"></textarea>
        <%--<input type="file" name="text" id="text"/>--%>
    <div>
        <button type="submit">ParserText</button>
    </div>
</form>
</body>
</html>
