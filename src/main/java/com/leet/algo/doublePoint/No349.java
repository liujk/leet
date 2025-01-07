package com.leet.algo.doublePoint;

import java.util.Arrays;

/**
 * @description
 * @author jkliu
 * @create 2024-12-07 10:33
 **/
public class No349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0, j=0, p = 0;
        int[] result = new int[nums1.length];
        while (i<nums1.length && j<nums2.length) {
            if (nums1[i] == nums2[j]) {
                result[p] = nums1[i];
                i++;
                j++;
                p++;
                while (i<nums1.length && nums1[i] == nums1[i-1]) {
                    i++;
                }
                while (j<nums2.length && nums2[j] == nums2[j-1]) {
                    j++;
                }
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return Arrays.copyOf(result, p);
    }
}
