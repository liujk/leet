package com.leet.algo.slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jkliu
 * @description
 * @create 2021-10-05 7:37 PM
 * baa
 * aa
 **/
public class No438 {
    public static List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (Character c : p.toCharArray()) {
            add(need, c);
        }
        int left = 0, right = 0, valid = 0;
        List<Integer> res = new ArrayList<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                add(window, c);
                if (need.get(c).equals(window.get(c))) {
                    valid++;
                }
            }
            while (right - left >= p.length()) {
                if (need.size() == valid) {
                    res.add(left);
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
        return res;
    }

    private static void add(Map<Character, Integer> map, Character c) {
        map.put(c, map.getOrDefault(c, 0) + 1);
    }

    private static void subtract(Map<Character, Integer> map, Character c) {
        map.put(c, map.getOrDefault(c, 0) - 1);
    }

    public static void main(String[] args) {
        findAnagrams("baa", "aa");
    }
}
