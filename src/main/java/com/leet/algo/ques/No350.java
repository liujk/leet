package com.leet.algo.ques;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author jkliu
 * @description
 * @create 2019-06-10 22:30
 **/
@Component
public class No350 implements BeanFactoryAware {
    private BeanFactory beanFactory;

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int maxLen = nums1.length < nums2.length ? nums1.length : nums2.length;
        int[] result = new int[maxLen];
        int k=0;
        for(int i=0,j=0; i<nums1.length && j<nums2.length;) {
            if (nums1[i] == nums2[j]) {
                result[k++] = nums1[i];
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        return Arrays.copyOf(result, k);
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sc = s.toCharArray();
        char[] st = t.toCharArray();
        Arrays.sort(sc);
        Arrays.sort(st);
        String scs = String.valueOf(sc);
        String sts = String.valueOf(st);
        if (scs.equals(sts)) {
            return true;
        }
        return false;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }
}
