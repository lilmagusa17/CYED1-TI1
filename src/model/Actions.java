package model;

public class Actions<T> {

    private Actions next;
    private Actions prev;

    private T typeAction;
    private T taskOG;
    private T taskMod;

    public Actions(T typeAction, T taskOG) {
        this.typeAction = typeAction;
        this.taskOG = taskOG;
    }

    public Actions(T typeAction, T taskOG, T taskMod) {
        this.typeAction = typeAction;
        this.taskOG = taskOG;
        this.taskMod = taskMod;
    }

    public Actions getNext() {
        return next;
    }

    public void setNext(Actions next) {
        this.next = next;
    }

    public Actions getPrev() {
        return prev;
    }

    public void setPrev(Actions prev) {
        this.prev = prev;
    }

    public T getTypeAction() {
        return typeAction;
    }

    public void setTypeAction(T typeAction) {
        this.typeAction = typeAction;
    }

    public T getTaskOG() {
        return taskOG;
    }

    public void setTaskOG(T taskOG) {
        this.taskOG = taskOG;
    }

    public T getTaskMod() {
        return taskMod;
    }

    public void setTaskMod(T taskMod) {
        this.taskMod = taskMod;
    }
}
