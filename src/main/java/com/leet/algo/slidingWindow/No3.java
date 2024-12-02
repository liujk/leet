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
        int left = 0, right = 0, maxLen = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            right++;
            window.put(r, window.getOrDefault(r, 0) + 1);

            while (window.get(r) > 1) {
                char l = s.charAt(left);
                left++;
                window.put(l, window.getOrDefault(l, 0) - 1);
                if (window.get(r) == 1) {
                    maxLen = Integer.max(maxLen, right - left);
                }
            }
        }
        return maxLen;
    }
}
