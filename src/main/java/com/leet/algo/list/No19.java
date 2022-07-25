package com.leet.algo.list;

/**
 * @author jkliu
 * @description
 * @create 2022-03-17 2:10 PM
 **/
public class No19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(-1, head);
        ListNode fast = head;
        ListNode slow = pre;
        for (int i = 1; i < n; i++) {
            fast = fast.next;
        }

        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
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
