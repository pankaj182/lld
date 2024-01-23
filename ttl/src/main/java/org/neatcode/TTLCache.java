package org.neatcode;

import java.util.*;

public class TTLCache<K, V> implements Cache<K, V> {

    private final int ttl;
    private final Map<K, CacheEntry<V>> cache;
    private final Timer timer;

    public TTLCache(int ttl) {
        this.ttl = ttl;
        cache = new HashMap<>();
        timer = new Timer(true);
    }

    @Override
    public Optional<V> get(K key) {
        CacheEntry<V> entry = cache.get(key);
        if (entry != null && entry.isValid()) {
            return Optional.of(entry.getValue());
        } else {
            // Remove the expired entry
            cache.remove(key);
            return Optional.empty();
        }
    }

    @Override
    public void put(K key, V value) {
        putWithTTL(key, value); // Default TTL is 0 (no expiration)
    }

    @Override
    public void peekEntries() {
        cache.keySet().forEach(System.out::print);
        System.out.println();
    }

    private void putWithTTL(K key, V value) {
        // Remove the existing entry if present
        cache.remove(key);

        // Schedule the entry to be removed after the specified TTL
        CacheEntry<V> entry = new CacheEntry<>(value, System.currentTimeMillis() + ttl);
        cache.put(key, entry);

        // Schedule a timer task to remove the entry after TTL expiration
        if (ttl > 0) {
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    cache.remove(key);
                }
            }, ttl);
        }
    }
}
