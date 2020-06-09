<%--
  User: liam
  Date: 2020/6/8
  Time: 23:13
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询用户</title>
    <script type="application/javascript" src="webjars/jquery/3.5.1/dist/jquery.min.js"></script>
    <script>
        $(function() {
            $('#submit').click(() => {
                $("table tr~tr").empty();
                $.get(
                    'SearchServlet',
                    {username: $("input[type='text']").val()},
                    function (data) {
                        if (data == "没有查询到用户数据") {
                            alert("没有查询到用户数据")
                        } else {
                            $.each(data,(i, v) => {
                                var tr="<tr><td>"+v.id+"</td>";
                                tr+="<td>"+v.name+"</td>";
                                tr+="<td>"+v.age+"</td>";
                                tr+="<td>"+v.edu+"</td>";
                                tr+="<td>"+v.gender+"</td>";
                                //把tr拼接到table上
                                $("#table").append(tr);
                            })
                        }
                    },
                    "json"
                )
            })
        })
    </script>
</head>
<body>
<div class="container">
    <p>用户名：<input type="text"><input id="submit" type="submit">查询</p>
    <div class="info">
        <table id="table" border="1">
            <tr>
                <th>id</th>
                <th>用户名</th>
                <th>年龄</th>
                <th>学历</th>
                <th>性别</th>
            </tr>
        </table>
    </div>
</div>
</body>
</html>
