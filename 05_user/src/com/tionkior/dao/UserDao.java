package com.tionkior.dao;

import com.tionkior.domain.User;

import java.util.List;
import java.util.Map;

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
     * @param id
     */
    void delete(int id);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    User findById(int id);

    /**
     * 更新用户数据
     *
     * @param user
     */
    void update(User user);

    /**
     * 查询总记录数
     *
     * @param condition
     * @return
     */
    int findTotalCount(Map<String, String[]> condition);

    /**
     * 分页查询每页记录
     *
     * @param start
     * @param rows
     * @param condition
     * @return
     */
    List<User> findByPage(int start, int rows, Map<String, String[]> condition);
}
