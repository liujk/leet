package com.leet.algo.other;

/**
 * @author jkliu
 * @description
 * @create 2022-08-08 11:11 AM
 **/
public class No8 {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        s = s.trim();
        if (s == null || s.length() == 0) {
            return 0;
        }
        boolean positive = true;
        boolean sign = false;
        if (s.charAt(0) == '-') {
            positive = false;
            sign = true;
        } else if (s.charAt(0) == '+') {
            sign = true;
        }
        int i = sign ? 1 : 0;
        long res = 0;
        for (; i < s.length(); i++) {
            int elem = s.charAt(i) - '0';
            if (elem >= 0 && elem <= 9) {
                res = res * 10 + elem;
                if (res > Integer.MAX_VALUE) {
                    break;
                }
            } else {
                break;
            }
        }
        if (res > Integer.MAX_VALUE) {
            return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        return positive ? (int)res : (int) -res;
    }
}
