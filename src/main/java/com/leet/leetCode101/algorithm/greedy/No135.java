package com.leet.leetCode101.algorithm.greedy;

/**
 * @description
 * @author jkliu
 * @create 2024-11-14 14:16
 **/
public class No135 {
    public int candy(int[] ratings) {
        int[] candy = new int[ratings.length];
        for (int i = 0; i < candy.length; i++) {
            candy[i] = 1;
        }
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            }
        }
        for (int i = ratings.length - 1; i > 0; i--) {
            if (ratings[i] < ratings[i - 1]) {
                candy[i - 1] = Integer.max(candy[i] + 1, candy[i - 1]);
            }
        }
        int sum = 0;
        for (int i = 0; i < candy.length; i++) {
            sum += candy[i];
        }
        return sum;
    }
}
