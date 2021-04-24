package com.tionkior.dao;

import com.tionkior.domain.User;

import java.util.List;

/**
 * 用户操作的DAO
 */
public interface UserDao {
    /**
     * 查询所有
     *
     * @return
     */
    public List<User> findAll();

    /**
     * 用户登录
     *
     * @param username
     * @param password
     * @return
     */
    User findUserByUsernameAndPassword(String username, String password);

    /**
     * 添加用户
     *
     * @param user
     */
    void addUser(User user);

    /**
     * 删除用户
     *
     * @param i
     */
    void delete(int i);

    /**
     * 根据id查询
     *
     * @param i
     * @return
     */
    User findById(int i);
}
