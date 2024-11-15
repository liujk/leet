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
        char[] array = s.toCharArray();

        while (right < s.length()) {
            char rightChar = array[right];
            right++;
            window.put(rightChar, window.getOrDefault(rightChar, 0) + 1);

            while (window.get(rightChar) > 1) {
                char leftChar = array[left];
                left++;
                window.put(leftChar, window.get(leftChar) - 1);
            }
            maxLen = Integer.max(maxLen, right - left);
        }
        return maxLen;
    }
}
