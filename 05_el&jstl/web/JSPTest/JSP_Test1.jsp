<%@ page import="com.tionkior.domain.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: TionKior
  Date: 2021/4/22
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>

        <%
            ArrayList<User> list = new ArrayList<>();
            list.add(new User("史晟贤", 18, new Date()));
            list.add(new User("史晟", 20, new Date()));
            list.add(new User("史", 22, new Date()));

            request.setAttribute("list", list);
        %>

        <table border="1" width="500" align="center">
            <tr>
                <th>编号</th>
                <th>姓名</th>
                <th>年龄</th>
                <th>生日</th>
            </tr>
            <c:forEach items="${list}" var="user" varStatus="s">

            <c:if test="${s.count % 2 == 0 }">
            <tr bgcolor="red">
                <td>${s.count}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>${user.birStr}</td>
            </tr>
            </c:if>

            <c:if test="${s.count % 2 != 0}">
            <tr bgcolor="yellow">
                <td>${s.count}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>${user.birStr}</td>
            </tr>
            </c:if>

            </c:forEach>

    </body>
</html>
