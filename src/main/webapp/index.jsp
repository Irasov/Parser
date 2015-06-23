<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>language selection</title>
</head>
<body>
Choose language (en or ru):
<form action="${pageContext.request.contextPath}/start" method="get">
  <textarea name="local" id="local" cols="3" rows="1"></textarea>
  <div>
    <button type="submit">OK</button>
  </div>
</form>

</body>
</html>
