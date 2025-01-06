package com.leet.algo.binarySearch;

public class No367 {
    public boolean isPerfectSquare(int num) {
        int left = 0, right = num;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long midVal = mid * mid;
            if (midVal == num) {
                return true;
            } else if (midVal < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
