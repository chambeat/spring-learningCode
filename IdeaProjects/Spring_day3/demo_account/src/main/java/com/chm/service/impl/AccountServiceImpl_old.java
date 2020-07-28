package com.chm.service.impl;

import com.chm.dao.AccountDao;
import com.chm.domain.Account;
import com.chm.service.AccountService;
import com.chm.utils.TransactionManager;

import java.util.List;

/**
 * 事务控制应该都放在业务层
 */
public class AccountServiceImpl_old implements AccountService {
    private AccountDao accountDao;
    private TransactionManager txManager;

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> findAll() {
        try {
            //1.开启事务
            txManager.beginTransaction();
            //2.执行操作
            List<Account> accounts = accountDao.findAll();
            //3.提交事务
            txManager.commit();
            //4.返回结果
            return accounts;
        } catch (Exception e) {
            //5.回滚事务
            txManager.rollback();
            throw new RuntimeException(e);
        } finally {
            //6.释放资源
            txManager.release();
        }
    }

    @Override
    public Account findById(Integer id) {
        try {
            //1.开启事务
            txManager.beginTransaction();
            //2.执行操作
            Account account = accountDao.findById(id);
            //3.提交事务
            txManager.commit();
            //4.返回结果
            return account;
        } catch (Exception e) {
            //5.回滚事务
            txManager.rollback();
            throw new RuntimeException(e);
        } finally {
            //6.释放资源
            txManager.release();
        }
    }

    @Override
    public void saveAccount(Account account) {
        try {
            //1.开启事务
            txManager.beginTransaction();
            //2.执行操作
            accountDao.saveAccount(account);
            //3.提交事务
            txManager.commit();
        } catch (Exception e) {
            //4.回滚事务
            txManager.rollback();
            throw new RuntimeException(e);
        } finally {
            //5.释放资源
            txManager.release();
        }
    }

    @Override
    public void updateAccount(Account account) {
        try {
            //1.开启事务
            txManager.beginTransaction();
            //2.执行操作
            accountDao.updateAccount(account);
            //3.提交事务
            txManager.commit();
        } catch (Exception e) {
            //4.回滚事务
            txManager.rollback();
            throw new RuntimeException(e);
        } finally {
            //5.释放资源
            txManager.release();
        }
    }

    @Override
    public void deleteAccount(Integer id) {
        try {
            //1.开启事务
            txManager.beginTransaction();
            //2.执行操作
            accountDao.deleteAccount(id);
            //3.提交事务
            txManager.commit();
        } catch (Exception e) {
            //4.回滚事务
            txManager.rollback();
            throw new RuntimeException(e);
        } finally {
            //5.释放资源
            txManager.release();
        }
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
        try {
            //1.开启事务
            txManager.beginTransaction();
            //2.执行操作
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
            int i = 1 / 0;//手动制造异常
            //2.6.更新转入账户
            accountDao.updateAccount(target);
            //3.提交事务
            txManager.commit();
        } catch (Exception e) {
            //4.回滚事务
            txManager.rollback();
            throw new RuntimeException(e);
        } finally {
            //5.释放资源
            txManager.release();
        }
    }
}
