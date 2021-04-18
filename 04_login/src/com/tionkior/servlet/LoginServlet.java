package com.tionkior.servlet;

import com.tionkior.dao.UserDao;
import com.tionkior.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.设置request编码
        request.setCharacterEncoding("utf-8");
        //2.获取参数Map
        //2.1使用BeanUtils封装
        Map<String, String[]> parameterMap = request.getParameterMap();
        User userLogin = new User();
        try {
            BeanUtils.populate(userLogin, parameterMap);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        //3.先获取生成的验证码
        HttpSession session = request.getSession();
        String checkCode_session = (String) session.getAttribute("checkCode_session");
        //删除session中存储的验证码
        session.removeAttribute("checkCode_session");

        //3.先判断验证码是否正确
        //因为把用户输入的数据都封装到了userLogin对象中,想获取用户输入的数据直接使用get方法就可以
        if (checkCode_session != null && checkCode_session.equalsIgnoreCase(userLogin.getCheckCode())) {
            //忽略大小写
            //验证码正确
            //判断用户名和密码是否一致
            UserDao dao = new UserDao();
            User login = dao.login(userLogin);
            if (login != null) {//需要调用UserDao查询数据库
                //登陆成功
                //存储信息,用户信息
                //因为是重定向,所以需要两次请求,将信息存储到session里面
                session.setAttribute("user", userLogin);

                //重定向success.jsp
                //虚拟目录通过request.getContextPath()获取
                response.sendRedirect(request.getContextPath() + "/success.jsp");
            } else {
                //登陆失败
                //存储提示信息到request
                request.setAttribute("login_error", "用户名或密码错误");
                //转发到登录页面
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }

        } else {
            //验证码不一致
            //存储提示信息到request
            request.setAttribute("checkCode_error", "验证码错误");
            //转发到登录页面
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
