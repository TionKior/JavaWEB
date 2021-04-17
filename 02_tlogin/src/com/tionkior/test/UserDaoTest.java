package com.tionkior.test;

import com.tionkior.dao.UserDao;
import com.tionkior.domain.User;
import org.junit.Test;

/**
 * @ClassName : UserDaoTest
 * @Author : TionKior
 * @Date : 2021/4/13 18:02
 * @Version : V1.0
 * @Description : 测试类
 */

public class UserDaoTest {
    @Test
    public void testLogin() {
        User loginuser = new User();
        loginuser.setUsername("superbaby");
        loginuser.setPassword("123");

        UserDao dao = new UserDao();
        User user = dao.login(loginuser);

        System.out.println(user);
    }
}
