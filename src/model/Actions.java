package model;

import util.HashNode;

public class Actions<T, V> {

    private Actions<T, V> next;
    private Actions<T, V> prev;

    private T typeAction;


    private V taskOriginal;
    private V taskModified;

    public Actions(T typeAction,  V taskOriginal) {
        this.typeAction = typeAction;
        this.taskOriginal = taskOriginal;
    }

    public Actions(T typeAction, V taskOriginal, V taskModified) {
        this.typeAction = typeAction;
        this.taskOriginal = taskOriginal;
        this.taskModified = taskModified;
    }

    public Actions<T, V> getNext() {
        return next;
    }

    public void setNext(Actions<T, V> next) {
        this.next = next;
    }

    public Actions<T, V> getPrev() {
        return prev;
    }

    public void setPrev(Actions<T, V> prev) {
        this.prev = prev;
    }

    public T getTypeAction() {
        return typeAction;
    }

    public void setTypeAction(T typeAction) {
        this.typeAction = typeAction;
    }


    public V getTaskOriginal() {
        return taskOriginal;
    }

    public void setTaskOriginal(V taskOriginal) {
        this.taskOriginal = taskOriginal;
    }

    public V getTaskModified() {
        return taskModified;
    }

    public void setTaskModified(V taskModified) {
        this.taskModified = taskModified;
    }
}
