package util;

import model.Actions;

import java.util.EmptyStackException;

public interface StackInterface<T> {

    public boolean isEmpty();

    public void push(Actions<T>item) throws EmptyStackException;
    //public void push(T item, T item2, T item3) throws EmptyStackException;

    public Actions<T> top() throws EmptyStackException;

    public Actions<T> pop() throws EmptyStackException;


}
