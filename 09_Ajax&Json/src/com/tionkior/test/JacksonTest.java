package com.tionkior.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tionkior.domain.Person;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.util.Date;

/**
 * @ClassName : JacksonTest
 * @Author : TionKior
 * @Date : 2021/5/9 12:49
 * @Version : V1.0
 * @Description : 测试类
 */

public class JacksonTest {

    //Java对象转为JSON字符串
    @Test
    public void test1() throws Exception {
        //1.创建Person对象
        Person p = new Person();
        p.setName("张三");
        p.setAge(23);
        p.setGender("男");

        //2.创建Jackson的核心对象 ObjectMapper
        ObjectMapper mapper = new ObjectMapper();

        //3.转换
        /*
            转换方法：
                writeValue(参数1,obj):
                    参数1：
                        File：将obj对象转换为JSON字符串,并保存到指定的文件中
                        Writer：将obj对象转换为JSON字符串,并将json数据填充到字符输出流中
                        OutputStream：将obj对象转换为JSON字符串,并将json数据填充到字节输出流中
                writeValueAsString(obj):将对象转为json字符串
         */
        String json = mapper.writeValueAsString(p);
        //{"name":""张三","age":23,"gender":"男"}
        //System.out.println(json);//{"name":"张三","age":23,"gender":"男"}

        //writeValue,将数据写到d://a.txt文件中
        mapper.writeValue(new File("d://a.txt"), p);
        //writeValue,将数据关联到Writer中
        mapper.writeValue(new FileWriter("d://b.txt"), p);
    }

    @Test
    public void test2() throws Exception {
        //1.创建Person对象
        Person p = new Person();
        p.setName("张三");
        p.setAge(23);
        p.setGender("男");
        p.setBirthday(new Date());

        //2.转换
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(p);

        System.out.println(json);//{"name":"张三","age":23,"gender":"男","birthday":1620537136040}


    }

}
