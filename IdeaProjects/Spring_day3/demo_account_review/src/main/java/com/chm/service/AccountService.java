package com.chm.service;

import com.chm.domain.Account;

import java.util.List;

public interface AccountService {
    /* 查询所有账户 */
    List<Account> findAll();

    /* 根据id查询一个 */
    Account findById(Integer id);

    /* 保存账户 */
    void saveAccount(Account account);

    /* 更新账户 */
    void updateAccount(Account account);

    /* 删除账户 */
    void deleteAccount(Integer id);

    /**
     * 转账
     *
     * @param sourceName 转出账户
     * @param targetName 转入账户
     * @param money      转账金额
     */
    void transfer(String sourceName, String targetName, Float money);
}
