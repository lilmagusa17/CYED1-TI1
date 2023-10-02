package model;

public class Actions<T> {

    private Actions<T> next;
    private Actions<T> prev;

    private T typeAction;
    private T taskOriginal;
    private T taskModified;

    public Actions(T typeAction, T taskOriginal) {
        this.typeAction = typeAction;
        this.taskOriginal = taskOriginal;
    }

    public Actions(T typeAction, T taskOriginal, T taskModified) {
        this.typeAction = typeAction;
        this.taskOriginal = taskOriginal;
        this.taskModified = taskModified;
    }

    public Actions<T> getNext() {
        return next;
    }

    public void setNext(Actions<T> next) {
        this.next = next;
    }

    public Actions<T> getPrev() {
        return prev;
    }

    public void setPrev(Actions<T> prev) {
        this.prev = prev;
    }

    public T getTypeAction() {
        return typeAction;
    }

    public void setTypeAction(T typeAction) {
        this.typeAction = typeAction;
    }

    public T getTaskOriginal() {
        return taskOriginal;
    }

    public void setTaskOriginal(T taskOriginal) {
        this.taskOriginal = taskOriginal;
    }

    public T getTaskModified() {
        return taskModified;
    }

    public void setTaskModified(T taskModified) {
        this.taskModified = taskModified;
    }
}
