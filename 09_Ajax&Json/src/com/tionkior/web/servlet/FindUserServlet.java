package com.tionkior.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tionkior.service.UsernameService;
import com.tionkior.service.impl.UsernameServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取用户名
        String username = request.getParameter("username");

        //2.调用service层判断用户名是否存在

        //期望服务器响应回的数据格式：{"userExsit":true,"msg":"此用户太受欢迎,请更换一个"}
        //                          {"userExsit":false,"msg":"用户名可用"}

        //设置响应的数据格式为json
        response.setContentType("application/json;charset=utf-8");
        Map<String, Object> map = new HashMap<String, Object>();

        UsernameService service = new UsernameServiceImpl();

        if (service.finUsername(username)) {
            //不存在
            map.put("userExsit", false);
            map.put("msg", "用户名可用");
        } else {
            //存在
            map.put("userExsit", true);
            map.put("msg", "此用户太受欢迎,请更换一个");
        }

        //将map转为json,并且传递给客户端
        //将map转为json
        ObjectMapper mapper = new ObjectMapper();
        //并且传递给客户端
        mapper.writeValue(response.getWriter(), map);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
