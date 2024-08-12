package com.breakingbad.str;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class StrUtil {
    public static void main(String[] args) {
        // 获取默认字符编码
        Charset defaultCharset = Charset.defaultCharset();
        // 打印默认字符编码
        System.out.println("Default Charset: " + defaultCharset);
        // 获取系统属性 "file.encoding"
        String fileEncoding = System.getProperty("file.encoding");
        // 打印系统属性 "file.encoding"
        System.out.println("Default File Encoding: " + fileEncoding);
        // 写文件时显式指定 UTF-8 编码
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("output.txt"), StandardCharsets.UTF_8))) {
            writer.write("你好，世界！");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 读文件时显式指定 UTF-8 编码
        try (Reader reader = new BufferedReader(new InputStreamReader(new FileInputStream("output.txt"), StandardCharsets.UTF_8))) {
            int data;
            while ((data = reader.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void test01() {
        String str = "世界";
        // 使用指定的字符编码（UTF-8）将字符串转换为字节数组
        byte[] byteArray = str.getBytes(StandardCharsets.UTF_8);

        // 输出字节数组
        for (byte b : byteArray) {
            System.out.printf("%02x " ,b);
        }
    }

    @Test
    void test02() {
        // 示例 Unicode 码点 (😀)
        int codePoint = 0x1F600;

        // 将码点转换为字符串
        String str = new String(Character.toChars(codePoint));

        // 将字符串转换为 UTF-8 字节数组
        byte[] utf8Bytes = str.getBytes(StandardCharsets.UTF_8);

        // 打印 UTF-8 编码的字节
        for (byte b : utf8Bytes) {
            System.out.printf("0x%02X ", b);
        }
    }
}
