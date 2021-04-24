package com.tionkior.web.servlet;

import com.tionkior.domain.PageBean;
import com.tionkior.domain.User;
import com.tionkior.service.UserService;
import com.tionkior.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/findUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取参数
        String currentPage = request.getParameter("currentPage"); //当前页码
        String rows = request.getParameter("rows"); //每页显示条数

        if (currentPage == null || "".equals(currentPage)) {
            currentPage = "1";
        }
        if (rows == null || "".equals(rows)) {
            rows = "5";
        }



        /*currentPage = Objects.requireNonNullElse(currentPage, "1");
        rows = Objects.requireNonNullElse(rows, "5");*/

        //2.调用service查询
        UserService service = new UserServiceImpl();
        PageBean<User> userPageBean = service.findUserByPage(currentPage, rows);

        //System.out.println(userPageBean);

        //3.将PageBean存入request
        request.setAttribute("userPageBean", userPageBean);

        //4.转发到list.jsp展示
        request.getRequestDispatcher("/list.jsp").forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
