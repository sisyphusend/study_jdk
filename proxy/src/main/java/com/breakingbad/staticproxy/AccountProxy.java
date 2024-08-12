package com.breakingbad.staticproxy;

public class AccountProxy implements Account{
    private AccountImpl accountImpl;

    public  AccountProxy(AccountImpl accountImpl){
        this.accountImpl = accountImpl;
    }
    @Override
    public void queryAccount() {
        accountImpl.queryAccount();
    }

    @Override
    public void updateAccount() {
        System.out.println("--事务开始--");
        accountImpl.updateAccount();
        System.out.println("--事务结束--");
    }
}
