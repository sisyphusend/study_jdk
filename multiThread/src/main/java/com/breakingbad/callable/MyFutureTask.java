package com.breakingbad.callable;

/*
自己实现FutureTask功能 实现runnable
1. 线程执行完要有返回值

*/

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Callable;

public class MyFutureTask<V> {

    private TaskThread<V> taskThread;

    class TaskThread<V> extends Thread{
        private V result;

        private Callable<V> callable;

        public TaskThread(Callable callable) {
            this.callable = callable;
        }

        public void run(){
            try {
                result = callable.call();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        public V getResult(){return result;}
    }

    public MyFutureTask(Callable<V> callable) {
        taskThread = new TaskThread(callable);
    }

    public V get() throws Exception {
        taskThread.start();

        // 等待线程执行完成
        taskThread.join();
        return taskThread.getResult();
    }


    public static void main(String[] args) throws Exception {
        MyFutureTask<Integer> integerMyFutureTask = new MyFutureTask<Integer>(() -> {
            Thread.sleep(2000);
            return 100 + 100;
        });
        // 这个方法是阻塞的，执行完了在返回
        int result = integerMyFutureTask.get();
        System.out.println(result);
    }


}
