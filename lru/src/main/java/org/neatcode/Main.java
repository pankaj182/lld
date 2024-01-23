package org.neatcode;

public class Main {
    public static void main(String[] args) {
        LRUCache<String, Integer> cache = new LRUCacheImpl<>(4);

        System.out.println(cache.put("A", 1).orElse("Nothing Evicted"));
        System.out.println(cache.put("B", 2).orElse("Nothing Evicted"));
        System.out.println(cache.put("C", 3).orElse("Nothing Evicted"));
        System.out.println(cache.get("A").orElse(-1));
        System.out.println(cache.put("D", 4).orElse("Nothing Evicted"));
        System.out.println(cache.put("E", 5).orElse("Nothing Evicted"));
        System.out.println(cache.put("F", 6).orElse("Nothing Evicted"));
        System.out.println(cache.put("B", 7).orElse("Nothing Evicted"));
    }
}