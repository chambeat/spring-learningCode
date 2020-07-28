package com.chm.service;

import com.chm.domain.Account;

/**
 * 账户的业务层接口
 */
public interface AccountService {
    /**
     * 根据id查询账户信息
     * @param accountId
     * @return
     */
    Account findById(Integer accountId);

    /**
     * 转账
     * @param sourceName    转出账户名称
     * @param targetName    转入账户名称
     * @param money         转账金额
     */
    void transfer(String sourceName, String targetName, Float money);
}
