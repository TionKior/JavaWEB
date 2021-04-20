<%@ page import="com.tionkior.domain.User" %>
<%@ page import="java.util.*" %><%--
  Created by IntelliJ IDEA.
  User: TionKior
  Date: 2021/4/20
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>el获取数据</title>
    </head>
    <body>

        <%
            User user = new User();
            user.setName("张三");
            user.setAge(23);
            user.setBirthday(new Date());

            request.setAttribute("u", user);

            List list = new ArrayList();
            list.add("aaa");
            list.add("bbb");
            list.add(user);

            request.setAttribute("list", list);


            Map map = new HashMap();
            map.put("sname", "李四");
            map.put("gender", "男");
            map.put("user", user);

            request.setAttribute("map", map);

        %>
        <h3>el获取对象中的值</h3>
        ${requestScope.u}<br>

        <%--
            通过的是对象的属性来获取
            setter或getter方法,去掉set或get,再将剩余部分,首字母变为小写
            setName --> Name --> name
        --%>

        ${requestScope.u.name}<br>
        ${u.age}<br>
        ${u.birthday}<br>
        ${u.birthday.month}<br>
        ${u.birthday}<br>

        ${u.birStr}<br>

        <h3>el获取list的值</h3>
        ${list}<br>
        ${list[0]}<br>
        ${list[1]}<br>
        <%--list[2]存储的是一个对象,可以直接调用它的属性--%>
        ${list[2].name}

        <h3>el获取Map的值</h3>
        ${map.gender}<br>
        ${map["gender"]}<br>
        <%--map.user存储的是一个对象,user是键的名称,可以直接调用它的属性--%>
        ${map.user.name}

    </body>
</html>
