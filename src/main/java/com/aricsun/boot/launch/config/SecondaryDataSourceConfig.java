//package com.aricsun.boot.launch.config;
//
//import com.atomikos.jdbc.AtomikosDataSourceBean;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//
//import javax.sql.DataSource;
//
///**
// * 基本相同于com.aricsun.boot.launch.config.PrimaryDataSourceConfig
// * 注释掉，由于测试Spring data rest，搭配spring data jpa（45）
// * @author AricSun
// * @date 2020.12.22 22:06
// */
//@Configuration
//@MapperScan(basePackages = "com.aricsun.boot.launch.generator.demo2",
//        sqlSessionTemplateRef = "secondarySqlSessionTemplate")
//public class SecondaryDataSourceConfig {
//
//    @Bean(name = "secondaryDataSource")
//    @ConfigurationProperties(prefix = "secondarydb")  // demo2
//    public DataSource secondaryDataSource(){
//        return new AtomikosDataSourceBean();
//    }
//
//    @Bean(name = "secondarySqlSessionFactory")
//    public SqlSessionFactory secondarySqlSessionFactory(
//            @Qualifier("secondaryDataSource") DataSource dataSource) throws Exception{
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSource);
//        // 设置读取mybatis xml文件的位置
//        bean.setMapperLocations(new PathMatchingResourcePatternResolver()
//                        .getResources("classpath:generator/demo2/*.xml"));
//        return bean.getObject();
//    }
//
//     // 由于分布式事务要使用统一的事务管理器，故停用单一的事务管理器
////    @Bean(name = "secondaryTransactionManager")
////    public DataSourceTransactionManager secondaryTransactionManager(
////            @Qualifier("secondaryDataSource") DataSource dataSource){
////        return new DataSourceTransactionManager(dataSource);
////    }
//
//    // 函数操作模板类
//    @Bean(name = "secondarySqlSessionTemplate")
//    public SqlSessionTemplate secondarySqlSessionTemplate(
//            @Qualifier("secondarySqlSessionFactory") SqlSessionFactory sqlSessionFactory
//    ) throws Exception{
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
//}
