package com.chm.test;

import com.chm.config.SpringConfig;
import com.chm.domain.Account;
import com.chm.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class AccountTest {
    private ApplicationContext ac;
    private AccountService as;

    @Before
    public void init() {
        ac = new AnnotationConfigApplicationContext(SpringConfig.class);
        as = (AccountService) ac.getBean("accountService");
    }

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
