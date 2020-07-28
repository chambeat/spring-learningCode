package com.chm.service.impl;

import com.chm.dao.AccountDao;
import com.chm.domain.Account;
import com.chm.service.AccountService;

import java.util.List;

/**
 * 事务控制应该都放在业务层
 */
public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    /**
     * 根据id查询账户信息
     */
    public Account findById(Integer accountId) {
        return accountDao.findById(accountId);
    }

    /**
     * 转账
     *
     * @param sourceName 转出账户
     * @param targetName 转入账户
     * @param money      转账金额
     */
    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        System.out.println("transfer()方法开始执行");
        //2.1.查询转出账户
        Account source = accountDao.findByName(sourceName);
        //2.2.查询转入账户
        Account target = accountDao.findByName(targetName);
        //2.3.转出账户减钱
        source.setMoney(source.getMoney() - money);
        //2.4.转入账户加钱
        target.setMoney(target.getMoney() + money);
        //2.5.更新转出账户
        accountDao.updateAccount(source);
//        int i = 1 / 0;//手动制造异常
        //2.6.更新转入账户
        accountDao.updateAccount(target);
        System.out.println("transfer()方法成功执行");
    }
}
