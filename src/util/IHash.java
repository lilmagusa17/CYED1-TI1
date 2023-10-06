package util;

import exception.HashEmptyException;
import exception.NonexistentKeyException;

public interface IHash<K, V> {
    public void add(K key, V value);

    public boolean remove(K key) throws HashEmptyException, NonexistentKeyException;

    public V search(K key);

    public int getSize();

    public boolean isEmpty();
}
