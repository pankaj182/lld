package org.neatcode;

import java.time.Instant;
import java.util.ArrayDeque;
import java.util.Queue;

public class SlidingWindowLimiter implements RateLimiter {
    private int rateLimit;
    private int windowSizeInSeconds;
    private Queue<Long> requestQueue;

    public SlidingWindowLimiter(int rateLimit, int windowSizeInSeconds) {
        this.rateLimit = rateLimit;
        this.windowSizeInSeconds = windowSizeInSeconds;
        this.requestQueue = new ArrayDeque<>();
    }

    public synchronized boolean allowRequest() {
        long currentTime = Instant.now().getEpochSecond();
        long windowStartTime = currentTime - windowSizeInSeconds + 1;

        if (requestQueue.size() < rateLimit) {
            requestQueue.add(currentTime);
            return true;
        } else if (requestQueue.peek() >= windowStartTime) {
            return false;
        } else {
            requestQueue.poll();
            requestQueue.add(currentTime);
            return true;
        }
    }
}
