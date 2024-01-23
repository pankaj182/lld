package org.neatcode;

public interface RandomSet<T> {
    boolean insert(T data);
    boolean delete(T data);

    public T getRandom();
}
