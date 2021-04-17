package com.tionkior.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Cookie存活时间
 */
@WebServlet("/cookieDemo4")
public class CookieDemo4 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.创建Cookie对象
        Cookie c1 = new Cookie("msg", "setMaxAge");

        //2.设置cookie的存活时间
        //c1.setMaxAge(30); //正数：将cookie持久化到硬盘,30秒后会自动删除cookie文件

        //c1.setMaxAge(-1); //负数：默认值，浏览器关闭后，Cookie数据被销毁

        //c1.setMaxAge(300);

        //c1.setMaxAge(0); //零：删除cookie信息

        //2.发送Cookie
        response.addCookie(c1);


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
