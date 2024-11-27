package com.leet.leetCode101.algorithm.greedy;

/**
 * @description
 * @author jkliu
 * @create 2024-11-23 10:36
 **/
public class No605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return false;
        }
        int left = n, total = flowerbed.length;
        for (int i = 0; i < total; i++) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == (total - 1) || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                left--;
                if (left == 0) {
                    return true;
                }
            }
        }
        return left == 0;
    }
}
