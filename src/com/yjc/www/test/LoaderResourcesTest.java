package com.yjc.www.test;

import org.junit.Test;

import java.io.InputStream;
import java.util.Properties;

public class LoaderResourcesTest {
    @Test
    public void testName() throws Exception {

        //获取类加载器
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        //读取配置文件
        InputStream inputStream = loader.getResourceAsStream("druid.properties");

        //Java中有一个Properties 类是专门读取 xx.properties配置文件的内容
        Properties p = new Properties();
        p.load(inputStream);

        //获取对应配置信息
        System.out.println(p);
        System.out.println(p.getProperty("driverClassName"));
        System.out.println(p.getProperty("url"));
        System.out.println(p.getProperty("username"));
        System.out.println(p.getProperty("password"));

    }
}
