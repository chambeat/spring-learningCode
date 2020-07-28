package com.chm.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "com.chm")
@Import({JdbcConfig.class, TxConfig.class})
@PropertySource("jdbcConfig.properties")
@EnableTransactionManagement
public class AppConfig {
}
