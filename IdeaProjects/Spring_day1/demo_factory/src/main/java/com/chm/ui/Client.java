package com.chm.ui;

import com.chm.factory.BeanFactory;
import com.chm.service.IAccountService;
import com.chm.service.impl.AccountServiceImpl;

/*
 * 模拟一个表现层，用于调用业务层
 */
public class Client {
    public static void main(String[] args) {
        //IAccountService as = new AccountServiceImpl();
        for (int i = 0; i < 5; i++) {
            //创建多例对象as
            IAccountService as = (IAccountService) BeanFactory.getBean("accountService");
            System.out.println(as);
        }
        //as.saveAccount();
    }
}
