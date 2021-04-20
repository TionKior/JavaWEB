<%--
  Created by IntelliJ IDEA.
  User: TionKior
  Date: 2021/4/20
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>el获取域中的数据</title>
    </head>
    <body>

        <%
            //在域中存储数据
            request.setAttribute("name", "张三");
            session.setAttribute("age", 23);

            session.setAttribute("name", "李四");

            /*pageContext.setAttribute("name","李四");
            application.setAttribute("age","18");*/
        %>
        <h3>el获取值</h3>
        <%--        有值显示值，没值显示空字符串--%>
        ${requestScope.name}
        ${sessionScope.age}

        ${name}
        ${sessionScope.name}

    </body>
</html>
