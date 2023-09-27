package util;

public interface IHash<K, V> {
    public void add(K key, V value);

    public boolean remove(K key);

    public V search(K key);

    public int getSize();

    public boolean isEmpty();
}
