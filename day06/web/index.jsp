<%--
  User: liam
  Date: 2020/6/8
  Time: 12:33
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>$Title$</title>
    <script type="application/javascript" src="webjars/jquery/3.5.1/dist/jquery.min.js"></script>
    <script>
        $(function () {
            $('#submit').click(() => {
                if ($("input[name='username']").val()) {
                    $.ajax({
                        type: 'GET',
                        url: 'LoginServlet',
                        // 注意data中不能有空格
                        data: "username=" + $("input[name='username']").val(),
                        success: data => {
                            $('.login').css('display', 'none')
                            $('#welcome').text('欢迎您' + $("input[name='username']").val())
                        }
                    })
                } else {
                    alert('用户名不能为空！')
                }
            })
        })
    </script>
</head>
<body>
<div class="container">
    <p>
    <h1>响上天城堡</h1></p>
    <div class="login">
        <p><input type="text" name="username"></p>
        <p><input type="password" name="password"></p>
        <p>
            <button id="submit">提交</button>
        </p>
    </div>
    <h2>
        <text id="welcome"></text>
    </h2>
</div>
</body>
</html>
