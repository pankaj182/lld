package org.neatcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LRUCache<K, V> implements Cache<K, V> {
    private final Map<K, Node<K, V>> location;
    private final DoublyList<K, V> doublyList;

    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        location = new HashMap<>();
        doublyList = new DoublyList<>();
    }

    @Override
    public Optional<V> get(K key) {
        if(location.containsKey(key)) {
            Node<K, V> node = location.get(key);
            doublyList.moveToFront(node);
            return Optional.of(node.getVal());
        }
        return Optional.empty();
    }

    @Override
    public Optional<K> put(K key, V val) {
        K evictedKey = null;
        if (location.containsKey(key)) {
            Node<K, V> node = location.get(key);
            node.setVal(val);
            doublyList.moveToFront(node);
        } else {
            if (location.size() >= capacity) {
                // Evict the least recently used item
                Node<K, V> removedNode = doublyList.removeFromEnd();
                location.remove(removedNode.getKey());
                evictedKey = removedNode.getKey();
            }

            Node<K, V> newNode = new Node<>(key, val);
            location.put(key, newNode);
            doublyList.addToFront(newNode);
        }
        return Optional.ofNullable(evictedKey);
    }
}
