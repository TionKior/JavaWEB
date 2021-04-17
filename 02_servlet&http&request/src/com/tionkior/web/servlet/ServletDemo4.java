package com.tionkior.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName : ServletDemo4
 * @Author : TionKior
 * @Date : 2021/4/11 9:07
 * @Version : V1.0
 * @Description : @Servlet路径配置
 */
//@WebServlet({"/d4", "/dd4", "/ddd4"})
//@WebServlet("/user/demo4")
//@WebServlet("/user/*")
@WebServlet("*.do")
public class ServletDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("demo4...");
    }
}
