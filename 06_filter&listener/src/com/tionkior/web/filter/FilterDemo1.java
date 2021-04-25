package com.tionkior.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @ClassName : FilterDemo1
 * @Author : TionKior
 * @Date : 2021/4/25 12:29
 * @Version : V1.0
 * @Description : 过滤器快速入门
 */
//@WebFilter("/*") //访问所有资源之前,都会执行该过滤器
public class FilterDemo1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filterDemo1被执行了...");

        //放行
        filterChain.doFilter(servletRequest, servletResponse);


    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
