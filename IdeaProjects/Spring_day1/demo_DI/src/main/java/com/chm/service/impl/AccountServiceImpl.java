package com.chm.service.impl;

import com.chm.service.IAccountService;

import java.util.Date;

/*
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

    //如果是经常变化的数据，并不适用于注入的方式
    private String name;
    private Integer age;
    private Date birthday;

    //构造函数注入
    public AccountServiceImpl(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public void saveAccount() {
        System.out.println("已执行service中的saveAccount方法");
        System.out.println(name + "\n" + age + "\n" + birthday);
    }
}
