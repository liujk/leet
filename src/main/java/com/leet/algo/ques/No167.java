package com.leet.algo.ques;

import org.springframework.stereotype.Component;

/**
 * @author jkliu
 * @description
 * @create 2020-06-06 21:58
 **/
@Component
public class No167 {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i <= numbers.length/2; ) {
            for (int j = numbers.length - 1; j >i ; ) {
                if (target - numbers[i] == numbers[j]) {
                    int[] result = {i+1, j+1};
                    return result;
                } else if (target - numbers[i] > numbers[j]) {
                    i++;
                } else {
                    j--;
                }
            }
        }
        return new int[0];
    }
}
