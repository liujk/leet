package com.leet.algo.other;

import java.util.HashSet;
import java.util.Set;

/**
 * @description
 * @author jkliu
 * @create 2024-12-06 17:27
 **/
public class No202 {
    public boolean isHappy(int n) {
        Set<Integer> existSet = new HashSet<>();
        while (n != 1) {
            int sum = 0;
            while (n != 0) {
                int digit = n % 10;
                sum += digit * digit;
                n = n / 10;
            }
            if (existSet.contains(sum)) {
                return false;
            }
            existSet.add(sum);
            n = sum;
        }
        return true;
    }
}
