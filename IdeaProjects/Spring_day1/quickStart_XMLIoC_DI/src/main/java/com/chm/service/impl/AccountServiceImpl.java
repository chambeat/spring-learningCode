package com.chm.service.impl;

import com.chm.service.IAccountService;

import java.util.*;

public class AccountServiceImpl implements IAccountService {
    private String[] myStrs;
    private List myList;
    private Set mySet;
    private Map myMap;
    private Properties myProps;

    public void setMyStrs(String[] myStrs) {
        this.myStrs = myStrs;
    }

    public void setMyList(List myList) {
        this.myList = myList;
    }

    public void setMySet(Set mySet) {
        this.mySet = mySet;
    }

    public void setMyMap(Map myMap) {
        this.myMap = myMap;
    }

    public void setMyProps(Properties myProps) {
        this.myProps = myProps;
    }

    /*private String name;
    private Integer age;
    private Date birthday;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }*/
/*
    public AccountServiceImpl(String username, Integer age, Date birthday) {
        this.username = username;
        this.age = age;
        this.birthday = birthday;
    }
*/

    public void saveAccount() {
        System.out.println("saveAccount方法执行了");
        System.out.println("-----------------------");
        System.out.println(Arrays.toString(myStrs));
        System.out.println(myList);
        System.out.println(mySet);
        System.out.println(myMap);
        System.out.println(myProps);
    }
}
