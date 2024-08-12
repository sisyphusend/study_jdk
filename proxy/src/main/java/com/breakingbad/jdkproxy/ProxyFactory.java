package com.breakingbad.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory implements InvocationHandler {
    //被代理对象
    private Object target;

    public Object bind(Object target){
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        if(method.getName() == "addBook"){
            System.out.println("开启事务");
            result = method.invoke(target,args);
            System.out.println("关闭事务");
        }else { result = method.invoke(target,args);}

        return result;
    }
}
