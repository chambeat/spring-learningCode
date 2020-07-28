package com.chm.factory;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.lang.String;
import java.lang.Exception;

/**
 * 工厂模式升级版(单例对象)
 */
public class BeanFactory {
    private static Map<String, Object> beans;
    public static Properties props;

    static {
        beans = new HashMap<String, Object>();
        props = new Properties();
        InputStream is = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
        try {
            props.load(is);
            Enumeration keys = props.keys();
            while (keys.hasMoreElements()) {
                String key = keys.nextElement().toString();
                String beanPath = props.getProperty(key);
                Object value = Class.forName(beanPath).newInstance();
                beans.put(key, value);
            }
        } catch (Exception e) {
            System.out.println("初始化properties失败！");
        }
    }

    public static Object getBean(String beanName) {
        return beans.get(beanName);
    }
}
