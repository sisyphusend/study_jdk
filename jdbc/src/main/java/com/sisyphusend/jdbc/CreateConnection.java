package com.sisyphusend.jdbc;

import com.mysql.cj.jdbc.Driver;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Properties;

// 创建connection的多种方式
public class CreateConnection {

    private Connection connection;
    private String url = "jdbc:mysql://localhost:3306/test";

    public void createConnection(String method) {
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "root");
        try {
            if(method.equals("create01")) create01(properties);
            if(method.equals("create02")) create02(properties);
            if(method.equals("create03")) create03(properties);
            if(method.equals("create04")) create04(properties);
            if(method.equals("create05")) create05(properties);
            System.out.println(connection);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    @Test
    void  testCreateConnection(){
//        createConnection("create01");
//        createConnection("create02");
//        createConnection("create03");
//        createConnection("create04");
        createConnection("create05");
    }

    // 直接用驱动程序中的 Driver实现类
    public void create01(Properties properties) throws SQLException {
        Driver driver = new Driver();
        connection = driver.connect(url, properties);
    }


    // 通过反射
    public void create02(Properties properties) throws Exception{
        Class<?> clazz = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) clazz.getDeclaredConstructor().newInstance();
        connection = driver.connect(url, properties);
    }


    // 将 driver 注册到 DriverManager
    public void create03(Properties properties) throws Exception {
        Class<?> clazz = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) clazz.getDeclaredConstructor().newInstance();
        DriverManager.registerDriver(driver);
        printDriverCount();
        connection = DriverManager.getConnection(url,properties);
    }

    // 调用 driver 的 静态代码块
    public void create04(Properties properties) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        printDriverCount();
        connection = DriverManager.getConnection(url,properties);
    }

    // 通过 SPI 机制，DriverManager 的静态代码块
    public void create05(Properties properties) throws Exception {
        printDriverCount();
        connection = DriverManager.getConnection(url,properties);
    }


    public void printDriverCount(){
        Enumeration<java.sql.Driver> drivers = DriverManager.getDrivers();
        int count = 0;
        while (drivers.hasMoreElements()){
            drivers.nextElement();
            count++;
        }
        System.out.println("driver 数量：" + count);
    }
}
