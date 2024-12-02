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
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }
        int left = 0, right = 0, valid = 0, start = -1, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            char r = s.charAt(right);
            right++;
            if (need.containsKey(r)) {
                window.put(r, window.getOrDefault(r, 0) + 1);
                if (window.get(r).equals(need.get(r))) {
                    valid++;
                }
            }
            while (valid == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                char l = s.charAt(left);
                left++;
                if (need.containsKey(l)) {
                    if (window.get(l).equals(need.get(l))) {
                        valid--;
                    }
                    window.put(l, window.get(l) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

}
