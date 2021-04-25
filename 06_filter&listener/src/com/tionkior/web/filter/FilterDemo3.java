package com.tionkior.web.filter;

import javax.servlet.*;
import java.io.IOException;

//@WebFilter("/*")
public class FilterDemo3 implements Filter {
    /**
     * 每一次请求被拦截资源时,会执行,执行多次
     *
     * @param request
     * @param response
     * @param chain
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("doFilter...");
        chain.doFilter(request, response);
    }

    /**
     * 在服务器启动后,会创建Filter对象,然后调用init方法,只执行一次。用于加载资源
     *
     * @param config
     * @throws ServletException
     */
    public void init(FilterConfig config) throws ServletException {
        System.out.println("init...");
    }

    /**
     * 在服务器关闭后,Filter对象被销毁.如果服务器是正常关闭,则会执行destroy方法,只执行一次，用于释放资源
     */
    public void destroy() {
        System.out.println("destroy...");
    }
}
