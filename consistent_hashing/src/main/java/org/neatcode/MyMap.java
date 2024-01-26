package org.neatcode;

public interface MyMap<T> {

    void addNode(T node);

    T getNodeForKey(T key);

    void removeNode(T node);
}
