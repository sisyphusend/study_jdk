package com.breakingbad;


import com.breakingbad.inner.A;
import com.breakingbad.spi.Developer;
import com.sun.xml.internal.ws.addressing.WsaActionUtil;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

public class AppTest  {
    @Test
    public void test1() throws SQLException, FileNotFoundException, ClassNotFoundException {
//        System.out.println(System.getProperty("jdbc.drivers"));
//        System.out.println(System.getProperty("java.version"));
//        System.out.println(System.getProperty("os.name"));
//        DriverManager.setLogWriter(new PrintWriter("/home/sisyphus/test.txt"));
//        Class.forName("com.mysql.cj.jdbc.Driver");
        DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","root");

//        System.out.println(System.getSecurityManager());
    }

    @Test
    public void test2() throws IOException {
//        A a = new A();
//        A.B b = a.new B();
//        b.printAname();
//        A.B b1 =a.getB();
//        System.out.println(b == b1);
//        System.out.println(a.name);
//        System.out.println(b.name);
//        List<String> list = new ArrayList<>();
//        System.out.println(list.iterator().hasNext());
//        URL url =A.class.getClassLoader().getResource("META-INF/services/java.sql.Driver");
//        System.out.println(url.getHost());
//        System.out.println(url.getProtocol());
//        System.out.println(url.getContent());
//        System.out.println(url.getFile());
//
//        URL url2 = new URL("https://localhost:3306/mysql");
//
//
//        url.openStream();
        String s = A.class.getResource("/").getPath();
        System.out.println(s);

    }

    @Test
    public void testSPIDeveloper(){
        ServiceLoader<Developer> load = ServiceLoader.load(Developer.class);
        for(Developer developer:load){
            developer.coding();
        }

        load.forEach(Developer::coding);
    }


}
