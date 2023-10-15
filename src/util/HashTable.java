package util;

import exception.HashEmptyException;
import exception.NonexistentKeyException;

public class HashTable<K, V extends Comparable<V>> implements IHash<K, V> {

    private static final int INITIAL_CAPACITY = 16; // Initial capacity of the hash table
    private HashNode<K, V>[] list;
    private int size;

    public HashTable() {
        this.size = 0;
        list = new HashNode[INITIAL_CAPACITY];
    }

    @Override
    public void add(K key, V value) {
        if (size >= list.length * 0.75) {
            // If the load factor exceeds 0.75, resize the array.
            resize();
        }

        int index = hashFunction(key);
        HashNode<K, V> nodeAdd = new HashNode<K, V>(key, value);

        if (list[index] != null) {
            list[index].add(nodeAdd);
        } else {
            list[index] = nodeAdd;
            size++;
        }
    }

    @Override
    public boolean remove(K key) throws HashEmptyException, NonexistentKeyException {
        int index = hashFunction(key);
        boolean removed;
        if(isEmpty() ){
            throw new HashEmptyException("");
        }else {
            if(list[index] == null) {
                throw new NonexistentKeyException("");
            }else {
                if(list[index].getNext() == null) {
                    list[index] = null;
                    size--;
                    removed = true;
                }else {
                    list[index].removeLast();
                    removed = true;
                }
            }
        }
        return removed;
    }

    @Override
    public V search(K key) {
        int index = hashFunction(key);
        return list[index].getValue();
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private int hashFunction(K key) {
        int index = key.hashCode() % list.length;
        return index < 0 ? index + list.length : index;
    }

    private void resize() {
        int newCapacity = list.length * 2;
        HashNode<K, V>[] newList = new HashNode[newCapacity];

        for (HashNode<K, V> node : list) {
            if (node != null) {
                int index = hashFunction(node.getKey());
                newList[index] = node;
            }
        }

        list = newList;
    }
}



