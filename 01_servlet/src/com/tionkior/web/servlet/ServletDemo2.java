package com.tionkior.web.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @ClassName : ServletDemo2
 * @Author : TionKior
 * @Date : 2021/4/5 13:18
 * @Version : V1.0
 * @Description : Servlet的方法
 */

public class ServletDemo2 implements Servlet {

    /**
     * 初始化方法
     * 在Servlet被创建时,执行,只会执行一次
     *
     * @param config
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init...");
    }

    /**
     * 获取ServletConfig对象
     * ServletConfig：Servlet对象
     *
     * @return
     */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 提供服务方法
     * 每一次Servlet被访问时,执行。执行多次
     *
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("service...");
    }

    /**
     * 获取Servlet的一些信息,版本,作者等等...
     *
     * @return
     */
    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 销毁方法
     * 在服务器正常关闭时,执行,执行一次
     */
    @Override
    public void destroy() {
        System.out.println("destroy...");
    }
}
