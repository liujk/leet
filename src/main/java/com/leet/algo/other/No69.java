package com.leet.algo.other;

/**
 * @author jkliu
 * @description
 * @create 2022-07-06 4:16 PM
 **/
public class No69 {
    int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
