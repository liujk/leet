package com.leet.algo.array;

/**
 * @author jkliu
 * @description
 * @create 2021-11-25 11:50 AM
 **/
public class No88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2.length == 0) {
            return;
        }
        if (nums1.length == nums2.length) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        int totalLength = m + n;
        int index1 = m - 1;
        int index2 = n - 1;
        for (int i = totalLength - 1; i >=0; i--) {
            if (index1 < 0) {
                nums1[i] = nums2[index2--];
                continue;
            }
            if (index2 < 0) {
                nums1[i] = nums1[index1--];
                continue;
            }
            if (nums1[index1] <= nums2[index2]) {
                nums1[i] = nums2[index2--];
            } else {
                nums1[i] = nums1[index1--];
            }
        }
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        int[] sorted = new int[m + n];
        int cur;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            sorted[p1 + p2 - 1] = cur;
        }
        for (int i = 0; i != m + n; ++i) {
            nums1[i] = sorted[i];
        }
    }
}
