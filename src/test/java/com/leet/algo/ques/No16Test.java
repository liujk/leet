package com.leet.algo.ques; 

import com.leet.algo.AlgoApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

    @Test
    public void testThreeSumClosest() throws Exception {

        int[] nums = {-3, 2, 0, 9, 5, 1};
        int res = no16.threeSumClosest(nums, 7);
        Assert.assertEquals(7, res);
    }


} 
