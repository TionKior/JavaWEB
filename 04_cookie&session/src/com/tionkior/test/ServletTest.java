package com.tionkior.test;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet("/servletTest")
public class ServletTest extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取用户表单数据
        String username = request.getParameter("username");
        Map<String, String[]> parameterMap = request.getParameterMap();

        //request存储数据
        request.setAttribute("msg", "hello request");

        //request获取数据
        String msg1 = (String) request.getAttribute("msg");

        //请求转发
        request.getRequestDispatcher("/servletTest2").forward(request, response);

        //重定向
        response.sendRedirect("/servletTest2");


        //Cookie
        //创建对象(存储数据)
        Cookie cookie = new Cookie("msg", "hello cookie");
        //获取数据
        Cookie[] cookies = request.getCookies();

        //Session
        //创建对象
        HttpSession session = request.getSession();
        //存储数据
        session.setAttribute("msg", "hello session");
        //获取数据
        String msg = (String) session.getAttribute("msg");
        //移除数据
        session.removeAttribute("msg");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
