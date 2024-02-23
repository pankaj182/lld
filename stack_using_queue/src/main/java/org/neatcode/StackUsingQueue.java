package org.neatcode;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue implements MyStack {
    // basic approach is using Deque
    // other approach is using a single queue.

    // for pushing keep adding to queue,
    // for popping keep removing n-1 elements(& add back to queue), remove nth element
    private Queue<Integer> q;
    private Queue<Integer> tempQ;

    public StackUsingQueue() {
        this.q = new LinkedList();
        this.tempQ = new LinkedList();
    }

    @Override
    public void push(int x) {
        q.offer(x);
    }

    @Override
    public int pop() {
        while(q.size() > 1) {
            tempQ.offer(q.poll());
        }
        int res = q.poll();
        while(tempQ.size() > 0) {
            q.offer(tempQ.poll());
        }
        return res;
    }

    @Override
    public int top() {
        while(q.size() > 1) {
            tempQ.offer(q.poll());
        }
        int res = q.poll();
        while(tempQ.size() > 0) {
            q.offer(tempQ.poll());
        }
        q.offer(res);
        return res;
    }

    @Override
    public boolean empty() {
        return q.isEmpty();
    }
}
