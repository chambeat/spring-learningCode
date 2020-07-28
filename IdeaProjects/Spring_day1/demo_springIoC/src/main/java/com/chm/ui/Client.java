package com.chm.ui;

import com.chm.dao.IAccountDao;
import com.chm.service.IAccountService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;


/*
 * 模拟一个表现层，用于调用业务层
 */
public class Client {
    /**
     * 获取Spring的IoC核心容器，并根据id获取对象
     *
     * ApplicationContext的三个常用实现类：
     *      ClassPathXmlApplicationContext：可以加载类路径下的配置文件，要求配置文件必须在类路径下，否则无法加载。
     *      FileSystemXmlApplicationContext：可以加载磁盘任意路径下的配置文件（必须有访问权限）。
     *      AnnotationConfigApplicationContext：用于读取注解，创建容器。（下一个Project会介绍）
     *
     * 核心容器的两个接口引发的问题：
     *  ApplicationContext：     适用于单例对象（注意：ApplicationContext接口在开发中更常用）
     *      在构建核心容器时，创建对象采取的策略是“立即加载”，即只要一读取完配置文件，就马上创建配置文件中配置的对象。
     *  BeanFactory：            适用于多例对象
     *      在构建核心容器时，创建对象采取的策略是“延迟加载”，即只有当根据id获取对象时，才真正地创建对象。
     *
     * @param args
     */
    public static void main(String[] args) {
        //1.获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        ApplicationContext ac = new FileSystemXmlApplicationContext("D:\\myCode_Spring\\IdeaProjects\\demo_springIoC\\src\\main\\resources\\bean.xml");
        //2.根据id获取bean对象
        IAccountService as = (IAccountService)ac.getBean("accountService");
        IAccountDao ad = (IAccountDao)ac.getBean("accountDao");

        System.out.println(as);
        System.out.println(ad);
        as.saveAccount();


        /*
         * BeanFactory延迟创建对象
         */
//        org.springframework.core.io.Resource rs = new ClassPathResource("bean.xml");
//        BeanFactory bf = new XmlBeanFactory(rs);
//        IAccountService as = (IAccountService)bf.getBean("accountService");
//        System.out.println(as);
    }
}
