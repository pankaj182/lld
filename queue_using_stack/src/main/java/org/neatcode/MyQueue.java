package org.neatcode;

public interface MyQueue {
    void offer(int x);

    int poll();

    int peek();

    boolean empty();
}
