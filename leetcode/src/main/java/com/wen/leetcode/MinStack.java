package com.wen.leetcode;

import java.util.Stack;

/**
 * @author huwenwen
 * @since 2019/9/16
 */
public class MinStack {

    private int min = Integer.MAX_VALUE;

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        if (x <= min) {
            minStack.push(x);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.pop() == min) {
            minStack.pop();
            min = minStack.isEmpty() ? Integer.MAX_VALUE : minStack.peek();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }

}
