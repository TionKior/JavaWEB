package com.tionkior.web.filter;

import javax.servlet.*;
import java.io.IOException;

//@WebFilter("/*")
public class FilterDemo2 implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //对request对象请求消息增强
        System.out.println("filterDemo2执行了...");

        //放行
        chain.doFilter(request, response);
        //对response对象的响应消息增强
        System.out.println("filterDemo2回来了");
    }

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }
}
