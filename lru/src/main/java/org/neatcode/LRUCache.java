package org.neatcode;

import java.util.Optional;

public interface LRUCache<K, V> {

    /**
     * @return value for given key if found
     */
    Optional<V> get(K key);

    /**
     * @return evicted Key if evicted
     */
    Optional<K> put(K key, V val);
}
