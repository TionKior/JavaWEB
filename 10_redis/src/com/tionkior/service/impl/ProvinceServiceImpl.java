package com.tionkior.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tionkior.dao.ProvinceDao;
import com.tionkior.dao.impl.ProvinceDaoImpl;
import com.tionkior.domain.Province;
import com.tionkior.jedis.util.JedisPoolUtils;
import com.tionkior.service.ProvinceService;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * @ClassName : ProvinceServiceImpl
 * @Author : TionKior
 * @Date : 2021/5/12 14:52
 * @Version : V1.0
 * @Description :
 */

public class ProvinceServiceImpl implements ProvinceService {
    //声明dao
    private ProvinceDao dao = new ProvinceDaoImpl();

    @Override
    public List<Province> findAll() {
        return dao.findAll();
    }

    /**
     * 使用redis缓存
     *
     * @return
     */
    @Override
    public String findAllJson() {
        //1.先从redis中查询数据
        //1.1获取redis客户端连接
        Jedis jedis = JedisPoolUtils.getJedis();
        String province_json = jedis.get("province");

        //2.判断 province_json 数据是否为null
        if (province_json == null || province_json.length() == 0) {
            //redis中没有数据
            System.out.println("redis中没数据,查询数据库...");
            //2.1从数据库中查询
            List<Province> ps = dao.findAll();
            //2.2将list序列化为json
            ObjectMapper mapper = new ObjectMapper();
            try {
                province_json = mapper.writeValueAsString(ps);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

            //2.3 将json数据存入redis
            jedis.set("province", province_json);
            //归还连接
            jedis.close();

        } else {
            System.out.println("redis中有数据,查询缓存...");
        }


        return province_json;
    }
}
