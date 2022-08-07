package com.leet.jianzhioffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jkliu
 * @description
 * @create 2022-07-26 3:54 PM
 **/
public class No48 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 1) {
            return 1;
        }
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
            }
            maxLen = Integer.max(maxLen, right - left);
        }
        return maxLen;
    }
}
