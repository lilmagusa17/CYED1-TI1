package util;

import model.Actions;

import java.util.EmptyStackException;

public interface StackInterface<T,K, V> {

    public boolean isEmpty();

    public void push(T typeAction, K id, V taskOriginal) throws EmptyStackException;

    public Actions<T, K, V> top() throws EmptyStackException;

    public Actions<T, K, V> pop() throws EmptyStackException;


}
