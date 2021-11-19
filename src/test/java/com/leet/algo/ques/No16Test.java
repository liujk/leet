package com.leet.algo.ques;

import com.leet.algo.AlgoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.math.RoundingMode;

/** 
* No16 Tester. 
* 
* @author <Authors name> 
* @since <pre>May 5, 2019</pre> 
* @version 1.0 
*/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AlgoApplication.class)
public class No16Test {
    @Autowired
    No16 no16;
    @Autowired
    No31 no31;
    @Autowired
    No28 no28;
    @Autowired
    No350 no350;

    @Test
    public void testThreeSumClosest() throws Exception {
        no350.isAnagram("","");
//
//        int[] nums = {-3, 2, 0, 9, 5, 1};
//        int res = no16.threeSumClosest(nums, 7);
//        Assert.assertEquals(7, res);
    }

    @Test
    public void test() throws Exception {

        int[] nums = {1,3,2};
        no31.nextPermutation(nums);
        System.out.println(nums);
    }

    @Test
    public void test28() throws Exception {
//        Assert.assertEquals(-1,no28.strStr("Sfdgertq34gvsdvgq", "gv121sd"));
//        Assert.assertEquals(6,no28.strStr("Sfdgertq34gvsdvgq", "tq34gvs"));

        //[[1,4,7,11,15]
        // [2,5,8,12,19]
        // [3,6,9,16,22]
        // [10,13,14,17,24]
        // [18,21,23,26,30]]
        int nums1[] = {4,9,5};
        int nums2[] = {9,4,9,8,4};
//        System.out.println(no350.intersect(nums1, nums2));
//        no350.isAnagram("anagr\u1062am", "n\u1062agaram");
        BigDecimal magnification = new BigDecimal(12)
                .divide(new BigDecimal(11), 0, RoundingMode.CEILING);
        System.out.println(magnification.toPlainString());
        magnification = new BigDecimal(10)
                .divide(new BigDecimal(5), 0, RoundingMode.CEILING);
        System.out.println(magnification.toPlainString());

    }
} 
