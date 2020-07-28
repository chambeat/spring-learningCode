package com.chm.service.impl;

import com.chm.dao.IAccountDao;
import com.chm.factory.BeanFactory;
import com.chm.service.IAccountService;

public class AccountServiceImpl implements IAccountService {
    private IAccountDao ad = (IAccountDao) BeanFactory.getBean("accountDao");

    @Override
    public void saveAccount() {
        ad.saveAccount();
    }
}
