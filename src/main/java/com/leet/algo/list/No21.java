package com.leet.algo.list;

import org.springframework.stereotype.Component;

/**
 * @author jkliu
 * @description
 * @create 2021-07-11 10:11 AM
 **/
@Component
public class No21 {
    /**
     * 暴力解法
     *
     * 时间复杂度：O(M+N)
     * 空间复杂度O（1）
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode merged = new ListNode(-1, null);
        ListNode cur = merged;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return merged.next;
    }

    /**
     * 递归解法
     * 时间复杂度 O（M+N）
     * 空间复杂度 O（M+N）
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
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
