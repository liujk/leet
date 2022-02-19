package com.leet.jianzhioffer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author jkliu
 * @description
 * @create 2022-02-10 4:03 PM
 **/
public class CQueue {
    private Deque<Integer> push;
    private Deque<Integer> temp;
    public CQueue() {
        push = new LinkedList<>();
        temp = new LinkedList<>();
    }

    public void appendTail(int value) {
        push.push(value);
    }

    public int deleteHead() {
        if (push.isEmpty()) {
            return -1;
        }
        while (!push.isEmpty()) {
            temp.push(push.pop());
        }
        Integer pop = temp.pop();
        while (!temp.isEmpty()) {
            push.push(temp.pop());
        }
        return pop;
    }
}
