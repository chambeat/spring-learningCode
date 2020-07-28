package com.chm.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * 和事务管理相关的工具类：包含开启事务、提交事务、回滚事务、释放资源。
 */
@Component("transactionManager")
@Aspect
public class TransactionManager {
    @Autowired
    private ConnectionUtils connectionUtils;

    @Pointcut("execution(* com.chm.service.impl.AccountServiceImpl.*(..))")
    public void p1() {
    }

    /**
     * 开启事务
     */
//    @Before("p1()")
    public void beginTransaction() {
        try {
            connectionUtils.getThreadConnection().setAutoCommit(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 提交事务
     */
//    @AfterReturning("p1()")
    public void commit() {
        try {
            connectionUtils.getThreadConnection().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 回滚事务
     */
//    @AfterThrowing("p1()")
    public void rollback() {
        try {
            connectionUtils.getThreadConnection().rollback();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 释放资源
     */
//    @After("p1()")
    public void release() {
        try {
            connectionUtils.getThreadConnection().close();
            connectionUtils.removeThreadConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 环绕通知：可以解决以上4个通知所引起的调用顺序问题。
     *
     * @param pjp
     * @return
     */
    @Around("p1()")
    public Object aroundAdvice(ProceedingJoinPoint pjp) {
        Object[] args = pjp.getArgs();
        try {
            this.beginTransaction();//前置通知
            Object retVal = pjp.proceed(args);
            this.commit();//后置通知
            return retVal;
        } catch (Throwable throwable) {
            this.rollback();//异常通知
            throw new RuntimeException(throwable);
        } finally {
            this.release();//最终通知
        }
    }
}
