package com.tionkior.service.impl;

import com.tionkior.dao.UserDao;
import com.tionkior.dao.impl.UserDaoImpl;
import com.tionkior.domain.PageBean;
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

    @Override
    public PageBean<User> findUserByPage(String _currentPage, String _rows) {

        //将两个参数转换为int类型
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        //1.创建空的PageBean对象
        PageBean<User> userPageBean = new PageBean<User>();
        //2.设置当前页面属性和rows属性
        userPageBean.setCurrentPage(currentPage);
        userPageBean.setRows(rows);

        //3.调用dao查询totalCount总记录数
        int totalCount = dao.findTotalCount();

        userPageBean.setTotalCount(totalCount);
        //5.调用dao查询list集合
        //计算开始的记录索引
        int start = (currentPage - 1) * rows;

        List<User> list = dao.findByPage(start, rows);
        userPageBean.setList(list);

        //5.计算总页码
        int totalPage = totalCount % rows == 0 ? totalCount / rows : totalCount / rows + 1;
        userPageBean.setTotalPage(totalPage);


        //6.返回PageBean对象
        return userPageBean;
    }
}
