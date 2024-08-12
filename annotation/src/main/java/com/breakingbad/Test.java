package com.breakingbad;

@TestAnnotation(num = 10)
public class Test {
    public static void main(String[] args) {
        // 生成代理类class文件 在 工作目录/com/sun/proxy/xx
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        TestAnnotation annotation = Test.class.getAnnotation(TestAnnotation.class);


        System.out.println(annotation.num());
    }
}
