package com.breakingbad;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestMatcher {

    // isMatch 是匹配 整个字符串序列
    @Test
    void testIsMatch(){
        String input = "abc123";

        Pattern pattern = Pattern.compile("a");
        Matcher matcher = pattern.matcher(input);

        boolean isMatch = matcher.matches();
        System.out.println("matches(): " + isMatch);
    }

    // find 是匹配  字符串序列 和 子字符串序列
    @Test
    void testFind(){
        String input = "abc123";

        Pattern pattern = Pattern.compile("a");
        Matcher matcher = pattern.matcher(input);

        boolean find = matcher.find();
        System.out.println("find(): " + find);
    }
}
