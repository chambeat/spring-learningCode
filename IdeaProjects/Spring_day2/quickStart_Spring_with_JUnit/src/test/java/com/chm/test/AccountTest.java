package com.chm.test;

import com.chm.config.SpringConfig;
import com.chm.domain.Account;
import com.chm.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)//将JUnit中的Runner(运行器)替换成Spring中的运行器，使得可以创建容器，以便实现依赖注入
@ContextConfiguration(classes = SpringConfig.class)//告知Spring创建IoC容器的方式并创建容器，此处是基于注解(类)的方式
public class AccountTest {
    @Autowired//自动按类型注入
    private AccountService as;


    @Test
    public void testFindAll() {
        List<Account> accounts = as.findAll();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne() {
        Account account = as.findById(3);
        System.out.println(account);
    }

    @Test
    public void testSave() {
        Account account = new Account();
        account.setName("test_annotation_ioc");
        account.setMoney(5000f);
        as.saveAccount(account);
    }

    @Test
    public void testUpdate() {
        Account account = as.findById(9);
        account.setMoney(6000f);
        as.updateAccount(account);
        System.out.println(account);
    }

    @Test
    public void testDelete() {
        as.deleteAccount(9);
    }
}
