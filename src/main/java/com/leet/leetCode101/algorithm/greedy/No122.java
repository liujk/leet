package com.leet.leetCode101.algorithm.greedy;

/**
 * @description
 * @author jkliu
 * @create 2024-11-24 09:14
 **/
public class No122 {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int length = prices.length;
        int sum = 0, start = prices[0];
        for (int i = 1; i < length; i++) {
            if (prices[i - 1] > prices[i]) {
                sum += prices[i-1] - start;
                start = prices[i];
            }
            if (i == length - 1) {
                sum += prices[i] - start;
            }
        }
        return sum;
    }
}
