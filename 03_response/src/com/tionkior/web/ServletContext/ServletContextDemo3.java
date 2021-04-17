package com.tionkior.web.ServletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servletContextDemo3")
public class ServletContextDemo3 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
            ServletContext功能
                1. 获取MIME类型：
                2. 域对象：共享数据
                3. 获取文件的真实(服务器路径)路径

         */

        //通过HttpServlet获取ServletContext对象
        ServletContext context = this.getServletContext();

        //setAttribute(String name, Object value) 设置数据
        context.setAttribute("msg", "haha");

        //removeAttribute(String name) 移除数据
        context.removeAttribute("msg");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

}
