package com.learn.demo.config.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyVetoException;

@Configuration
@MapperScan("com.learn.demo.dao")
public class DataSourceConfiguration {

    @Value("${jdbc.driver}") private String jdbcDriver;
    @Value("${jdbc.url}")private String jdbcUrl;
    @Value("${jdbc.username}")private String jdbcUsername;
    @Value("${jdbc.password}")private String jdbcPassword;
    @Bean(name="dataSource")
    public ComboPooledDataSource createDataSource() throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource=new ComboPooledDataSource();
        comboPooledDataSource.setDriverClass(jdbcDriver);
        comboPooledDataSource.setJdbcUrl(jdbcUrl);
        comboPooledDataSource.setUser(jdbcUsername);
        comboPooledDataSource.setPassword(jdbcPassword);
        //关闭连接后不自动commit
        comboPooledDataSource.setAutoCommitOnClose(false);
        return comboPooledDataSource;
    }
}
