package com.breakingbad.threadpool;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class test {

    @Test
    public void testCreateCachedThreadPool(){
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                System.out.println(Thread.currentThread().getName());
                System.out.println(Thread.currentThread().getThreadGroup().getName());
            });
        }
    }
}
