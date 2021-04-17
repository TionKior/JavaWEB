package com.tionkior.web.ServletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * 获取文件真实路径
 * String getRealPath(String path)
 */
@WebServlet("/servletContextDemo5")
public class ServletContextDemo5 extends HttpServlet {
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

        //String getRealPath(String path) 获取文件的服务器路径
        String realPath = context.getRealPath("/b.txt");// web目录下资源访问

        String c = context.getRealPath("/WEB-INF/c.txt");// web/WEB-INF目录下的资源访问

        String a = context.getRealPath("/WEB-INF/classes/a.txt");// src目录下的资源访问


        //File file = new File(realPath);


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

}
