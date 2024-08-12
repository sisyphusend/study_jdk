package com.breakingbad.hashcollision;

// 调整 String hashCode 中的系数 (31)
// 中文字典 英文字典  计算哈希碰撞的概率
public class StringHashCode {
    public static int hashCode(String s,int factor){
        return 0;
    }

    public static void main(String[] args) {
        String s = String.valueOf(0);
        System.out.println(s.hashCode());
        System.out.println(0 & 0xff);
    }
}
