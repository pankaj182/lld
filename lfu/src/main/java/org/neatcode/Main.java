package org.neatcode;

public class Main {
    public static void main(String[] args) {
        Cache<String, Integer> cacheCache = new LFUCache<>(3);
        cacheCache.put("A", 1);
        cacheCache.peekFrequency();

        cacheCache.put("A", 1);
        cacheCache.peekFrequency();

        cacheCache.put("B", 2);
        cacheCache.peekFrequency();

        cacheCache.put("C", 3);
        cacheCache.peekFrequency();

        System.out.println(cacheCache.get("C"));
        cacheCache.peekFrequency();

        cacheCache.put("A", 11);
        cacheCache.peekFrequency();

        cacheCache.put("D", 4);
        cacheCache.peekFrequency();

        cacheCache.put("E", 5);
        cacheCache.peekFrequency();

        System.out.println(cacheCache.get("A"));
        cacheCache.peekFrequency();
    }

    /*
     * Output for above operations
     * A=1
     * A=2
     * A=2B=1
     * A=2B=1C=1
     * Optional[3]
     * A=2B=1C=2
     * A=3B=1C=2
     * Evicted Key: B
     * A=3C=2D=1
     * Evicted Key: D
     * A=3C=2E=1
     * Optional[11]
     * A=4C=2E=1
     */
}