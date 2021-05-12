package com.tionkior.dao.impl;

import com.tionkior.dao.ProvinceDao;
import com.tionkior.domain.Province;
import com.tionkior.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @ClassName : ProvinceDaoImpl
 * @Author : TionKior
 * @Date : 2021/5/12 14:50
 * @Version : V1.0
 * @Description :
 */

public class ProvinceDaoImpl implements ProvinceDao {

    //1.声明成员变量 jdbctemplement
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Province> findAll() {
        //1.定义sql
        String sql = "select * from province";
        //2.执行sql
        List<Province> list = template.query(sql, new BeanPropertyRowMapper<Province>(Province.class));
        return list;
    }
}
