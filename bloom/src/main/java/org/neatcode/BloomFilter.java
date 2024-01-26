package org.neatcode;

public interface BloomFilter<T> {
    void add(T key);

    boolean contains(T key);

    void delete(T key);
}
