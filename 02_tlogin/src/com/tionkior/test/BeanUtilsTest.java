package com.tionkior.test;

import com.tionkior.domain.User;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

/**
 * @ClassName : BeanUtilsTest
 * @Author : TionKior
 * @Date : 2021/4/14 11:14
 * @Version : V1.0
 * @Description : BeanUtils测试类
 */

public class BeanUtilsTest {

    @Test
    public void test() {

        User user = new User();
        try {
            BeanUtils.setProperty(user,"method","male");

            String gender = BeanUtils.getProperty(user, "method");

            System.out.println(gender);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        System.out.println(user);



    }
}
