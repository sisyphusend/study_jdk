package com.breakingbad.staticproxy;

public class AccountImpl implements Account{
    @Override
    public void queryAccount() {
        System.out.println("--查询账户--");
    }

    @Override
    public void updateAccount() {
        System.out.println("--更新账户--");
    }
}
