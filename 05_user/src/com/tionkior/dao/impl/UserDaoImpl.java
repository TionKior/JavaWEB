package com.tionkior.dao.impl;

import com.tionkior.dao.UserDao;
import com.tionkior.domain.User;
import com.tionkior.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @ClassName : UserDaoImpl
 * @Author : TionKior
 * @Date : 2021/4/23 10:23
 * @Version : V1.0
 * @Description : UserDao接口实现类
 */

public class UserDaoImpl implements UserDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<User> findAll() {
        //使用JDBC操作数据库
        //1.定义sql
        String sql = "select * from user";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));

        return users;
    }
}
