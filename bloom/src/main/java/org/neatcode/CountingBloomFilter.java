package org.neatcode;

import java.util.function.Function;

public class CountingBloomFilter<T> implements BloomFilter<T> {

    private static final int DEFAULT_CAPACITY = 1 << 6;
    private static final int DEFAULT_HASH_FUNCTIONS_COUNT = 3;

    private final int capacity;
    private final int hashFunctionsCount;
    private final Function<T, Integer>[] hashFunctions;
    private final int[] counter;

    public CountingBloomFilter() {
        this(DEFAULT_CAPACITY, DEFAULT_HASH_FUNCTIONS_COUNT);
    }

    public CountingBloomFilter(int capacity, int hashFunctionsCount) {
        this.capacity = capacity;
        this.hashFunctionsCount = hashFunctionsCount;
        this.counter = new int[capacity];
        this.hashFunctions = new Function[hashFunctionsCount];
        for(int i = 0; i< hashFunctionsCount; i++) {
            int finalI = i;
            this.hashFunctions[i] = s -> s.hashCode() ^ (finalI * 31);
        }
    }

    @Override
    public void add(T key) {
        for(Function<T, Integer> hashFunction: hashFunctions) {
            int hash = hashFunction.apply(key) % capacity;
            this.counter[hash] += 1;
        }
    }

    @Override
    public boolean contains(T key) {
        for(Function<T, Integer> hashFunction: hashFunctions) {
            int hash = hashFunction.apply(key) % capacity;
            if(counter[hash] <= 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void delete(T key) {
        for(Function<T, Integer> hashFunction: hashFunctions) {
            int hash = hashFunction.apply(key) % capacity;
            if (counter[hash] > 0) {
                counter[hash]--;
            }
        }
    }
}
