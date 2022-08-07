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

        for (int i = 0; i < p.length(); i++) {
            need.put(p.charAt(i), need.getOrDefault(p.charAt(i), 0) + 1);
        }
        int left = 0, right = 0, valid = 0;
        List<Integer> list = new ArrayList<>();
        while (right < s.length()) {
            char r = s.charAt(right);
            right++;
            if (need.containsKey(r)) {
                window.put(r, window.getOrDefault(r, 0) + 1);
                if (window.get(r) == need.get(r)) {
                    valid++;
                }
            }
            while (right - left >= p.length()) {
                if (valid == need.size()) {
                    list.add(left);
                }
                char l = s.charAt(left);
                left++;
                if (need.containsKey(l)) {
                    if (window.get(l) == need.get(l)) {
                        valid--;
                    }
                    window.put(l, window.get(l) - 1);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        findAnagrams("baa", "aa");
    }
}
