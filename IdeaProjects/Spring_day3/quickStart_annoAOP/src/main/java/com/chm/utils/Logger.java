package com.chm.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 用于记录日志的工具类：提供了公共的代码。
 */
@Component("logger")
@Aspect
public class Logger {
    @Pointcut("execution(* com.chm.service.impl.*.*(..))")
    public void pc1() {
    }

    /**
     * 前置通知
     */
//    @Before("pc1()")
    public void printLogBefore() {
        System.out.println("前置通知");
    }

    /**
     * 后置通知
     */
//    @AfterReturning("pc1()")
    public void printLogAfterReturning() {
        System.out.println("后置通知");
    }

    /**
     * 异常通知
     */
//    @AfterThrowing("pc1()")
    public void printLogAfterThrowing() {
        System.out.println("异常通知");
    }

    /**
     * 最终通知
     */
//    @After("pc1()")
    public void printLogAfter() {
        System.out.println("最终通知");
    }

    /*
     * 环绕通知
     * 问题：
     *      当配置了环绕通知之后，切入点方法没有执行，而通知方法执行了。
     * 分析：
     *      通过对比动态代理中的环绕通知代码，发现动态代理的环绕通知有明确的切入点方法调用，而本工程的代码中没有。
     * 解决：
     *      Spring框架为我们提供了一个接口：ProceedingJoinPoint。该接口的一个方法proceed()就相当于明确调用切入点方法。
     *      该接口可以作为环绕通知的方法参数，在程序执行时，Spring框架会为我们提供该接口的实现类，以供我们使用。
     * 总结：
     *      Spring中的环绕通知：是Spring框架为我们提供的一种可以在代码中手动控制增强方法何时执行的方式。
     *
     * @param pjp
     * @return
     */
    @Around("pc1()")
    public Object printLogAround(ProceedingJoinPoint pjp) {
        try {
            Object[] args = pjp.getArgs();//得到方法执行所需的参数
            System.out.println("--前置通知--");
            Object rtValue = pjp.proceed(args);//明确调用切入点方法(业务层方法)
            System.out.println("--后置通知--");
            return rtValue;
        } catch (Throwable t) {
            System.out.println("--异常通知--");
            throw new RuntimeException(t);
        } finally {
            System.out.println("--最终通知--");
        }
    }
}
