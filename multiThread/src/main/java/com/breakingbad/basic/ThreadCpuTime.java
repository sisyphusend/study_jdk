package com.breakingbad.basic;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class ThreadCpuTime {
    // 查看线程使用cpu时间片多少
    public static void main(String[] args) throws InterruptedException {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        task();
        long[] threadIds = threadMXBean.getAllThreadIds();
        Thread.sleep(10000);
        for (long threadId : threadIds) {
            long cpuTime = threadMXBean.getThreadCpuTime(threadId);
            System.out.println("Thread ID: " + threadId + ", CPU Time: " + cpuTime);
        }
    }


    public static void task(){
        for (int i = 0; i < 32; i++) {
            new Thread(() -> {
                loop();
                System.out.println(Thread.currentThread().getName() + "--- 完成");
            }).start();
        }
    }

    public static void loop(){
        double randomDouble = Math.random();
        int millTime = (int)(randomDouble * 10 * 1000 + 11 * 1000);
        long startTime = System.currentTimeMillis();
        while (true){
            long endTime = System.currentTimeMillis();
            if(endTime - startTime > millTime) return;
        }
    }
}
