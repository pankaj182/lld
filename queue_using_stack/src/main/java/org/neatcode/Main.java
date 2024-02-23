package org.neatcode;

public class Main {
    public static void main(String[] args) {
        MyQueue q = new QueueUsingStack();
        q.offer(1);
        q.offer(2);
        q.offer(3);
        q.offer(4);
        System.out.println(q.poll()); // 1
        System.out.println(q.peek()); // 2
        System.out.println(q.empty()); // false
        q.offer(5);
        System.out.println(q.poll()); // 2
        System.out.println(q.peek()); // 3
        System.out.println(q.empty()); // false
    }
}