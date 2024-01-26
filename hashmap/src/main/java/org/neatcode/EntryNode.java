package org.neatcode;

import java.util.Objects;

public class EntryNode<K, V> {
    private K key;
    private V value;

    public EntryNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("{").append(key).append(":").append(value).append("}").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntryNode<?, ?> entryNode = (EntryNode<?, ?>) o;
        return Objects.equals(key, entryNode.key) && Objects.equals(value, entryNode.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }
}
