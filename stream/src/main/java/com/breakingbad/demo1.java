package com.breakingbad;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class demo1 {
    public static void main(String[] args) {
        Stream<String> language = Stream.of("java","python","c");
        List<String> result = language.collect(Collectors.toList());

        Set<String> set = result.stream().collect(Collectors.toSet());

        int[] arr = new int[]{1,2,3,4,5};
        Arrays.stream(arr);
    }
}
