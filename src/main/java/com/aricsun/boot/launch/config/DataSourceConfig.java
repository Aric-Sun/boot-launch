package com.aricsun.boot.launch.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * 配置双数据源操作数据库
 * @author AricSun
 * @date 2020.12.15 17:34
 */
@Configuration
public class DataSourceConfig {

    @Primary  // 当一个接口有多个实现类（对象）的时候，默认选择这个实现类
    @Bean("primaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.primary")  // demo
    public DataSource primaryDataSource(){
        return DataSourceBuilder.create().build();
    }
    @Bean("secondaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.secondary")  // demo2
    public DataSource secondaryDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean("primaryJdbcTemplate")
    public JdbcTemplate primaryJdbcTemplate(
            @Qualifier("primaryDataSource") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
    @Bean("secondaryJdbcTemplate")
    public JdbcTemplate secondaryJdbcTemplate(
            @Qualifier("secondaryDataSource") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }


}
