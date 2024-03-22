<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <!--
    文件上传的表单，有两个必须：
    1. method必须为post。 因为get请求方式，实在地址栏上携带请求参数，而地址栏删的参数长度收到浏览器的。
    2. enctype="multipart/form-data" 加上这个配置，浏览器就会把文件的2进制数据上传给服务器。 也就是，已经完成文件上传了。
  -->
  <fieldset>
    <legend>只传一个文件</legend>
    <form method="post" enctype="multipart/form-data" action="/mvc/upload.do">
      photo: <input type="file" name="photo"> <br>
      <button type="submit">点我</button>
    </form>
  </fieldset>



  <fieldset>
    <legend>传送多个值，以及文件</legend>
    <form method="post" enctype="multipart/form-data" action="/mvc/upload2.do">
      username: <input type="text" name="username"> <br>
      password: <input type="text" name="password"> <br>
      photo: <input type="file" name="photo2"> <br>
      <button type="submit">点我</button>
    </form>
  </fieldset>
</body>
</html>
