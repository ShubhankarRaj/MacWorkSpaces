package com.learn.stack;

import java.util.Stack;

public class NewStack {
    Stack<Integer> A = new Stack();

    public void push(Integer i){
        A.push(new Integer(i));
    }

    public Integer pop(){
        return A.pop();
    }
}
