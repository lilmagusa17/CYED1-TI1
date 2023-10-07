package util;

import util.QueueInt;

//import java.util.EmptyQueueException;

public class Queue<T> implements QueueInt<T> {

    private class Node {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front; // Nodo del frente de la cola
    private Node rear;  // Nodo trasero de la cola
    private int size;   // Tamaño de la cola

    public Queue() {
        front = null;
        rear = null;
        size = 0;
    }

    @Override
    public void enqueue(T item) {
        Node newNode = new Node(item);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    @Override
    public T peek() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException("La cola está vacía.");
        }
        return front.data;
    }

    @Override
    public T dequeue() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException("La cola está vacía.");
        }
        T data = front.data;
        front = front.next;
        size--;
        if (isEmpty()) {
            rear = null; // If the queue is now empty, reset rear as well
        }
        return data;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
}
