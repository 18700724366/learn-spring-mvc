<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <script src="https://cdn.bootcdn.net/ajax/libs/axios/1.5.0/axios.js"></script>
</head>
<body>
<h3>i.jsp</h3>

url: <input type="text" id="url"> <br>
data: <input type="text" id="data"> <br>
Content-Type: <input type="text" id="ct"> <br>
Accept: <input type="text" id="accept"> <br>

<button onclick="go()">go</button>

<script>

    function go() {
        let url = document.getElementById("url").value;
        let data = document.getElementById("data").value;
        let ct = document.getElementById("ct").value;
        let accept = document.getElementById("accept").value;

        let config = {
            headers: {
                "Content-Type": ct,
                "Accept": accept
            }
        }

        axios.post(url,  data, config).then(resp => {
            console.log(resp);
        });
    }


</script>

</body>
</html>
