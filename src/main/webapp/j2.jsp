
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="https://cdn.bootcdn.net/ajax/libs/axios/1.5.0/axios.js"></script>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form>
        username: <input type="text" id="username"> <br>
        password: <input type="text" id="password"> <br>
        photo: <input type="file" id="photo" multiple /> <br>
        <button onclick="upload()" type="button">go</button>
    </form>

    <script>
        function upload() {
            let file = document.getElementById("photo");

            let formData = new FormData();

            for(let f of file.files) {
                formData.append("photos", f);
            }

            formData.append("username", document.getElementById("username").value);
            formData.append("password", document.getElementById("password").value);

            axios.post("http://localhost:8080/mvc/upload2.do", formData).then(resp => {
                console.log(resp)
            })


        }
    </script>
</body>
</html>
