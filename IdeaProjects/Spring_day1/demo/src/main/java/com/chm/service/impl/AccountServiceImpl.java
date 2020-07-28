package com.chm.service.impl;

import com.chm.dao.IAccountDao;
import com.chm.service.IAccountService;

import java.util.*;

public class AccountServiceImpl implements IAccountService {
    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void saveAccount() {
        accountDao.saveAccount();
    }
}
