package com.tionkior.cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * Cookie快速入门
 */
@WebServlet("/cookieDemo1")
public class CookieDemo1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*
        	1. new Cookie(String name, String value) 创建Cookie对象，绑定数据

            2. response.addCookie(Cookie cookie) 发送Cookie对象

            3. Cookie[] request.getCookies() 获取Cookie，拿到数据

         */

        //1.创建Cookie对象
        Cookie c = new Cookie("msg", "hello");

        //2.发送Cookie
        response.addCookie(c);


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
