package com.breakingbad.classload.demo1;

import java.lang.reflect.Method;

public class MyClassLoaderTest {
    public static void main(String args[]) throws Exception {

        MyClassLoader classLoader = new MyClassLoader ("D:\\codefield\\java\\study_jdk");
        Class clazz = classLoader.loadClass("com.breakingbad.classload.demo1.User");
        Object obj = clazz.newInstance();
        Method method = clazz.getDeclaredMethod("sout", null);
        method.invoke(obj, null);
        System.out.println(clazz.getClassLoader().getClass().getName());
    }
}

