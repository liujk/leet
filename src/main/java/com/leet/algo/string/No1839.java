package com.leet.algo.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jkliu
 * @description
 * @create 2022-07-24 11:41 AM
 **/
public class No1839 {
    public int longestBeautifulSubstring(String word) {
        if (word.length() < 5) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 0);
        map.put('e', 1);
        map.put('i', 2);
        map.put('o', 3);
        map.put('u', 4);

        int start = 0, end = 0, max = 0, n = word.length();
        char[] array = word.toCharArray();
        while (end < n - 1) {
            end++;
            if (array[start] == 'a' && (map.get(array[end - 1]) + 1 == map.get(array[end])
                    || map.get(array[end - 1]) == map.get(array[end]))) {
                if (array[end] == 'u') {
                    max = Integer.max(end - start + 1, max);
                }
            } else {
                start = end;
            }
        }
        return max;
    }

}
