package com.chm.dao.impl;

import com.chm.dao.IAccountDao;

public class AccountDaoImpl implements IAccountDao {
    public void saveAccount() {
        System.out.println("dao中的saveAccount方法被执行了");
    }
}
