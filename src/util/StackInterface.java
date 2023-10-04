package util;

import model.Actions;

import java.util.EmptyStackException;

public interface StackInterface<T,K, V extends Comparable<V>> {

    public boolean isEmpty();

    public void push(Actions<T,K, V>item) throws EmptyStackException;
    //public void push(T item, T item2, T item3) throws EmptyStackException;

    public Actions<T, K, V> top() throws EmptyStackException;

    public Actions<T, K, V> pop() throws EmptyStackException;


}
