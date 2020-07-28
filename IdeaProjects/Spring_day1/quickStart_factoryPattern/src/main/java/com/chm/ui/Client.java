package com.chm.ui;

import com.chm.factory.BeanFactory;
import com.chm.service.IAccountService;

public class Client {
    public static void main(String[] args) {
        IAccountService as = (IAccountService) BeanFactory.getBean("accountService");
        as.saveAccount();
    }
}
