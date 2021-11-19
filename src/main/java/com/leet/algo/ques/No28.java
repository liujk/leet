package com.leet.algo.ques;

import org.springframework.stereotype.Component;

/**
 * @author jkliu
 * @description
 * @create 2019-06-05 21:55
 **/
@Component
public class No28 {
    public int strStr(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }
        if ("".equals(haystack) || haystack.length() < needle.length()) {
            return -1;
        }
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            int j = 0;
            for (; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == needle.length()) {
                return i;
            }
        }
        return -1;
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int len = 1;
        for (int k=1; k < nums.length; k++) {
            if (nums[len-1] != nums[k]) {
                nums[len++] = nums[k];
            }
        }
        return len;
    }
    //7,1,5,3,6,4

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int sum = 0;
        int importIndex = 0;
        boolean start = false;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i-1] > prices[i]) {
                if (start) {
                    sum = sum + prices[i - 1] - prices[importIndex];
                }
                importIndex = i;

            } else {
                start = true;
                 if (i == prices.length -1) {
                     sum = sum + prices[i] - prices[importIndex];
                 }
            }
        }
        return sum;
    }
}
