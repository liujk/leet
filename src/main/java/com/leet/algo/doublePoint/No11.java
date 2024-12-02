package com.leet.algo.doublePoint;

/**
 * @description
 * @author jkliu
 * @create 2024-11-30 14:59
 **/
public class No11 {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, max = 0, leftHight = height[left], rightHeight = height[right];
        while (left < right) {
            if (height[left] < leftHight) {
                left++;
            }
            if (height[right] < rightHeight) {
                right--;
            }
            int tempMax = Math.min(height[left], height[right]) * (right - left);
            if (tempMax > max) {
                max = tempMax;
                leftHight = height[left];
                rightHeight = height[right];
            }
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

}
