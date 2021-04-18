package com.tionkior.dao;

import com.tionkior.domain.User;
import com.tionkior.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @ClassName : UserDao
 * @Author : TionKior
 * @Date : 2021/4/18 12:44
 * @Version : V1.0
 * @Description : UserDao访问数据库
 */

public class UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public User login(User loginUser) {

        //编写sql语句
        String sql = "select * from user where username = ? and password = ?";

        try {
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), loginUser.getUsername(), loginUser.getPassword());
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();//一般是记录日志
            return null;
        }

    }
}
