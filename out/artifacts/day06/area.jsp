<%--
  Created by IntelliJ IDEA.
  User: liam
  Date: 2020/6/9
  Time: 09:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>地区</title>
    <script type="application/javascript" src="webjars/jquery/3.5.1/dist/jquery.min.js"></script>
    <script>
        $(function() {
            var res = null
            $.get(
                'AreaServlet',
                function(data) {
                    res = data
                    $.each(data,(i,v) => {
                        console.log(v.name)
                        var op1 = "<option>" + v.name + "</option>"
                        $('#p').append(op1)

                        if (v.id == 1) {
                            $.each(v.children,(i,v) => {
                                var op2 = "<option>" + v.name + "</option>"
                                $('#a').append(op2)
                            })
                        }
                    })
                },
                "json"
            )

            $('#p').change(() => {
                $('#a').empty()
                $.each(res,(i,v) => {
                    if ($('#p').val() === v.name) {
                        $.each(v.children,(i,v) => {
                            var op3 = "<option>" + v.name + "</option>"
                            $('#a').append(op3)
                        })
                    }
                })
            })
        })
    </script>
</head>
<body>
<div>
    <select name="p" id="p" class="province"></select>
    <select name="a" id="a" class="area"></select>
</div>
</body>
</html>
