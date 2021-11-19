package com.leet.algo.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jkliu
 * @description
 * @create 2021-10-05 5:18 PM
 **/
public class No567 {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (Character c : s1.toCharArray()) {
            add(need, c);
        }

        int left = 0, right = 0, valid = 0;
        char[] s2CharArray = s2.toCharArray();
        while (right < s2CharArray.length) {
            char c = s2CharArray[right];
            right++;
            if (need.containsKey(c)) {
                add(window, c);
                if (need.get(c).equals(window.get(c))) {
                    valid++;
                }
            }
            while (right - left >= s1.length()) {
                if (valid == need.size()) {
                    return true;
                }
                char d = s2CharArray[left];
                left++;
                if (need.containsKey(d)) {
                    if (need.get(c).equals(window.get(c))) {
                        valid--;
                    }
                    subtract(window, d);
                }
            }
        }
        return false;
    }

    private void add(Map<Character, Integer> map, Character c) {
        map.put(c, map.getOrDefault(c, 0) + 1);
    }

    private void subtract(Map<Character, Integer> map, Character c) {
        map.put(c, map.getOrDefault(c, 0) - 1);
    }
}
