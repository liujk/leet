package com.leet.algo.dp;

/**
 * @author jkliu
 * @description
 * @create 2021-10-29 4:51 PM
 **/
public class No121 {
    //[7,1,5,3,6,4]
    public int maxProfit(int[] prices) {
        if (prices.length <=1) {
            return 0;
        }
        int max = 0;
        int pre = 0;
        for (int i = 1; i < prices.length; i++) {
            pre = Integer.max(0, pre + prices[i] - prices[i - 1]);
            max = Integer.max(pre, max);
        }
        return max;
    }
}
