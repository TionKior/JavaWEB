package com.tionkior.web.servlettest;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/servletTest2")
public class ServletTest2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //请求转发
        request.getRequestDispatcher("/servletTest3").forward(request, response);

        //重定向
        response.sendRedirect("/servletTest3");

        //设置request域存储数据
        request.setAttribute("msg", "hello request");

        //request域获取数据
        String msg = (String) request.getAttribute("msg");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
