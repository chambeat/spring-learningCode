package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

public class TxConfig {
    @Bean("txManager")
    public PlatformTransactionManager createTxManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
