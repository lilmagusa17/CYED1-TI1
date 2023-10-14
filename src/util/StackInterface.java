package util;

import model.Actions;

import java.util.EmptyStackException;

public interface StackInterface<T, V> {

    public boolean isEmpty();

    public void push(T typeAction, V taskOriginal) throws EmptyStackException;

    public Actions<T, V> top() throws EmptyStackException;

    public Actions<T, V> pop() throws EmptyStackException;


}
