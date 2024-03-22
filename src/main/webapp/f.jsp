<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>f.jsp</h3>

<!-- request.getAttribute("user"); -->
EL获取： ${requestScope.user} <br>
<!-- request.getParamter("user"); -->
获取请求参数： ${param.user} <br>
</body>
</html>
