package com.leet.algo.list;

import org.springframework.stereotype.Component;

/**
 * @author jkliu
 * @description
 * @create 2021-07-11 11:10 AM
 **/
@Component
public class No82 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.val == head.next.val && head.next.next == null) {
            return null;
        }
        ListNode pre = new ListNode(-127, head);
        ListNode prepre = new ListNode(-127, pre);
        ListNode result = prepre;
        ListNode cur = head;
        boolean rep = false;
        while (cur != null) {
            if (pre.val == cur.val) {
                rep = true;
                cur = cur.next;
                pre = pre.next;
            } else if (!rep) {
                prepre.next = pre;
                prepre = prepre.next;
                pre = pre.next;
                cur = cur.next;
            } else {
                cur = cur.next;
                pre = pre.next;
                rep = false;
            }

        }
        if (prepre.val == pre.val || rep) {
            prepre.next = null;
        } else {
            prepre.next = pre;
        }
        return result.next.next;
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
