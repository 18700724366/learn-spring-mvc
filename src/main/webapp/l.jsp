<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/mvc/users" method="post">
    id: <input type="text" name="id"> <br/>
    name: <input type="text" name="name"/>
    birthday: <input type="text" name="birthday">
    balance: <input type="text" name="balance"/>
    <button type="submit">save</button>
</form>

<form action="/mvc/users" method="get">
    <button type="submit">findAll</button>
</form>


<form action="/mvc/users/123" method="post">
    <input type="text" name="_method" value="delete">
    <button type="submit">delete</button>
</form>

<form action="/mvc/users" method="post">
    <input type="text" name="_method" value="put">
    <button type="submit">put</button>
</form>

</body>
</html>
