package com.chm.dao;

import com.chm.domain.Account;

import java.util.List;

public interface AccountDao {
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
     * 根据名称查询账户
     *
     * @param name
     * @return  如果有唯一的一个结果则返回
     *          如果没有结果则返回null
     *          如果结果集超过一个则抛异常
     */
    Account findByName(String name);
}
