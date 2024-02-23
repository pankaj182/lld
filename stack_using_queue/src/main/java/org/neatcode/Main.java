package org.neatcode;

public class Main {
    public static void main(String[] args) {
        MyStack stack = new StackUsingQueue();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.top()); // 4
        System.out.println(stack.pop()); // 4

        stack.push(5);
        System.out.println(stack.top()); // 5
    }
}