package com.breakingbad.staticproxy;

public class Test {
    public static void main(String[] args) {
        // 创建被代理对象
        AccountImpl account = new AccountImpl();
        //创建代理对象
        AccountProxy accountProxy = new AccountProxy(account);

        accountProxy.queryAccount();
        accountProxy.updateAccount();
    }
}
