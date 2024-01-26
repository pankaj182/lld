package org.neatcode;

import java.util.*;

public class MyHashMap<K, V> implements MyMap<K, V> {
    private static final double LOAD_FACTOR = 0.75;

    private static final int INITIAL_CAPACITY = 16;

    private List<EntryNode<K, V>> [] buckets;

    private int size;

    public MyHashMap() {
        this.buckets = new List[INITIAL_CAPACITY];
        this.size = 0;
    }


    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void put(K key, V value) {
        int index = getIndex(key);
        if (buckets[index] == null) {
            buckets[index] = new ArrayList<>();
        }
        for(EntryNode<K, V> node: buckets[index]) {
            if(node.getKey().equals(key)) {
                node.setValue(value);
                return;
            }
        }
        buckets[index].add(new EntryNode<>(key, value));
        size++;

        if (needsResize()) {
            resize();
        }
    }

    @Override
    public Optional<V> get(K key) {
        int index = getIndex(key);
        if(buckets[index] != null) {
            for(EntryNode<K, V> node: buckets[index]) {
                if(node.getKey().equals(key)) {
                    return Optional.of(node.getValue());
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public void remove(K key) {
        int index = getIndex(key);
        if (buckets[index] != null) {
            buckets[index].removeIf(entry -> entry.getKey().equals(key));
            size--;
        }
    }
    @Override
    public Set<K> keyset() {
        Set<K> result = new HashSet<>();
        for(List<EntryNode<K, V>> bucket: buckets) {
            if(bucket != null) {
                for(EntryNode<K, V> node: bucket) {
                    result.add(node.getKey());
                }
            }
        }
        return result;
    }

    @Override
    public List<V> values() {
        List<V> result = new ArrayList<>();
        for(List<EntryNode<K, V>> bucket: buckets) {
            if(bucket != null) {
                for(EntryNode<K, V> node: bucket) {
                    result.add(node.getValue());
                }
            }
        }
        return result;
    }

    @Override
    public Set<EntryNode<K, V>> entrySet() {
        Set<EntryNode<K,V>> result = new HashSet<>();
        for(List<EntryNode<K, V>> bucket: buckets) {
            if(bucket != null) {
                result.addAll(bucket);
            }
        }
        return result;
    }

    @Override
    public MyIterator<EntryNode<K, V>> iterator() {
        return new MyHashMapIterator(buckets);
    }

    private int getIndex(K key) {
        return key == null ? 0 : Math.abs(key.hashCode() % buckets.length);
    }

    private boolean needsResize() {
        return (double) size / buckets.length > LOAD_FACTOR;
    }

    private void resize() {
        int newCapacity = buckets.length * 2;
        List<EntryNode<K, V>>[] newBuckets = new ArrayList[newCapacity];

        for (List<EntryNode<K, V>> bucket : buckets) {
            if (bucket != null) {
                for (EntryNode<K, V> entry : bucket) {
                    int newIndex = entry.getKey() == null ? 0 : Math.abs(entry.getKey().hashCode() % newCapacity);
                    if (newBuckets[newIndex] == null) {
                        newBuckets[newIndex] = new ArrayList<>();
                    }
                    newBuckets[newIndex].add(entry);
                }
            }
        }
        buckets = newBuckets;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        entrySet().forEach(sb::append);
        return sb.toString();
    }
}
