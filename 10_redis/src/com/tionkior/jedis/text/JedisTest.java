package com.tionkior.jedis.text;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Map;
import java.util.Set;

/**
 * @ClassName : JedisTest
 * @Author : TionKior
 * @Date : 2021/5/12 12:50
 * @Version : V1.0
 * @Description : jedis的测试类
 */

public class JedisTest {

    /**
     * 快速入门
     */
    @Test
    public void test1() {
        //1.获取连接
        Jedis jedis = new Jedis("localhost", 6379);
        //2.操作
        jedis.set("username", "zhangsan");

        //3.关闭连接
        jedis.close();
    }

    /**
     * string数据结构操作
     */
    @Test
    public void test2() {
        //1.获取连接
        Jedis jedis = new Jedis(); //如果使用空参构造,默认值 "localhost",6379端口
        //2.操作
        //存储
        jedis.set("username", "zhangsan");
        //获取
        String username = jedis.get("username");
        System.out.println(username);

        //可以使用setex()方法存储可以指定过期时间的 key value
        jedis.setex("activecode", 20, "hehe"); //将activecode：hehe键值对存入redis,并且20秒后自动删除该键值对

        //3.关闭连接
        jedis.close();
    }

    /**
     * hash数据结构操作
     */
    @Test
    public void test3() {
        //1.获取连接
        Jedis jedis = new Jedis(); //如果使用空参构造,默认值 "localhost",6379端口
        //2.操作
        //存储hash
        jedis.hset("user", "name", "lisi");
        jedis.hset("user", "age", "23");
        jedis.hset("user", "gender", "male");

        //获取hash
        String name = jedis.hget("user", "name");

        //获取hash的所有map中的数据
        Map<String, String> user = jedis.hgetAll("user");

        //keySet
        Set<String> keySet = user.keySet();
        for (String key : keySet) {
            //获取value
            String value = user.get(key);
            System.out.println(key + ":" + value);
        }


        System.out.println(name);


        //3.关闭连接
        jedis.close();
    }
}
