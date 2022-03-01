package com.leet.algo.ques;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author jkliu
 * @description
 * @create 2022-02-19 6:49 PM
 **/
public class No232 {
    private Deque<Integer> queue;
    private Deque<Integer> temp;

    public No232() {
        queue = new LinkedList<>();
        temp = new LinkedList<>();
    }

    public void push(int x) {
        queue.push(x);
    }

    public int pop() {
        while (!queue.isEmpty()) {
            temp.push(queue.pop());
        }
        int elem = temp.pop();
        while (!temp.isEmpty()) {
            queue.push(temp.pop());
        }
        return elem;
    }

    public int peek() {
        while (!queue.isEmpty()) {
            temp.push(queue.pop());
        }
        int elem = temp.peek();
        while (!temp.isEmpty()) {
            queue.push(temp.pop());
        }
        return elem;
    }

    public boolean empty() {
       return queue.isEmpty();
    }
}
