<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: TionKior
  Date: 2021/5/1
  Time: 10:54
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
            ArrayList<String> arrayList = new ArrayList<String>();
            arrayList.add("hello world");
            arrayList.add("jsp");
            arrayList.add("ssx");
            arrayList.add("ssx");

            request.setAttribute("arrayList", arrayList);
        %>

        <c:forEach var="arr" items="${arrayList}" varStatus="s">
            <h1>${arr}</h1>
            读取到了数据
        </c:forEach>
    </body>
</html>
