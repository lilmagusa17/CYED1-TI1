package model;

import util.StackInterface;

import java.util.EmptyStackException;

public class Stack<T> implements StackInterface<T> {

    private Actions<T> head;
    private Actions<T> tail;

    @Override
    public void push(T typeAction, T taskOriginal) throws EmptyStackException{
        Actions<T> node = new Actions<>(typeAction,taskOriginal);

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
    public void push(T typeAction, T taskOriginal, T taskModified) throws EmptyStackException{
        Actions<T> node = new Actions<>(typeAction,taskOriginal,taskModified);

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
        boolean isExists = false;
        if(head !=null){
            isExists = true;
        }
        return isExists;
    }

    @Override
    public Actions<T> top() throws EmptyStackException {
        return tail;
    }

    @Override
    public Actions<T> pop() throws EmptyStackException {

    }


    @Override
    public int search(T item) throws EmptyStackException {
        return 0;
    }
}
