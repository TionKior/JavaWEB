package com.tionkior.web.ServletContext;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/servletContextDemo1")
public class ServletContextDemo1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
            ServletContext对象的获取
            通过request对象获取
            request.getServletContext();

            通过HttpServlet获取
            this.getServletContext();
         */

        //request.getServletContext(); 通过request对象获取
        ServletContext context1 = request.getServletContext();

        //this.getServletContext(); 通过HttpServlet获取
        ServletContext context2 = this.getServletContext();

        System.out.println(context1 == context2);


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

}
