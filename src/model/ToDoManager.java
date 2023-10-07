package model;

import exception.HashEmptyException;
import exception.NonexistentKeyException;
import util.HashTable;
import util.Stack;

import java.util.Calendar;

public class ToDoManager {

    private HashTable<String, TaskR> tasks;
    private Stack<String, String, TaskR> stackActions;

    public ToDoManager() {
        tasks = new HashTable<String, TaskR>();
        stackActions = new Stack<String, String, TaskR>();
    }

    public void addTask(String title, String description, Calendar date, boolean priority) {
        TaskR task = new TaskR(title, description, date, priority);
        String id = task.getId();
        tasks.add(id, task);
        pushAction("addTask", id, task);

    }


    public boolean removeTask(String id) throws Exception {

        boolean removed = false;
        if(!tasks.isEmpty()){
            pushAction("deleteTask", id, searchTask(id));
            removed = tasks.remove(id);
        }
        return removed;

    }

    public TaskR searchTask(String id) throws Exception{
        try{
            return tasks.search(id);
        } catch (Exception e) {
            throw new Exception("The task does not exist");
        }
    }

    public void pushAction(String typeAction, String id, TaskR task){
        stackActions.push(typeAction,id, task);
    }

    public boolean isEmptyStackActions(){
        return stackActions.isEmpty();
    }


    public boolean isEmpty() {
        return tasks.isEmpty();
    }

    public int size() {
        return tasks.getSize();
    }

}
