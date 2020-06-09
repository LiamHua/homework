<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="per.liam.domain.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>EL表达式</title>
</head>
<body>
<%
    pageContext.getPage();
    request.setAttribute("num1", 10);
    request.setAttribute("num2", 10);
    request.setAttribute("num3", 10);

    String str = "我是一串快乐的字符串，啦啦啦啦啦";
    request.setAttribute("str", str);

    String[] arr = {"我是", "一串", "快乐的", "字符串", "啦啦啦啦啦"};
    request.setAttribute("arr", arr);

    List<String> list = new ArrayList<>();
    list.add("我是");
    list.add("一个");
    list.add("飞翔的");
    list.add("list");
    request.setAttribute("list", list);

    HashMap<String, User> userHashMap = new HashMap<>();
    userHashMap.put("one", new User("老大", 25));
    userHashMap.put("two", new User("老二", 20));
    userHashMap.put("three", new User("老三", 12));
    request.setAttribute("map", userHashMap);

%>
EL数学计算：${ num1+num2+num3  }<br/>
EL取出字符串：${ str }<br/>
EL取出数组：<c:forEach items="${ arr }" var="s">${ s }</c:forEach><br>
EL取出List：<c:forEach items="${ list }" var="l">${ l }</c:forEach><br>
EL取出Map：<br><c:forEach items="${ map }" var="m">
    我是${ m.value.username }，我现在${ m.value.age }岁了，宝刀未老
    <br></c:forEach>
EL判断为空：<c:if test="${ map.get(\"one\") != null }">我不是空的。依旧很强大</c:if><br>
EL判断长度：<c:if test="${ map.size() == 3 }">map的长度为3</c:if><br>
EL遍历数据：<c:forEach begin="2" end="${ map.size() }" var="num">${ arr[num] }</c:forEach>

</body>
</html>