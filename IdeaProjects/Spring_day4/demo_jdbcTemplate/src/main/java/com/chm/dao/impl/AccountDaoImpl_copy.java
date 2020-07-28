package com.chm.dao.impl;

import com.chm.dao.AccountDao;
import com.chm.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

public class AccountDaoImpl_copy extends JdbcDaoSupport implements AccountDao {

    @Override
    public Account findById(Integer id) {
        List<Account> accounts = super.getJdbcTemplate().query("select * from account where id = ?", new BeanPropertyRowMapper<Account>(Account.class), id);
        return (accounts.isEmpty() ? null : accounts.get(0));
    }

    @Override
    public Account findByName(String name) {
        List<Account> accounts = super.getJdbcTemplate().query("select * from account where name = ?", new BeanPropertyRowMapper<Account>(Account.class), name);
        if (accounts.isEmpty()) {
            return null;
        }
        if (accounts.size() > 1) {
            throw new RuntimeException("错误：结果集不唯一！");
        }
        return accounts.get(0);
    }

    @Override
    public void updateAccount(Account account) {
        super.getJdbcTemplate().update("update account set money = ? where id = ?", account.getMoney(), account.getId());
    }
}
