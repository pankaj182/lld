package org.neatcode;

import java.util.Optional;

public interface LFU<K, V> {
    Optional<V> get(K key);

    void put(K key, V val);

    /**
     * Just for demonstration purpose
     */
    void peekFrequency();
}
