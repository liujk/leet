package com.leet.jianzhioffer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author jkliu
 * @description
 * @create 2022-02-10 4:19 PM
 **/
public class MinStack {
    Deque<Integer> A, B;
    public MinStack() {
        A = new LinkedList<>();
        B = new LinkedList<>();
    }
    public void push(int x) {
        A.push(x);
        if(B.isEmpty() || B.peek() >= x) {
            B.push(x);
        }
    }
    public void pop() {
        if(A.pop().equals(B.peek())) {
            B.pop();
        }
    }
    public int top() {
        return A.peek();
    }
    public int min() {
        return B.peek();
    }
}
