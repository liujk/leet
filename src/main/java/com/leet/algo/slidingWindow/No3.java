package com.leet.algo.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jkliu
 * @description
 * @create 2021-10-06 9:28 AM
 **/
public class No3 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0, res = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            add(window, c);
            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                subtract(window, d);
            }
            res = Integer.max(res, right - left);
        }
        return res;
    }

    private static void add(Map<Character, Integer> map, Character c) {
        map.put(c, map.getOrDefault(c, 0) + 1);
    }

    private static void subtract(Map<Character, Integer> map, Character c) {
        map.put(c, map.getOrDefault(c, 0) - 1);
    }
}
