package com.aricsun.boot.launch.config;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * 配置双数据源操作数据库(P31)
 * JTA-atomikos,分布式事务（P32）
 * @author AricSun
 * @date 2020.12.15 17:34
 */
@Configuration
public class DataSourceConfig {

    /*@Primary  // 当一个接口有多个实现类（对象）的时候，默认选择这个实现类
    @Bean("primaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.primary")  // demo
    public DataSource primaryDataSource(){
        return DataSourceBuilder.create().build();
    }
    @Bean("secondaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.secondary")  // demo2
    public DataSource secondaryDataSource(){
        return DataSourceBuilder.create().build();
    }*/

    @Bean(initMethod = "init", destroyMethod = "close", name = "primaryDataSource")
    @Primary
    @ConfigurationProperties(prefix = "primarydb")
    public DataSource primaryDataSource(){
        // 这里是关键，返回的是AtomikosDataSourceBean，所有的配置属性也都是注入到这个类里面
        return new AtomikosDataSourceBean();
    }

    @Bean(initMethod = "init", destroyMethod = "close", name = "secondaryDataSource")
    @ConfigurationProperties(prefix = "secondarydb")
    public DataSource secondaryDataSource(){
        // 这里是关键，返回的是AtomikosDataSourceBean，所有的配置属性也都是注入到这个类里面
        return new AtomikosDataSourceBean();
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
