package com.leet.algo.sort;

/**
 * @author jkliu
 * @description
 * @create 2022-08-06 5:28 PM
 **/
public class No148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        ListNode first = sortList(head);
        ListNode second = sortList(temp);

        ListNode pre = new ListNode(-1);
        ListNode res = pre;
        while (first != null && second != null) {
            if (first.val < second.val) {
                pre.next = first;
                first = first.next;
            } else {
                pre.next = second;
                second = second.next;
            }
            pre = pre.next;
        }
        pre.next = (first != null ? first : second);
        return res.next;
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
