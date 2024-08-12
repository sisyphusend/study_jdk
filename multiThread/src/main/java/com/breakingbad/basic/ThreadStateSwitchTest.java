package com.breakingbad.basic;

import org.junit.jupiter.api.Test;

/*
* 描述线程状态的切换
* java 中线程状态有 6种
* new  创建但是没有start
* */
public class ThreadStateSwitchTest {
    @Test
    public void testNewState(){
        Thread t1 = new Thread(()-> System.out.println(Thread.currentThread().getName()),"t1");
        System.out.println(t1.getState()); //NEW
    }

    @Test
    public void TestRunnableToBlocked(){

    }
}
