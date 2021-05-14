package com.tionkior.web.servlet;

import redis.clients.jedis.Jedis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @ClassName : DemoServlet
 * @Author : TionKior
 * @Date : 2021/5/14 12:50
 * @Version : V1.0
 * @Description : Servlet测试
 */
@WebServlet("/demo")
public class DemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Hello Maven Servlet");

        Jedis jedis = new Jedis();

        try {
            Connection conn = DriverManager.getConnection("", "", "");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
