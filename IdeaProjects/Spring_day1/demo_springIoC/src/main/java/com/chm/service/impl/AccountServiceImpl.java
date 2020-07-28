package com.chm.service.impl;

import com.chm.dao.IAccountDao;
import com.chm.dao.impl.AccountDaoImpl;
import com.chm.service.IAccountService;

/*
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {
    private IAccountDao accountDao = new AccountDaoImpl();

    //构造函数
    public AccountServiceImpl(){
        System.out.println("已创建对象！");
    }

    public void saveAccount() {
        accountDao.saveAccount();
    }
}
