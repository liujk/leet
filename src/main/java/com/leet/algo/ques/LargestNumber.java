package com.leet.algo.ques;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author jkliu
 * @description
 * @create 2019-06-15 13:12
 **/
@Component
public class LargestNumber {
    public String largestNumber(int[] nums) {
        List<String> list = IntStream.of(nums).boxed().map(e -> String.valueOf(e)).collect(Collectors.toList());
        list.sort((o1, o2) -> {
            String first = o1 + o2;
            String second = o2 + o1;
            if (first.compareTo(second) > 0) {
                return -1;
            }
            return 1;
        });
        String result = list.stream().collect(Collectors.joining(""));
        if (result.charAt(0) == '0') {
            return "0";
        }
        return result;
    }
}
