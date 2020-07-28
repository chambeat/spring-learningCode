package com.chm.jdbcTemplate;

import com.chm.dao.AccountDao;
import com.chm.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateDemo4 {
    public static void main(String[] args) {
        //创建容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //获取对象
        AccountDao accountDao = ac.getBean("accountDao", AccountDao.class);

        /*根据id查询一个*/
        Account account = accountDao.findById(1);
        System.out.println(account);

        /*根据名称查询账户*/
//        Account account = accountDao.findByName("ccc");
//        System.out.println(account);

        /*更新账户*/
//        account.setMoney(1000F);
//        accountDao.updateAccount(account);
//        System.out.println(account);
    }
}
