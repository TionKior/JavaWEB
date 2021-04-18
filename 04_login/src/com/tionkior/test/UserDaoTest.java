package com.tionkior.test;

import com.tionkior.dao.UserDao;
import com.tionkior.domain.User;
import org.junit.Test;

/**
 * @ClassName : UserDaoTest
 * @Author : TionKior
 * @Date : 2021/4/18 12:53
 * @Version : V1.0
 * @Description : UserDao测试类
 */

public class UserDaoTest {
    @Test
    public void testLogin() {
        User user = new User();
        user.setUsername("shishengxian");
        user.setPassword("123");
        UserDao userDao = new UserDao();
        User u = userDao.login(user);

        System.out.println(u);
    }

}
