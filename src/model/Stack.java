package model;

import util.StackInterface;

import java.util.EmptyStackException;

public class Stack<T> implements StackInterface<T> {

    private Actions<T> head;
    private Actions<T> tail;

    @Override
    public void push(T typeAction, T taskOG) throws EmptyStackException{
        Actions<T> node = new Actions<>(typeAction,taskOG);

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
    public void push(T typeAction, T taskOG, T taskMod) throws EmptyStackException{
        Actions<T> node = new Actions<>(typeAction,taskOG,taskMod);

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
        return false;
    }




    @Override
    public T top() throws EmptyStackException {
        return null;
    }

    @Override
    public T pop() throws EmptyStackException {
        return;
    }


    @Override
    public int search(T item) throws EmptyStackException {
        return 0;
    }
}
