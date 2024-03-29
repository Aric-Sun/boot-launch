//package com.aricsun.boot.launch.config;
//
//import com.atomikos.jdbc.AtomikosDataSourceBean;
//import com.mysql.cj.jdbc.MysqlXADataSource;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.DependsOn;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaVendorAdapter;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//
//import javax.annotation.Resource;
//import javax.sql.DataSource;
//import java.sql.SQLException;
//import java.util.HashMap;
//
///**
// * 基本同于com.aricsun.boot.launch.config.JPAPrimaryConfig
// * @author AricSun
// * @date 2020.12.22 15:03
// */
//@Configuration
//@DependsOn("transactionManager")
//@EnableJpaRepositories(basePackages = "com.aricsun.boot.launch.dao.demo2",  // 注意这里
//        entityManagerFactoryRef = "secondaryEntityManager",
//        transactionManagerRef = "transactionManager")
//public class JPASecondaryConfig {
//
//    @Resource
//    private JpaVendorAdapter jpaVendorAdapter;
//
//    // secondary
//    @Bean(name = "secondaryDataSourceProperties")
//    @ConfigurationProperties(prefix = "spring.datasource.secondary")
//    public DataSourceProperties secondaryDataSourceProperties() {
//        return new DataSourceProperties();
//    }
//
//    @Bean(name = "secondaryDataSource", initMethod = "init", destroyMethod = "close")
//    @ConfigurationProperties(prefix = "spring.datasource.secondary")
//    public DataSource secondaryDataSource() throws SQLException{
//        MysqlXADataSource mysqlXADataSource = new MysqlXADataSource();
//        mysqlXADataSource.setUrl(secondaryDataSourceProperties().getUrl());
//        mysqlXADataSource.setPinGlobalTxToPhysicalConnection(true);
//        mysqlXADataSource.setPassword(secondaryDataSourceProperties().getPassword());
//        mysqlXADataSource.setUser(secondaryDataSourceProperties().getUsername());
//        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
//        xaDataSource.setXaDataSource(mysqlXADataSource);
//        xaDataSource.setUniqueResourceName("secondary");
//        xaDataSource.setBorrowConnectionTimeout(60);
//        xaDataSource.setMaxPoolSize(20);
//        return xaDataSource;
//    }
//
//    @Bean(name = "secondaryEntityManager")
//    @DependsOn("transactionManager")  //实体管理器
//    public LocalContainerEntityManagerFactoryBean secondaryEntityManager() throws Throwable{
//
//        HashMap<String, Object> properties = new HashMap<>();
//        properties.put("hibernate.transaction.jta.platform", AtomikosJtaPlatform.class.getName());
//        properties.put("javax.persistence.transactionType", "JTA");
//        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
//        entityManager.setJtaDataSource(secondaryDataSource());
//        entityManager.setJpaVendorAdapter(jpaVendorAdapter);
//        // 这星要修改成主数据源的扫描包
//        entityManager.setPackagesToScan("com.aricsun.boot.launch.model.demo2");
//        entityManager.setPersistenceUnitName("secondaryPersistenceUnit");
//        entityManager.setJpaPropertyMap(properties);
//        return entityManager;
//    }
//
//}
