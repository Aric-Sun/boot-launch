package com.aricsun.boot.launch.config;

import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

/**
 * 参照 com.aricsun.boot.launch.config.JPAPrimaryConfig
 * 固定模板，只需要改变两个包路径
 * @author AricSun
 * @date 2020.12.19 21:56
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        //实体管理
        entityManagerFactoryRef="entityManagerFactorySecondary",
        //事务管理
        transactionManagerRef="transactionManagerSecondary",
        //实体扫描,设置Repository所在位置
        basePackages= { "com.aricsun.boot.launch.dao.demo2" })
public class JPASecondaryConfig {

    @Resource
    private JpaProperties jpaProperties;

    @Resource
    private HibernateProperties hibernateProperties;

    @Bean(name = "secondaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.secondary")  // application.yml 的 Secondary 数据源配置
    public DataSource secondaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "entityManagerSecondary")  // Secondary 实体管理器
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactorySecondary(builder).getObject().createEntityManager();
    }

    @Bean(name = "entityManagerFactorySecondary")  // Secondary 实体工厂
    public LocalContainerEntityManagerFactoryBean entityManagerFactorySecondary (EntityManagerFactoryBuilder builder){

        Map<String, Object> properties = hibernateProperties.determineHibernateProperties(
                jpaProperties.getProperties(), new HibernateSettings()
        );

        return builder.dataSource(secondaryDataSource())
                .properties(properties)
                .packages("com.aricsun.boot.launch.model.demo2")  // 替换成自己的实体类位置
                .persistenceUnit("secondaryPersistenceUnit")
                .build();
    }

    @Bean(name = "transactionManagerSecondary")  // Secondary 事务管理器
    public PlatformTransactionManager transactionManagerSecondary(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactorySecondary(builder).getObject());
    }
}
