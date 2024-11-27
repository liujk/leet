package com.leet.leetCode101.algorithm.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * @description
 * @author jkliu
 * @create 2024-11-23 16:09
 **/
public class No763 {
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        int length = s.length();
        for (int i = 0; i < length; i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        List<Integer> partitions = new ArrayList<>();
        int end = 0, start = 0;
        for (int i = 0; i < length; i++) {
            end = Math.max(last[s.charAt(i) - 'a'], end);
            if (end == i) {
                partitions.add(end - start + 1);
                start = end + 1;
            }
        }
        return partitions;
    }
}
