package com.leet.jianzhioffer;

/**
 * @author jkliu
 * @description
 * @create 2022-03-17 3:58 PM
 **/
public class No22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode pre = new ListNode(0, head);
        ListNode fast = pre;
        ListNode slow = pre;
        while (k > 0) {
            fast = fast.next;
            k--;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow.next;
    }

    private static class ListNode {
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
