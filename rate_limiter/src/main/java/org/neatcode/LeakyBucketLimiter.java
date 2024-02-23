package org.neatcode;

import java.time.Instant;


public class LeakyBucketLimiter implements RateLimiter {
    private final int CAPACITY;
    private int tokens;
    private long lastLeakTime;
    private int leakRate;

    public LeakyBucketLimiter(int capacity, int leakRate) {
        this.CAPACITY = capacity;
        this.leakRate = leakRate;
        this.tokens = 0;
        this.lastLeakTime = Instant.now().getEpochSecond();
    }

    @Override
    public synchronized boolean allowRequest() {
        leakTokens();

        if (tokens < CAPACITY) {
            tokens++;
            return true;
        }

        return false;
    }

    private void leakTokens() {
        long now = Instant.now().getEpochSecond();
        long elapsedTime = now - lastLeakTime;
        int tokensToLeak = (int) (elapsedTime * leakRate);

        if (tokensToLeak > 0) {
            tokens = Math.max(tokens - tokensToLeak, 0);
            lastLeakTime = now;
        }
    }
}