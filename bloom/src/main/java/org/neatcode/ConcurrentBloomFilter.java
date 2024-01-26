package org.neatcode;

import java.util.BitSet;
import java.util.Objects;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Function;
import java.util.concurrent.locks.Lock;

public class ConcurrentBloomFilter<T> implements BloomFilter<T> {

    private static final int DEFAULT_HASH_FUNCTIONS_COUNT = 3;
    private static final int DEFAULT_CAPACITY = 1 << 6;

    private final int hashFunctionsCount;
    private final int capacity;
    private final BitSet bitSet;

    private Function<T, Integer>[] hashFunctions;
    private final Lock lock;

    public ConcurrentBloomFilter() {
        this(DEFAULT_CAPACITY, DEFAULT_HASH_FUNCTIONS_COUNT);
    }

    public ConcurrentBloomFilter(int capacity, int hashFunctionsCount) {
        this.capacity = capacity;
        this.hashFunctionsCount = hashFunctionsCount;
        this.bitSet = new BitSet(capacity);
        this.lock = new ReentrantLock();
        this.hashFunctions = new Function[this.hashFunctionsCount];
        for(int i = 0; i < this.hashFunctionsCount; i++) {
            int finalI = i;
            hashFunctions[i] = s -> Objects.hashCode(s) ^ (finalI * 31);
        }
    }

    @Override
    public void add(T key) {
        lock.lock();
        try {
            for(Function<T, Integer> hashFunction: hashFunctions) {
                int hash = hashFunction.apply(key) % capacity;
                bitSet.set(hash, true);
            }
        } finally {
            lock.unlock();
        }

    }

    @Override
    public boolean contains(T key) {
        lock.lock();
        try {
            for (Function<T, Integer> hashFunction : hashFunctions) {
                int hash = hashFunction.apply(key) % capacity;
                if (!bitSet.get(hash)) {
                    return false;
                }
            }
            return true;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void delete(T key) {
        throw new UnsupportedOperationException("Delete unsupported in Simple Bloom Filters, Use Counting Bloom Filter");
    }
}
