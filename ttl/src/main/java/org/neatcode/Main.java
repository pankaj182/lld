package org.neatcode;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Cache<String, Integer> ttlCache = new TTLCache<>(1000);

        ttlCache.put("A", 1);
        ttlCache.peekEntries();

        Thread.sleep(500);
        ttlCache.peekEntries();

        ttlCache.put("B", 2);
        ttlCache.peekEntries();

        ttlCache.put("C", 3);
        ttlCache.peekEntries();

        Thread.sleep(500);
        ttlCache.peekEntries();

        ttlCache.put("A", 1);
        ttlCache.peekEntries();

        Thread.sleep(500);
        ttlCache.peekEntries();

        /*
         * Output for given operations:
         * A
         * A
         * AB
         * ABC
         * BC
         * ABC
         * A
         */
    }
}