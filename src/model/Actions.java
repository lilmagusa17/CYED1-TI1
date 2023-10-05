package model;

import util.HashNode;

public class Actions<T, K, V extends Comparable<V>> {

    private Actions<T, K, V> next;
    private Actions<T, K, V> prev;

    private T typeAction;
    private HashNode<K,V> taskOriginal;
    private HashNode<K,V> taskModified;

    public Actions(T typeAction, HashNode<K,V> taskOriginal) {
        this.typeAction = typeAction;
        this.taskOriginal = taskOriginal;
    }

    public Actions(T typeAction, HashNode<K,V> taskOriginal, HashNode<K,V> taskModified) {
        this.typeAction = typeAction;
        this.taskOriginal = taskOriginal;
        this.taskModified = taskModified;
    }

    public Actions<T,K, V> getNext() {
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

    public HashNode<K,V> getTaskOriginal() {
        return taskOriginal;
    }

    public void setTaskOriginal(HashNode<K,V> taskOriginal) {
        this.taskOriginal = taskOriginal;
    }

    public HashNode<K,V> getTaskModified() {
        return taskModified;
    }

    public void setTaskModified(HashNode<K,V> taskModified) {
        this.taskModified = taskModified;
    }


}
