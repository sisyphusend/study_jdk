package com.breakingbad.callable;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.*;

public class CompletableFutureTest {

//    使用CompletableFuture默认的线程池
    @Test
    void test01(){
        int x = 20;
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(
                () -> {
                    System.out.println(x);
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return function01(x);
                }).thenAccept(result -> {
                    result = function01(result);
            System.out.println(result);
        });
        future.join();
    }
    static int function01(int x){
        return x*x;
    }

    // 多任务异步执行
    @Test
    void test02() throws ExecutionException, InterruptedException {
        ArrayList<CompletableFuture> futures = new ArrayList<>();
        HashMap<Object, Object> map = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return finalI * 2;
            }).whenComplete((result, throwable) -> {
                map.put(finalI, result);
            });
            futures.add(future);
        }
        CompletableFuture[] futureArray = futures.toArray(new CompletableFuture[0]);

        long start = System.currentTimeMillis();
        CompletableFuture.allOf(futureArray).get();
        long end = System.currentTimeMillis();
        System.out.println((end - start)/1000);
        System.out.println(map);
    }

    // 自定义线程池 获取返回值
    @Test
    void test03() throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CompletableFuture<String> future = CompletableFuture.supplyAsync(()
                -> runTask(), executorService);
        String s = future.get(2, TimeUnit.SECONDS);
        System.out.println(s);
    }

    static String runTask(){
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "taskResult";
    }

}
