package org.neatcode;

public class Main {
    public static void main(String[] args) {
        LFU<String, Integer> lfuCache = new LFUImpl<>(3);
        lfuCache.put("A", 1);
        lfuCache.peekFrequency();

        lfuCache.put("A", 1);
        lfuCache.peekFrequency();

        lfuCache.put("B", 2);
        lfuCache.peekFrequency();

        lfuCache.put("C", 3);
        lfuCache.peekFrequency();

        System.out.println(lfuCache.get("C"));
        lfuCache.peekFrequency();

        lfuCache.put("A", 11);
        lfuCache.peekFrequency();

        lfuCache.put("D", 4);
        lfuCache.peekFrequency();

        lfuCache.put("E", 5);
        lfuCache.peekFrequency();

        System.out.println(lfuCache.get("A"));
        lfuCache.peekFrequency();
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