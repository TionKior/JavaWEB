package com.tionkior.jedis.text;

import org.junit.Test;
import redis.clients.jedis.Jedis;

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
}
