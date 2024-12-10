package com.leet.algo.doublePoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jkliu
 * @description
 * @create 2021-11-10 2:36 PM
 **/
public class No15 {

    /**
     * 采用双指针相向而行
     */
    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        if (length < 3) return ans;
        Arrays.sort(nums);
        for (int i = 0; i < length - 2; i++) {
            int val1 = nums[i];
            int target = -val1;
            if (i > 0 && val1 == nums[i - 1]) {
                continue;
            }
            int p2 = i + 1, p3 = length - 1;
            while (p2 < p3) {
                int val2 = nums[p2];
                int val3 = nums[p3];
                if (val2 + val3 < target) {
                    p2++;
                } else if (val2 + val3 > target) {
                    p3--;
                } else {
                    ans.add(Arrays.asList(val1, val2, val3));
                    while (p2 < p3 && nums[p2] == val2) {
                        p2++;
                    }
                    while (p2 < p3 && nums[p3] == val3) {
                        p3--;
                    }
                }
            }
        }
        return ans;
    }
}
