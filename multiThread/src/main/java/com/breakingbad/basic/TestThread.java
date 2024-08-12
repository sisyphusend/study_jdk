package com.breakingbad.basic;

import org.junit.jupiter.api.Test;

// 创建线程的方式
public class TestThread {

    // 创建线程的写法
    @Test
    void test01(){
        // 实现Runnable接口 lambda 表达式
        new Thread(() -> System.out.println(Thread.currentThread().getName()),"线程1").start();

        // 实现Runnable接口 匿名内部类
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        },"线程2").start();

        // 实现Runnable接口
        class Run1 implements Runnable{
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }
        new Thread(new Run1(),"线程3").start();

        // 继承Thread
        class Thread1 extends Thread{
            public Thread1(String name) {
                super(name);
            }

            public void run(){
                System.out.println(this.getName());
            }
        }
        new Thread1("线程4").run();
    }

    // 创建一个对象即继承Thread方法并重写了run方法,又在构造器中传入参数有runnable对象,start是调用哪个方法?
    @Test
    void test02(){
        class Thread01 extends Thread {
            public Thread01(Runnable runnable){
                super(runnable);
            }
            public void run(){
                System.out.println(this.getName() + "运行重写的run方法");
            }
        }
        Thread01 thread01 = new Thread01(() -> System.out.println(Thread.currentThread().getName() + "运行 runnable 对象方法"));
        thread01.start();
        // 结果是 调用run方法 ，如果把run方法注释，调用的是runnable对象的方法
    }

    // 当线程没有用户线程，JVM会自动退出
    @Test
    void test03() throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName());
        });
        // 默认是用户线程
        System.out.println("创建默认线程是否是守护线程: " + thread.isDaemon());
        thread.setDaemon(true);
        thread.start();
        Thread.sleep(2000);
    }

    // yield 方法  让渡CPU时间片 线程状态还是 Runnable
    //



}
