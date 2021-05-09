package com.tionkior.dao.impl;

import com.tionkior.dao.UsernameDao;
import com.tionkior.domain.Person;
import com.tionkior.domain.Username;
import com.tionkior.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @ClassName : UsernameImpl
 * @Author : TionKior
 * @Date : 2021/5/9 14:58
 * @Version : V1.0
 * @Description : Find Username Dao
 */

public class UsernameImpl implements UsernameDao {
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public int findUsername(String username) {
        String sql = "select count(*) from user where NAME = ?";
        try {
            Integer integer = template.queryForObject(sql, Integer.class, username);

            return integer;
        } catch (Exception e) {
            return 0;
        }
    }
}
