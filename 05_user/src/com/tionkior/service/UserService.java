package com.tionkior.service;

import com.tionkior.domain.User;

import java.util.List;

/**
 * 用户管理的业务接口
 */
public interface UserService {

    /**
     * 查询所有用户信息
     *
     * @return
     */
    public List<User> findAll();

    public User login(User user);

    /**
     * 保存User
     *
     * @param user
     */
    void addUser(User user);

    /**
     * 根据id删除User
     *
     * @param id
     */
    void deleteUser(String id);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    User findUserById(String id);

    /**
     * 修改用户信息
     *
     * @param user
     */
    void updateUser(User user);
}
