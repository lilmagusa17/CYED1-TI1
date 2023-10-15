package util;

import exception.EmptyQueueException;

public interface QueueInt<T> {
    
    void enqueue(T data);
    T dequeue() throws EmptyQueueException;
    T peek() throws EmptyQueueException;
    boolean isEmpty();
    int size();
}

