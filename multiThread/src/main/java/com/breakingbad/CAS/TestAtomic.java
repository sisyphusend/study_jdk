package com.breakingbad.CAS;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class TestAtomic {
    @Test
    public void test1(){
        AtomicInteger atomicInteger = new AtomicInteger(1);
        int i = atomicInteger.incrementAndGet();
        System.out.println(i);
    }
}
