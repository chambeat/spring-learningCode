package com.chm.jdbcTemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * JdbcTemplate对象的基本用法
 */
public class JdbcTemplateDemo1 {
    public static void main(String[] args) {
        //准备数据源：Spring的内置数据源
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/spring?serverTimezone=GMT");
        ds.setUsername("root");
        ds.setPassword("chm699276");

        //1.创建对象
        JdbcTemplate jt = new JdbcTemplate(ds);
        //2.执行操作
        jt.execute("insert into account(`name`,`money`) values('test_JdbcTemplate_new',10000)");
    }
}
