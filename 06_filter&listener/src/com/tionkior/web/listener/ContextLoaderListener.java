package com.tionkior.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @ClassName : ContextLoaderListener
 * @Author : TionKior
 * @Date : 2021/4/28 13:09
 * @Version : V1.0
 * @Description : 监听器实现类
 */

public class ContextLoaderListener implements ServletContextListener {

    /**
     * 监听ServletContext对象创建的,ServletContext对象服务器启动后自动创建
     * <p>
     * 在服务器启动后自动调用
     *
     * @param sce
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ServletContext对象被创建了");
    }

    /**
     * 在服务器关闭后,ServletContext对象被销毁,当服务器正常关闭后,该方法被调用
     *
     * @param sce
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ServletContext对象被销毁了");
    }
}
