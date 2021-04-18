<%@ page import="com.tionkior.domain.User" %><%--
  Created by IntelliJ IDEA.
  User: TionKior
  Date: 2021/4/18
  Time: 13:23
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>

        <%
            User user = (User) request.getSession().getAttribute("user");
        %>
        <h1><%=user.getUsername()%>,欢迎您</h1>

    </body>
</html>
