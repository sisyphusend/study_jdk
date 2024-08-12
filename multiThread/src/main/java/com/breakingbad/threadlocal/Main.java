package com.breakingbad.threadlocal;

// 创建三个线程，在线程中保存一个int变量，表示调用某个方法的次数

import java.util.Random;

public class Main {

    public static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);

    public static void unknownMethod(){
        System.out.println(Thread.currentThread().getName());
    }
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            new Thread(()->{
                for (int j = 0; j < 5 + new Random().nextInt(6); j++) {
                    threadLocal.set(threadLocal.get() + 1);
                    unknownMethod();
                }
                System.out.println(Thread.currentThread().getName() + ":" + threadLocal.get());
            }).start();
        }
        Thread.sleep(1000);

    }



}
