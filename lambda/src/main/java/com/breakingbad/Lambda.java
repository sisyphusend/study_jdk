package com.breakingbad;

import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

public class Lambda {
    @Test
    public void testLambda1(){

    }

    // 用内部类方式，内部类的方法要引用外部类的变量，变量需要是final的，当变量不发生改变这是隐式声明的
    @Test
    public void testLambda2(){
        int a = 10;
        int finalA = a;
        class myconsumer implements Consumer<String>{

            @Override
            public void accept(String o) {
                System.out.println(o);
                System.out.println(finalA);
            }
        }
        a = a +1;
    }

}
