package com.breakingbad.cglibproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/*
* 用cglib 生成代理对象工厂
* */
public class ProxyFactory implements MethodInterceptor {


    //生成代理对象
    public Object bind(Object target){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        Object result = null;
        System.out.println("前置方法");
        result = methodProxy.invokeSuper(o,args);
        System.out.println("后置方法");
        return result;
    }
}
