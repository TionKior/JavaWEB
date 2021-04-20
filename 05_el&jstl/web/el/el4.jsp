<%--
  Created by IntelliJ IDEA.
  User: TionKior
  Date: 2021/4/20
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>el隐式对象</title>
    </head>
    <body>

        ${pageContext.request}<br>

        <h4>在jsp页面动态获取虚拟目录</h4>
        ${pageContext.request.contextPath}

        <%
            //虚拟目录是用户自己设置的,不能写死,用request.getContextPath()
            response.sendRedirect(request.getContextPath() + "");
        %>
    </body>
</html>
