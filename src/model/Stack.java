package model;

import util.StackInterface;

import java.util.EmptyStackException;

public class Stack<T,K, V extends Comparable<V>> implements StackInterface<T,K,V> {

    private Actions<T,K, V> head;
    private Actions<T, K, V> tail;

    @Override
    public void push(Actions<T,K,V>node) throws EmptyStackException{


        // list is empty
        if(this.head == null){
            this.head = node;
            this.tail = node;
        }
        // added to first position
        else {
            // connect node
            this.tail.setNext(node);
            node.setPrev(this.tail);
            // update
            this.tail = node;
        }
    }
    


    @Override
    public boolean isEmpty() {
        boolean isExists = true;
        if(head !=null){
            isExists = false;
        }
        return isExists;
    }

    @Override
    public Actions<T,K, V> top() throws EmptyStackException {
        if(head == null){
            throw new EmptyStackException();
        }
        return tail;
    }

    @Override
    public Actions<T,K, V> pop() throws EmptyStackException {
        Actions<T, K, V> removeTail;
        Actions<T, K, V> prevTail;

        if (head == null){
            throw new EmptyStackException();
        }else {
            removeTail = tail;
            prevTail = tail.getPrev();
            setTail(null);

            tail=prevTail;
        }


        return removeTail;
    }

    public Actions<T, K, V> getHead() {
        return head;
    }


    public Actions<T,K, V> getTail() {
        return tail;
    }

    public void setHead(Actions<T,K, V> head) {
        this.head = head;
    }

    public void setTail(Actions<T,K, V> tail) {
        this.tail = tail;
    }
}
