<%--@elvariable id="bundle" type="javax.servlet.jstl"--%>
<%--@elvariable id="fondWords" type="java.lang.String"--%>
<%--@elvariable id="text" type="com.epam.irasov.parser.entity.Text"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${bundle.getInternationalization("parse")}</title>
</head>
<body>

<div>${bundle.getInternationalization("text")}</div>
${text.buildOriginalString()}
<div>${bundle.getInternationalization("found.words")}</div>
${fondWords}
</body>
</html>
