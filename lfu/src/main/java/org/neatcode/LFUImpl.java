package org.neatcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.PriorityQueue;

public class LFUImpl<K,V> implements LFU<K,V> {

    private final int capacity;
    private final Map<K, Integer> frequency;
    private final Map<K, V> storage;
    private final PriorityQueue<K> priorityQueue;

    public LFUImpl(int capacity) {
        this.capacity = capacity;
        this.frequency = new HashMap<>();
        this.storage = new HashMap<>();
        this.priorityQueue = new PriorityQueue<>((a, b) -> Integer.compare(frequency.get(a), frequency.get(b)));
    }

    @Override
    public Optional<V> get(K key) {
        if(storage.containsKey(key)) {
            frequency.put(key, frequency.get(key) + 1);
            return Optional.of(storage.get(key));
        }
        return Optional.empty();
    }

    @Override
    public void put(K key, V val) {
        // case 1. key is already present
        if(storage.containsKey(key)) {
            storage.put(key, val);
            frequency.put(key, frequency.get(key) + 1);
            return;
        }
        // case 2: key is absent
        // if we have exceeded capacity, evict first
        if(storage.size() >= capacity) {
            K keyToBeRemoved = priorityQueue.poll();
            System.out.println("Evicted Key: " + keyToBeRemoved);
            storage.remove(keyToBeRemoved);
            frequency.remove(keyToBeRemoved);
        }
        storage.put(key, val);
        frequency.put(key, 1);
        priorityQueue.offer(key);
    }

    @Override
    public void peekFrequency() {
        frequency.entrySet().forEach(System.out::print);
        System.out.println();
    }
}
