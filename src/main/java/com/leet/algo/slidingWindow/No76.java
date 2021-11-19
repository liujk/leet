package com.leet.algo.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jkliu
 * @description
 * @create 2021-10-15 2:05 PM
 **/
public class No76 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0, valid = 0, start = 0, len = Integer.MAX_VALUE;

        for (Character c : t.toCharArray()) {
            add(need, c);
        }

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                add(window, c);
                if (need.get(c).equals(window.get(c))) {
                    valid++;
                }
            }

            while (valid == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (need.get(d).equals(window.get(d))) {
                        valid--;
                    }
                    subtract(window, d);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, len + start);
    }

    private static void add(Map<Character, Integer> map, Character c) {
        map.put(c, map.getOrDefault(c, 0) + 1);
    }

    private static void subtract(Map<Character, Integer> map, Character c) {
        map.put(c, map.getOrDefault(c, 0) - 1);
    }
}
