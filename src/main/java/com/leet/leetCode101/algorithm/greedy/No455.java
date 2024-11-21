package com.leet.leetCode101.algorithm.greedy;

import java.util.Arrays;

/**
 * @description
 * @author jkliu
 * @create 2024-11-14 14:16
 **/
public class No455 {
    public int findContentChildren(int[] g, int[] s) {
        if (g.length == 0 || s.length == 0) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        for (int x : s) {
            if (i < g.length && g[i] <= x) {
                i++;
            }
        }
        return i;
    }
}
