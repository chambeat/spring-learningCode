package com.chm.service.impl;

import com.chm.service.AccountService;
import org.springframework.stereotype.Service;

/**
 * 账户的业务层实现类
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Override
    public void saveAccount() {
        System.out.println("save方法执行");
//        int i = 1 / 0;//手动制造异常
    }

    @Override
    public void updateAccount(int i) {
        System.out.println("update方法执行");
    }

    @Override
    public int deleteAccount() {
        System.out.println("delete方法执行");
        return 0;
    }
}
