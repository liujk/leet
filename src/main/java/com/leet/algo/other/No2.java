package com.leet.algo.other;

import com.leet.algo.list.No21;

/**
 * @author jkliu
 * @description
 * @create 2022-08-07 10:54 AM
 **/
public class No2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int high = 0;
        while (l1 != null || l2 != null) {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;
            int sum = val1 + val2 + high;
            high = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            l1 = l1  != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        if (high > 0) {
            cur.next = new ListNode(high);
        }
        return pre.next;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
