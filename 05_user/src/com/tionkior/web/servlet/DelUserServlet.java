package com.tionkior.web.servlet;

import com.tionkior.service.UserService;
import com.tionkior.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/delUserServlet")
public class DelUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //因为不是中文,不用设置编码
        //1.获取数据
        String id = request.getParameter("id");
        //2.调用service删除
        UserService service = new UserServiceImpl();

        service.deleteUser(id);

        //3.跳转到查询所有的Servlet,使用重定向
        response.sendRedirect(request.getContextPath() + "/userListServlet");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
