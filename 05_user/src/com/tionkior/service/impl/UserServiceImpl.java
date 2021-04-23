package com.tionkior.service.impl;

import com.tionkior.dao.UserDao;
import com.tionkior.dao.impl.UserDaoImpl;
import com.tionkior.domain.User;
import com.tionkior.service.UserService;

import java.util.List;

/**
 * @ClassName : UserServiceImpl
 * @Author : TionKior
 * @Date : 2021/4/23 10:21
 * @Version : V1.0
 * @Description : UserService实现类
 */

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();

    @Override
    public List<User> findAll() {
        //调用Dao完成查询
        return dao.findAll();
    }

    @Override
    public User login(User user) {
        //账号密码登录
        return dao.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }
}
