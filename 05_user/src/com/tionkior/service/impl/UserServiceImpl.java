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

    @Override
    public void addUser(User user) {
        dao.addUser(user);
    }

    @Override
    public void deleteUser(String id) {
        dao.delete(Integer.parseInt(id));
    }

    @Override
    public User findUserById(String id) {
        return dao.findById(Integer.parseInt(id));
    }

    @Override
    public void updateUser(User user) {
        dao.update(user);
    }

    @Override
    public void delSelectedUser(String[] ids) {
        if (ids != null && ids.length > 0) {
            //1.遍历数组
            for (String id : ids) {
                //2.调用dao删除
                dao.delete(Integer.parseInt(id));
            }
        }


    }
}
