package com.breakingbad.other;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class SingleTon {
    private static SingleTon singleTon;

    // 防止指令重排序
    volatile private static SingleTon singleTon2;

    private int count;
    private SingleTon(){
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        count = 100;
    }

    public static SingleTon getInstance(){
        if(singleTon == null){
            singleTon = new SingleTon();
        }
        return singleTon;
    }

    synchronized public static SingleTon getThreadSafeInstance(){
        if(singleTon == null){
            singleTon = new SingleTon();
        }
        return singleTon;
    }

    public static SingleTon getDoubleCheckInstance(){
        if(singleTon == null){
            // 对创建实例加锁
            synchronized (SingleTon.class){
                if(singleTon == null){
                    singleTon = new SingleTon();
                }
            }
        }
        return singleTon;
    }


    public static SingleTon getDoubleCheckInstance2(){
        if(singleTon2 == null){
            // 对创建实例加锁
            synchronized (SingleTon.class){
                if(singleTon2 == null){
                    singleTon2 = new SingleTon();
                }
            }
        }
        return singleTon2;
    }


    // 单线程 单例模式 getInstance没有问题
    @Test
    void testGetInstance(){
        Set<SingleTon> set = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            set.add(SingleTon.singleTon);
        }
        System.out.println(set.size());
    }

    // 多线程 单例模式 getThreadSafeInstance 线程安全但是锁的粒度太粗，性能太差
    @Test
    void testGetThreadSafeInstance() throws InterruptedException {
        Set<SingleTon> set = ConcurrentHashMap.newKeySet();
        Thread[] threads = new Thread[100];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() ->{
                set.add(SingleTon.getThreadSafeInstance());
            });
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }
        System.out.println(set.size());
    }

    // 很难复现 指令重排序造成 返回的对象是未初始化完成的对象
    @Test
    void testGetDoubleCheckInstance() throws InterruptedException {
        Thread[] threads = new Thread[100];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() ->{
                singleTon = SingleTon.getDoubleCheckInstance();
                if(singleTon.count != 100) System.out.println(singleTon.count);
            });
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }
    }

}
