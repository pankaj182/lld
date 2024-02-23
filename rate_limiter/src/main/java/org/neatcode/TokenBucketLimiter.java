package org.neatcode;

import java.time.Instant;

public class TokenBucketLimiter implements RateLimiter {

    private final int MAX_TOKENS;
    private final int REFILL_RATE;
    private long tokens;
    private Instant lastRefilledInstant;

    public TokenBucketLimiter(int maxCapacity, int refillRate) {
        this.MAX_TOKENS = maxCapacity;
        this.REFILL_RATE = refillRate;
        this.tokens = MAX_TOKENS;
        this.lastRefilledInstant = Instant.now();
    }

    @Override
    public boolean allowRequest() {
        refillTokens();
        if(tokens > 0) {
            tokens--;
            return true;
        }
        return false;
    }

    private void refillTokens() {
        Instant now = Instant.now();
        long elapsedSeconds = now.getEpochSecond() - lastRefilledInstant.getEpochSecond();
        long newTokens = REFILL_RATE * elapsedSeconds;

        if (newTokens > 0) {
            tokens = Math.min(tokens + newTokens, MAX_TOKENS);
            lastRefilledInstant = now;
        }
    }
}
