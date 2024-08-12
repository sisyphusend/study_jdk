package com.breakingbad.callable;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* FutureTask api*/
public class TestFutureTask {
    // 单个线程绑定 FutureTask 对象
    @Test
    void test01() throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<Integer>(
                () -> {
                    System.out.println(Thread.currentThread().getName() + "---callable调用");
                    return 0;
                });
        new Thread(futureTask).start();
        System.out.println("结果是:" + futureTask.get());
    }

    // 线程池传入

}
