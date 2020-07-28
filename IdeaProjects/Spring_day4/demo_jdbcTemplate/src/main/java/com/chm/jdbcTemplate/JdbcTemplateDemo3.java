package com.chm.jdbcTemplate;

import com.chm.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcTemplateDemo3 {
    public static void main(String[] args) {
        //创建容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //获取对象
        JdbcTemplate jt = ac.getBean("jt", JdbcTemplate.class);

        /* 执行操作 */
        //1.保存
//        jt.update("insert into account(`name`,`money`) values(?,?)", "t_insert", 15000F);

        //2.更新
//        jt.update("update account set money = ? where id = ?", 20000F, 24);

        //3.删除
//        jt.update("delete from account where id = ?", 24);

        //4.查询所有
//        List<Account> accounts = jt.query("select * from account where money > ?", new BeanPropertyRowMapper<Account>(Account.class), 1000F);
//        for (Account account : accounts) {
//            System.out.println(account);
//        }

        //5.查询一个
//        List<Account> accounts = jt.query("select * from account where id = ?", new BeanPropertyRowMapper<Account>(Account.class), 13);
//        System.out.println(accounts.isEmpty() ? "没有数据！" : accounts.get(0));

        //6.查询返回一行一列（使用聚合函数，但不使用group by子句）
        Long count = jt.queryForObject("select count(*) from account", Long.class);
        System.out.println("总记录条数为：" + count);
    }
}
