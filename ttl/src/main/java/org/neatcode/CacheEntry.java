package org.neatcode;

public class CacheEntry<V> {
    private final V value;
    private final long expirationTime;

    public CacheEntry(V value, long expirationTime) {
        this.value = value;
        this.expirationTime = expirationTime;
    }

    public V getValue() {
        return value;
    }

    public boolean isValid() {
        return System.currentTimeMillis() < expirationTime;
    }
}
