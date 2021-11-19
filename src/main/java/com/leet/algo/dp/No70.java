package com.leet.algo.dp;

/**
 * @author jkliu
 * @description
 * @create 2021-11-01 10:11 AM
 **/
public class No70 {
    public int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
