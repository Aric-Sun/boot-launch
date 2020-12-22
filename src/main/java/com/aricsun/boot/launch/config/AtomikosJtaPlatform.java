//package com.aricsun.boot.launch.config;
//
//import org.hibernate.engine.transaction.jta.platform.internal.AbstractJtaPlatform;
//
//import javax.annotation.Resource;
//import javax.transaction.TransactionManager;
//import javax.transaction.UserTransaction;
//
///**
// * JPA+Atomikos实现分布式事务(P37)
// * @author AricSun
// * @date 2020.12.22 2:21
// */
//public class AtomikosJtaPlatform extends AbstractJtaPlatform {
//
//    private static final long serialVersionUID = 1L;
//
//    static TransactionManager transactionManager;
//    static UserTransaction transaction;
//
//    @Override
//    protected TransactionManager locateTransactionManager() {
//        return transactionManager;
//    }
//
//    @Override
//    protected UserTransaction locateUserTransaction() {
//        return transaction;
//    }
//}
