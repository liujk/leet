package com.leet.algo.binarySearch;

public class No278 {
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            boolean result = isBadVersion(mid);
            if (result) {
               right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }

    private boolean isBadVersion(int version) {
        return true;
    }
}
