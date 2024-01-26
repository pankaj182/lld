package org.neatcode;

import java.util.List;

public class MyHashMapIterator<K, V> implements MyIterator<EntryNode<K,V>> {

    private int currentBucketIndex;
    private int currentEntryIndex;
    private List<EntryNode<K, V>> currentBucket;
    private List<EntryNode<K, V>> [] buckets;

    public MyHashMapIterator(List<EntryNode<K,V>>[] buckets) {
        this.currentBucketIndex = 0;
        this.currentEntryIndex = 0;
        this.buckets = buckets;
        this.currentBucket = getNextNonEmptyBucket();
    }

    @Override
    public boolean hasNext() {
        return currentBucket != null && currentEntryIndex < currentBucket.size();
    }

    @Override
    public EntryNode<K, V> next() {
        EntryNode<K, V> entry = currentBucket.get(currentEntryIndex++);
        if (currentEntryIndex >= currentBucket.size()) {
            currentBucket = getNextNonEmptyBucket();
            currentEntryIndex = 0;
        }
        return entry;
    }

    private List<EntryNode<K,V>> getNextNonEmptyBucket() {
        while(currentBucketIndex < buckets.length && (buckets[currentBucketIndex] == null || buckets[currentBucketIndex].isEmpty())) {
            currentBucketIndex++;
        }
        return (currentBucketIndex < buckets.length) ? buckets[currentBucketIndex++] : null;
    }
}
