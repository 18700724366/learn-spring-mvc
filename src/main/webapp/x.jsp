<%--
  Created by IntelliJ IDEA.
  User: thinkpad
  Date: 2023/12/19
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>x.jsp</h3>
1111 <br>
2222 <br>
333 <br>

<%
    request.setAttribute("a", "112233");
    request.getRequestDispatcher("y.jsp").forward(request, response);
%>

444 <br>
555 <br>

</body>
</html>
