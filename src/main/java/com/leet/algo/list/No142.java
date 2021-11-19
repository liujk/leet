package com.leet.algo.list;

import org.springframework.stereotype.Component;

import java.util.HashSet;

/**
 * @author jkliu
 * @description
 * @create 2021-07-15 3:30 PM
 **/
@Component
public class No142 {
    public ListNode detectCycle(ListNode head) {
        HashSet set = new HashSet();
        while (head != null) {
            if (!set.add(head)) {
                return head;
            }
            head = head.next;
        }
        return null;
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
