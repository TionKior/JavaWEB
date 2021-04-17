package com.tionkior.web.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @ClassName : ServletDemo1
 * @Author : TionKior
 * @Date : 2021/4/5 12:52
 * @Version : V1.0
 * @Description : Servlet快速入门
 */

public class ServletDemo1 implements Servlet {
    @Override
    public void init(ServletConfig config) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }


    //提供服务的方法
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("Hello Servlet");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
