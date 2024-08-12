package com.breakingbad.basic;

import org.junit.jupiter.api.Test;

public class TestDaemon {
    // 当线程没有用户线程，JVM会自动退出
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{

            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(i);
            }
        });
        t1.setDaemon(false);
        t1.start();
        Thread.sleep(500);
        printAllThreadInfo();

    }
    public static void printAllThreadInfo(){
        ThreadGroup group = Thread.currentThread().getThreadGroup();
        ThreadGroup topgroup = group;
        while (group != null){
            topgroup = group;
            group = group.getParent();
        }
        int count = topgroup.activeCount();
        Thread[] threads = new Thread[count];
        topgroup.enumerate(threads);
        for(Thread t : threads){
            System.out.println("线程名称:" + t.getName() + "\t\t\t线程是否是守护线程:" + t.isDaemon());
        }
    }

//    在测试环境就会失效
    @Test
    public void testMain() throws InterruptedException {
        main(null);
    }
}
