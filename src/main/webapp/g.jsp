<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>g.jsp</h3>

<form action="/mvc/user/save.do" method="post">
    id: <input type="text" name="id"> <br />
    name: <input type="text" name="name"> <br />
    birthday: <input type="text" name="birthday"> <br />
    balance: <input type="text" name="balance"> <br />
    <button type="submit">go</button>
</form>
</body>
</html>
