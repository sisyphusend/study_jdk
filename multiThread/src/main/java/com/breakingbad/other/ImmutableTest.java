package com.breakingbad.other;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ImmutableTest {
    @Test
    public void Test1(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                try {
                    System.out.println(dateFormat.parse("1996-08-16"));
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
    }
}
