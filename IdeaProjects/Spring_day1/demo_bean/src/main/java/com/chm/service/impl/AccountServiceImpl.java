package com.chm.service.impl;

import com.chm.service.IAccountService;

/*
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

    public AccountServiceImpl() {
        System.out.println("---- 成功创建核心容器对象 ----");
    }

    public void saveAccount() {
        System.out.println("已执行service中的saveAccount方法");
    }

    public void init() {
        System.out.println("已初始化对象！");
    }

    public void destroy() {
        System.out.println("已销毁对象！");
    }
}
