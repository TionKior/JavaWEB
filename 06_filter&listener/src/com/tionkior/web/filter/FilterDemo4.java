package com.tionkior.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter("/index.jsp") //具体资源路径：/index.jsp   只有访问index.jsp资源时，过滤器才会被执行
//@WebFilter("/user/*") //拦截目录：/user/*   访问/user下的所有资源时，过滤器都会被执行
//@WebFilter("*.jsp") //后缀名拦截：*.jsp   访问所有后缀名为jsp资源时，过滤器都会被执行
public class FilterDemo4 implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("filterDemo4...");
        chain.doFilter(request, response);
    }

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }
}
