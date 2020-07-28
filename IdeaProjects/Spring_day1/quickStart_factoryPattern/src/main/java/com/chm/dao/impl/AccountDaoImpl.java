package com.chm.dao.impl;

import com.chm.dao.IAccountDao;

public class AccountDaoImpl implements IAccountDao {
    @Override
    public void saveAccount() {
        System.out.println("已保存账户");
    }
}
