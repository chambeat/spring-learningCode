package com.chm.dao.impl;

import com.chm.dao.IAccountDao;

/*
 * 账户的持久层实现类
 */
public class AccountDaoImpl implements IAccountDao {
    public void saveAccount() {
        System.out.println("已保存账户！");
    }
}
