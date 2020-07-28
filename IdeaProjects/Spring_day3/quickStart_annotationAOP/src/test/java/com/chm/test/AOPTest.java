package com.chm.test;

import com.chm.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest {
    public static void main(String[] args) {
        //1.获取容器
        ApplicationContext ac = new AnnotationConfigApplicationContext(com.chm.config.AppConfig.class);
        //2.获取对象
        AccountService as = (AccountService) ac.getBean("accountService");

        //3.执行方法
        as.saveAccount();
//        as.updateAccount(1);
//        as.deleteAccount();
    }
}
