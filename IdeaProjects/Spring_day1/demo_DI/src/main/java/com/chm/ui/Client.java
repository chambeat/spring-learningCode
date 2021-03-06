package com.chm.ui;

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
     *
     * @param args
     */
    public static void main(String[] args) {
        //1.创建核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取bean对象
//        IAccountService as = (IAccountService)ac.getBean("accountService");
//        as.saveAccount();
//        IAccountService as = (IAccountService)ac.getBean("accountService_2");
//        as.saveAccount();


        IAccountService as = (IAccountService)ac.getBean("accountService_3");
        as.saveAccount();
    }
}
