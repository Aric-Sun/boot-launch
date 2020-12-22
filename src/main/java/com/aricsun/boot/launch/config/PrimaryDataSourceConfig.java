package com.aricsun.boot.launch.config;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * mybatis多数据源
 * +atomikos
 * @author AricSun
 * @date 2020.12.22 22:06
 */
@Configuration
@MapperScan(basePackages = "com.aricsun.boot.launch.generator.demo",
        sqlSessionTemplateRef = "primarySqlSessionTemplate")
public class PrimaryDataSourceConfig {

    @Primary
    @Bean(name = "primaryDataSource")
    @ConfigurationProperties(prefix = "primarydb")  // demo application-dev.yml
    public DataSource primaryDataSource(){
        return new AtomikosDataSourceBean();  // 支持分布式事务的数据源
    }

    @Primary
    @Bean(name = "primarySqlSessionFactory")
    public SqlSessionFactory primarySqlSessionFactory(
            @Qualifier("primaryDataSource") DataSource dataSource) throws Exception{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        // 设置读取mybatis xml文件的位置
        bean.setMapperLocations(new PathMatchingResourcePatternResolver()
                        .getResources("classpath:generator/demo/*.xml"));
        return bean.getObject();
    }

    // 由于分布式事务要使用统一的事务管理器，故停用单一的事务管理器
//    @Primary
//    @Bean(name = "primaryTransactionManager")
//    public DataSourceTransactionManager primaryTransactionManager(
//            @Qualifier("primaryDataSource") DataSource dataSource){
//        return new DataSourceTransactionManager(dataSource);
//    }

    // 函数操作模板类
    @Primary
    @Bean(name = "primarySqlSessionTemplate")
    public SqlSessionTemplate primarySqlSessionTemplate(
            @Qualifier("primarySqlSessionFactory") SqlSessionFactory sqlSessionFactory
    ) throws Exception{
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
