<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: TionKior
  Date: 2021/4/23
  Time: 20:35
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
            ArrayList<String> list = new ArrayList<String>();
            list.add("123");
            list.add("456");
            list.add("789");

            request.setAttribute("list", list);
        %>
        <c:forEach items="${list}" var="number" varStatus="s">
            ${s.count} ${number} <br>
        </c:forEach>
    </body>
</html>
