<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: TionKior
  Date: 2021/5/2
  Time: 19:43
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
            List<String> list = new ArrayList<String>();
            list.add("123");
            list.add("456");
            list.add("789");

            request.setAttribute("msg", list);
            request.setAttribute("String", "String");

        %>
        <c:forEach var="str" items="${msg}" varStatus="s">
            ${s.count}   ${str}
        </c:forEach>
        <c:if test="${String == 'String'}">
            接收到了数据,在里面判断字符串需要用单引号
        </c:if>
    </body>
</html>
