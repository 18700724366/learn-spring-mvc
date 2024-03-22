<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>e.jsp</h3>

<h3>基本类型和String</h3>
<form action="/mvc/foo/f1.do">
    <input type="text" name="b"> <br>
    <input type="text" name="s"> <br>
    <input type="text" name="i"> <br>
    <input type="text" name="l"> <br>
    <input type="text" name="f"> <br>
    <input type="text" name="d"> <br>
    <input type="text" name="bb"> <br>
    <input type="text" name="c"> <br>
    <input type="text" name="str"> <br>
    <button type="submit">go</button>
</form>

<h3>对象</h3>
<form action="/mvc/foo/f2.do">
    id: <input type="text" name="id"> <br>
    name: <input type="text" name="name"> <br>
    birthday: <input type="text" name="birthday"> （YYYY/MM/DD） <br>
    balance: <input type="text" name="balance"> <br>
    car.brand: <input type="text" name="car.brand"> <br>
    car.color: <input type="text" name="car.color"> <br>
    <button type="submit">go</button>
</form>

<h3>数组</h3>
<form action="/mvc/foo/f3.do">

    <label>
        <input type="checkbox" name="hobby" value="乒乓球">乒乓球
    </label>
    <label>
        <input type="checkbox" name="hobby" value="排球">排球
    </label>
    <label>
        <input type="checkbox" name="hobby" value="蓝球">蓝球
    </label>
    <label>
        <input type="checkbox" name="hobby" value="台球">台球
    </label>
    <br>

    主游 <input type="text" name="game"> <br>
    副游 <input type="text" name="game"> <br>
    临时 <input type="text" name="game"> <br>

    <button type="submit">go</button>
</form>


<h3>List集合</h3>
<form action="/mvc/foo/f4.do">

    <label>
        <input type="checkbox" name="hobby" value="乒乓球">乒乓球
    </label>
    <label>
        <input type="checkbox" name="hobby" value="排球">排球
    </label>
    <label>
        <input type="checkbox" name="hobby" value="蓝球">蓝球
    </label>
    <label>
        <input type="checkbox" name="hobby" value="台球">台球
    </label>
    <br>
    <button type="submit">go</button>
</form>


<h3>Set集合</h3>
<form action="/mvc/foo/f5.do">

    <label>
        <input type="checkbox" name="hobby" value="乒乓球">乒乓球
    </label>
    <label>
        <input type="checkbox" name="hobby" value="排球">排球
    </label>
    <label>
        <input type="checkbox" name="hobby" value="蓝球">蓝球
    </label>
    <label>
        <input type="checkbox" name="hobby" value="台球">台球
    </label>
    <br>
    <button type="submit">go</button>
</form>


<h3>Map</h3>
    <form action="/mvc/foo/f6.do">

    最喜欢的游戏 <input type="text" name="game"> <br>
    最喜欢的科目 <input type="text" name="learn"> <br>
    最喜欢的食物 <input type="text" name="eat"> <br>

    <button type="submit">go</button>
</form>

</body>
</html>
