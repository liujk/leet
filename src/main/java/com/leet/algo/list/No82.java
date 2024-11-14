package com.leet.algo.list;

import org.springframework.stereotype.Component;

/**
 * @author jkliu
 * @description
 * @create 2021-07-11 11:10 AM
 **/
@Component
public class No82 {

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = new ListNode(0);
        ListNode res = pre;
        ListNode temp = new ListNode(Integer.MIN_VALUE);
        ListNode cur = head;
        boolean fit = false;
        while (cur != null) {
            if (temp.val != cur.val) {
                if (fit) {
                    pre.next = temp;
                    pre = pre.next;
                    pre.next = null;
                }
                temp = cur;
                fit = true;
            } else {
                fit = false;
            }
            cur = cur.next;
        }
        if (fit) {
            pre.next = temp;
        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode five = new ListNode(5);
        ListNode four2 = new ListNode(4, five);
        ListNode four1 = new ListNode(4, four2);
        ListNode three2 = new ListNode(3, four1);
        ListNode three1 = new ListNode(3, three2);
        ListNode two = new ListNode(2, three1);
        ListNode head = new ListNode(1, two);
        ListNode listNode = deleteDuplicates(head);
        int a = listNode.val;
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
