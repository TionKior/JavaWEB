package com.tionkior.dao;

import com.tionkior.domain.User;
import com.tionkior.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @ClassName : UserDao
 * @Author : TionKior
 * @Date : 2021/4/13 17:35
 * @Version : V1.0
 * @Description : 操作数据库中User表的类
 */

public class UserDao {

    //声明JDBCTemplate对象共用
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 登录方法
     *
     * @param loginUser 只有用户名和密码
     * @return user包含用户全部数据, 没有查询到, 返回null
     */
    public User login(User loginUser) {
        try {
            //1.编写sql
            String sql = "select * from user where username = ? and PASSWORD = ?";
            //2.调用query方法
            User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(), loginUser.getPassword());
            //如果有数据,返回查询数据
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();//记录日志
            //没有查询到数据,返回null
            return null;
        }
    }
}
