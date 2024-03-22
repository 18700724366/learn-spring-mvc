<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>h.jsp</h3>

<form action="/mvc/user/save.do" method="post">
    id: <input type="text" name="id" value="${param.id}"> ${idError} <br/>
    name: <input type="text" name="name" value="${requestScope.nameError == null ? param.name : ""}"> ${nameError} <br/>
    birthday: <input type="text" name="birthday" value="${param.birthday}"> ${birthdayError} <br/>
    balance: <input type="text" name="balance" value="${param.balance}"> ${balanceError} <br/>
    <button type="submit">go</button>
</form>
</body>
</html>
