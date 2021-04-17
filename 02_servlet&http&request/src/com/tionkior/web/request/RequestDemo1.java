package com.tionkior.web.request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 演示Request对象获取请求行数据
 */

@WebServlet(name = "requestDemo1", value = "/requestDemo1")
public class RequestDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        	1. 获取虚拟目录：/day14
            • String getContextPath()
            2. 获取请求URI：/day14/demo1
            • String getRequestURI()：/day14/demo1
            • StringBuffer getRequestURL()：http://localhost/day14/demo1
            3. 获取请求方式
            • String getMethod()
            4. 获取Servlet路径：/demo1
            • String getServletPath()
            5. 获取get方式请求参数：name=zhangsan
            • String getQueryString()
            6. 获取协议及版本：HTTP/1.1
            • String getProtocol()
            7. 获取客户机的IP地址：
            String getRemoteAddr()
         */
        //获取请求方式
        //String getMethod()
        String method = request.getMethod();
        System.out.println(method);

        //获取虚拟目录
        //String getContextPath()
        String contextPath = request.getContextPath();
        System.out.println(contextPath);

        //获取Servlet路径：/requestDemo1
        //String getServletPath
        String servletPath = request.getServletPath();
        System.out.println(servletPath);

        //获取get方式请求参数：name=zhangsan
        //String getQueryString()
        String queryString = request.getQueryString();
        System.out.println(queryString);

        //获取请求URI：/day14/demo1
        //String getRequestURI()：/day14/requestDemo1
        //StringBuffer getRequestURL()：http://localhost/day14/requestDemo1
        String requestURI = request.getRequestURI();
        StringBuffer requestURL = request.getRequestURL();
        System.out.println(requestURI);
        System.out.println(requestURL);

        //获取协议及版本：HTTP/1.1
        //String getProtocol()
        String protocol = request.getProtocol();
        System.out.println(protocol);

        //获取客户机的IP地址：
        //String getRemoteAddr()
        String remoteAddr = request.getRemoteAddr();
        System.out.println(remoteAddr);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
