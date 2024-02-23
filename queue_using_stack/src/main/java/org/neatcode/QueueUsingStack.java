package org.neatcode;

import java.util.Stack;

public class QueueUsingStack implements MyQueue {
    private Stack<Integer> offerStack;
    private Stack<Integer> pollStack;
    private boolean offerOp;
    public QueueUsingStack() {
        this.offerStack = new Stack();
        this.pollStack = new Stack();
    }

    @Override
    public void offer(int x) {
        if(!offerOp) {
            while(!pollStack.isEmpty()) {
                offerStack.push(pollStack.pop());
            }
            offerOp = !offerOp;
        }
        offerStack.push(x);
    }

    @Override
    public int poll() {
        if(pollStack.isEmpty() && offerStack.isEmpty()) {
            return -1;
        }
        if(offerOp) {
            while(!offerStack.isEmpty()) {
                pollStack.push(offerStack.pop());
            }
            offerOp = !offerOp;
        }
        return pollStack.pop();
    }

    @Override
    public int peek() {
        if(offerOp) {
            while(!offerStack.isEmpty()) {
                pollStack.push(offerStack.pop());
            }
            offerOp = !offerOp;
        }
        return pollStack.peek();
    }

    @Override
    public boolean empty() {
        return offerStack.isEmpty() && pollStack.isEmpty();
    }
}
