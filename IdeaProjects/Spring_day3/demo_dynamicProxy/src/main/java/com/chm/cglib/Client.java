package com.chm.cglib;

import com.chm.proxy.IProducer;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 模拟一个消费者
 */
public class Client {
    public static void main(String[] args) {
        final Producer producer = new Producer();//匿名内部类在访问外部成员变量时，外部成员变量必须是final的

        /*
         * 基于子类的动态代理：
         *      涉及的类：Enhancer
         *      提供者：第三方库cglib
         * -------------------------------------------------
         * 如何创建代理对象：
         *      使用Enhancer类中的create()方法
         * 创建代理对象的要求：
         *      被代理类不能是最终类。(因为final修饰的类不能创建子类，也就无法实现基于子类的动态代理)
         * =============================================================================================================
         * create()方法的参数：
         *      1.Class：字节码
         *          参数接收的值：被代理对象的字节码                (固定写法)
         *      2.Callback：
         *          作用：用于提供增强的代码，它是让我们写“如何代理”。
         *          参数接收的值：我们一般是写一个该接口的子接口实现类：MethodInterceptor(接口)，通常情况下都是匿名内部类(但不是必须的)。
         *                      * 此子接口的实现类都是“谁用谁写”。
         *
         */

        Producer cglibProducer = (Producer) Enhancer.create(producer.getClass(), new MethodInterceptor() {
            /**
             * 作用：执行被代理对象的任何方法时，都会经过intercept()方法。
             * @param proxy     代理对象的引用
             * @param method    当前执行的方法
             * @param args      当前执行方法所需的参数
             * ======== 以上三个参数和基于接口的动态代理中invoke方法的参数是一样的 ========
             * @param methodProxy   当前执行方法的代理对象
             * @return 和被代理对象方法有相同的返回值
             * @throws Throwable
             */
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
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

        cglibProducer.sellProduct(12000F);
    }
}
