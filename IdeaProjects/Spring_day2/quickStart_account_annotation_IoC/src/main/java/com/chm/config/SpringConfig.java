package com.chm.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * 注解的父配置类
 */
@Configuration
@ComponentScan(basePackages = "com.chm")//指定要扫描的包
@Import(JDBCConfig.class)
@PropertySource("classpath:jdbcConfig.properties")
public class SpringConfig {

}
