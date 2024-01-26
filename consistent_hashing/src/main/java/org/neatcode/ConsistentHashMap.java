package org.neatcode;

import java.util.Objects;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.function.Function;

public class ConsistentHashMap<T> implements MyMap<T> {

    private static final int DEFAULT_REPLICAS = 3;
    private final SortedMap<Integer, T> circle;
    private final int numberOfReplicas;

    private final Function<T, Integer>[] hashFunctions;

    public ConsistentHashMap() {
        this(DEFAULT_REPLICAS);
    }

    public ConsistentHashMap(int numberOfReplicas) {
        this.numberOfReplicas = numberOfReplicas;
        this.circle = new TreeMap();
        this.hashFunctions = new Function[this.numberOfReplicas];
        for(int i = 0; i < this.numberOfReplicas; i++) {
            int finalI = i;
            hashFunctions[i] = s -> Objects.hashCode(s.toString() + finalI);
        }
    }

    // Adds a node to the hash circle
    public void addNode(T node) {
        for (Function<T, Integer> hashFunction: hashFunctions) {
            int hash = hashFunction.apply(node);
            circle.put(hash, node);
        }
    }

    // Removes a node from the hash circle
    public void removeNode(T node) {
        for (Function<T, Integer> hashFunction: hashFunctions) {
            int hash = hashFunction.apply(node);
            circle.remove(hash);
        }
    }

    // Finds the node responsible for the given key
    public T getNodeForKey(T key) {
        if (circle.isEmpty()) {
            return null;
        }

        int hash = Objects.hash(key);
        if (!circle.containsKey(hash)) {
            // Find the next node in the circle
            SortedMap<Integer, T> tailMap = circle.tailMap(hash);
            hash = tailMap.isEmpty() ? circle.firstKey() : tailMap.firstKey();
        }
        return circle.get(hash);
    }
}

