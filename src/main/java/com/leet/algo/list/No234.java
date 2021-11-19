package com.leet.algo.list;

import java.util.List;
import java.util.Stack;

/**
 * @author jkliu
 * @description
 * @create 2021-11-08 2:30 PM
 **/
public class No234 {
    public boolean isPalindrome(No92.ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        No92.ListNode cur = head;
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }
        while (head != null && head.val == stack.peek().intValue()) {
            stack.pop();
            head = head.next;
        }
        return stack.isEmpty();
    }
}
