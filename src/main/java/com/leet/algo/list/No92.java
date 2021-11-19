package com.leet.algo.list;

import org.springframework.stereotype.Component;

/**
 * @author jkliu
 * @description
 * @create 2021-07-15 10:45 AM
 **/
@Component
public class No92 {
    public ListNode reverseBetween3(ListNode head, int left, int right) {
        if (left == 1) {
            return reverseN(head, right);
        }
        head.next = reverseBetween3(head.next, left - 1, right - 1);
        return head;
    }

    ListNode successor = null;

    public ListNode reverseN(ListNode head, int right) {
        if (right == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, right - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

    public ListNode reverseBetween1(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }
        ListNode letfNode = pre.next;
        ListNode suc = rightNode.next;

        pre.next = null;
        rightNode.next = null;

        reverse(letfNode);

        pre.next = rightNode;
        letfNode.next = suc;
        return dummy.next;
    }

    public ListNode reverseBetween2(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;

        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        for (int i = 0; i < right - left; i++) {
            ListNode temp = cur.next;
            cur.next = temp.next;
            ListNode temp2 = pre.next;
            pre.next = temp;
            temp.next = temp2;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;

            pre = cur;
            cur = temp;
        }
        return head;
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
