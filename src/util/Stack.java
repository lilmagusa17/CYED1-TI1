package util;

import model.Actions;
import util.StackInterface;

import java.util.EmptyStackException;

public class Stack<T, V> implements StackInterface<T,V> {

    private Actions<T, V> head;
    private Actions<T, V> tail;

    @Override
    public void push(T typeAction,  V taskOriginal) throws EmptyStackException{
        Actions<T, V> node = new Actions<>(typeAction,  taskOriginal);

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

    public void push(T typeAction,  V taskOriginal, V taskModified) throws EmptyStackException{
        Actions<T, V> node = new Actions<>(typeAction, taskOriginal, taskModified);

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
    public Actions<T, V> top() throws EmptyStackException {
        if(head == null && tail == null){
            throw new EmptyStackException();
        }
        return tail;
    }

    @Override
    public Actions<T, V> pop() throws EmptyStackException {
        Actions<T, V> removeTail;
        Actions<T, V> prevTail;

        if (head == null){
            throw new EmptyStackException();
        }else {
            removeTail = tail;
            prevTail = tail.getPrev();
            setTail(null);
            if (prevTail == null){
                setHead(null);
            }
            tail=prevTail;
        }


        return removeTail;
    }

    public Actions<T, V> getHead() {
        return head;
    }


    public Actions<T, V> getTail() {
        return tail;
    }

    public void setHead(Actions<T, V> head) {
        this.head = head;
    }

    public void setTail(Actions<T, V> tail) {
        this.tail = tail;
    }
}
