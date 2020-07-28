package com.chm.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.lang.String;

/*
 * 工厂模式解耦：
 * 一个创建bean对象的工厂，就是用来创建service和dao对象的。
 * bean创建思路：
 *     一、创建一个配置文件，用来配置service和dao。
 *         配置的内容：唯一的标识=全限定类名（key=value）
 *         配置文件可以是xml，也可以是properties。
 *     二、读取配置文件中的内容，用反射来创建对象。
 *
 *
 * bean：指的是可重用组件。在三层架构中，service和dao就是可重用的组件。
 * JavaBean：用Java编写的可重用组件。
 *
 *
 * 单例对象比多例对象效率高。
 *
 */
public class BeanFactory {

    //定义一个Properties对象
    public static Properties props;

    //定义一个Map，将它称为容器，用来存放要创建的对象。
    private static Map<String,Object> beans;

    //使用静态代码块为Properties对象赋值
    static {
        //实例化对象
        props = new Properties();
        //获取properties文件的流对象
        InputStream is = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
        try {
            props.load(is);
            //实例化容器
            beans = new HashMap<String,Object>();
            //取出配置文件中所有的Key
            Enumeration keys = props.keys();
            //遍历枚举
            while (keys.hasMoreElements()){
                //取出每个Key
                String key = keys.nextElement().toString();
                //根据Key获取Value
                String beanPath = props.getProperty(key);
                //反射创建对象
                Object value = Class.forName(beanPath).newInstance();
                //把Key和Value存入容器中
                beans.put(key,value);
            }
        } catch (Exception e) {
            System.out.println("初始化properties失败！");
        }
    }

    /**
     * 根据bean的名称获取对象
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName){
        return beans.get(beanName);
    }




    /**
     * 根据bean的名称获取bean对象
     * @param beanName
     * @return
     */
    /*public static Object getBean(String beanName){
        Object bean = null;
        String beanPath = props.getProperty(beanName);
        try {
            bean = Class.forName(beanPath).newInstance();//newInstance()：每次都会调用默认构造函数创建对象
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }*/
}
