package com.tionkior.dao;

import com.tionkior.domain.User;

import java.util.List;

/**
 * 用户操作的DAO
 */
public interface UserDao {

    public List<User> findAll();

    User findUserByUsernameAndPassword(String username, String password);

    void addUser(User user);
}
