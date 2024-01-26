package org.neatcode;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface MyMap<K, V> {

    boolean isEmpty();

    int size();

    void put(K key, V value);

    Optional<V> get(K key);

    void remove(K key);

    Set<K> keyset();

    List<V> values();

    Set<EntryNode<K, V>> entrySet();

    MyIterator<EntryNode<K, V>> iterator();

}
