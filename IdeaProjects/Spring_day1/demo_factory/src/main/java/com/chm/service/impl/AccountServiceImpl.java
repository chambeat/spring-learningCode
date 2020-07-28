package com.chm.service.impl;

import com.chm.dao.IAccountDao;
import com.chm.dao.impl.AccountDaoImpl;
import com.chm.factory.BeanFactory;
import com.chm.service.IAccountService;

/*
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {
    //private IAccountDao accountDao = new AccountDaoImpl();
    private IAccountDao accountDao = (IAccountDao) BeanFactory.getBean("accountDao");

    public void saveAccount() {
        accountDao.saveAccount();
    }
}
