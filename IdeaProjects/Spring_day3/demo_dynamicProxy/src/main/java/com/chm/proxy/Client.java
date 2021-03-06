package com.chm.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 模拟一个消费者
 */
public class Client {
    public static void main(String[] args) {
        final Producer producer = new Producer();//匿名内部类在访问外部成员变量时，外部成员变量必须是final的
//        producer.sellProduct(10000F);

        /*
         * 动态代理：
         *  特点：字节码随用随创建，随用随加载。
         *  作用：在不修改源码的基础上，对方法进行增强。
         *  分类：
         *      1.基于接口的动态代理
         *      2.基于子类的动态代理
         * =================================================
         * 基于接口的动态代理：
         *      涉及的类：Proxy
         *      提供者：JDK官方
         * -------------------------------------------------
         * 如何创建代理对象：
         *      使用Proxy类中的newProxyInstance()方法
         * 创建代理对象的要求：
         *      被代理类最少实现一个接口，如果没有则不能使用。
         * -------------------------------------------------
         * newProxyInstance()方法的参数：
         *      1.ClassLoader：类加载器
         *          作用：用来加载代理对象字节码的。
         *          参数接收的值：被代理对象的类加载器              (固定写法)
         *      2.Class[]：字节码数组
         *          作用：用于使代理对象和被代理对象有相同的方法。
         *          参数接收的值：被代理对象的接口字节码数组         (固定写法)
         *      3.InvocationHandler：
         *          作用：用于提供增强的代码，它是让我们写“如何代理”。
         *          参数接收的值：我们一般是写一个InvocationHandler接口的实现类，通常情况下都是匿名内部类(但不是必须的)。
         *                      * 此接口的实现类都是“谁用谁写”。
         *
         */

        IProducer proxyProducer = (IProducer) Proxy.newProxyInstance(producer.getClass().getClassLoader(), producer.getClass().getInterfaces(), new InvocationHandler() {
            /**
             * 作用：执行被代理对象的任何接口方法时，都会经过invoke()方法。
             * 方法参数的含义
             * @param proxy     代理对象的引用
             * @param method    当前执行的方法
             * @param args      当前执行方法所需的参数
             * @return 和被代理对象方法有相同的返回值
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                /* 增强的代码如下 */
                Object returnValue = null;

                //1.获取方法执行的参数
                Float money = (Float) args[0];
                //2.判断当前方法是否为销售
                if ("sellProduct".equals(method.getName())) {
                    method.invoke(producer, money * 0.8F);
                }

                return returnValue;
            }
        });
        proxyProducer.sellProduct(10000F);
    }
}
