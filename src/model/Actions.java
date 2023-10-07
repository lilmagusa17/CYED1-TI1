package model;

import util.HashNode;

public class Actions<T, K, V> {

    private Actions<T, K, V> next;
    private Actions<T, K, V> prev;

    private T typeAction;

    private K key;
    private V taskOriginal;
    private V taskModified;

    public Actions(T typeAction, K key, V taskOriginal) {
        this.typeAction = typeAction;
        this.key = key;
        this.taskOriginal = taskOriginal;
    }

    public Actions(T typeAction, K key, V taskOriginal, V taskModified) {
        this.typeAction = typeAction;
        this.taskOriginal = taskOriginal;
        this.taskModified = taskModified;
    }

    public Actions<T, K, V> getNext() {
        return next;
    }

    public void setNext(Actions<T, K, V> next) {
        this.next = next;
    }

    public Actions<T, K, V> getPrev() {
        return prev;
    }

    public void setPrev(Actions<T, K, V> prev) {
        this.prev = prev;
    }

    public T getTypeAction() {
        return typeAction;
    }

    public void setTypeAction(T typeAction) {
        this.typeAction = typeAction;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
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
