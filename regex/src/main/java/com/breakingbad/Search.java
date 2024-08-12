package com.breakingbad;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Search {
    public static void main(String[] args) {
        String[] strings = {"abcd", "123abc456", "xyz", "abc123"};

        // 使用负向前瞻断言来排除包含 'abc' 的字符串
        Pattern pattern = Pattern.compile("^(?!.*abc).*$");

        for (String str : strings) {
            Matcher matcher = pattern.matcher(str);
            boolean isMatch = matcher.matches();
            String group = null;
            if(matcher.find()){
                group = matcher.group();
            }
            System.out.println("String: " + str + " - Matches: " + isMatch + " - Matches: " + group);
        }
    }
}
