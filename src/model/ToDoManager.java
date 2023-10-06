package model;

import exception.HashEmptyException;
import exception.NonexistentKeyException;
import util.HashTable;

import java.util.Calendar;

public class ToDoManager {

    private HashTable<String, TaskR> tasks;

    public ToDoManager() {
        tasks = new HashTable<String, TaskR>();

    }

    public void addTask(String title, String description, Calendar date, boolean priority) {
        TaskR task = new TaskR(title, description, date, priority);
        String id = task.getId();
        tasks.add(id, task);


    }


    public boolean removeTask(String id) throws NonexistentKeyException, HashEmptyException {

        boolean removed = false;
        if(!tasks.isEmpty()){
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

    public boolean isEmpty() {
        return tasks.isEmpty();
    }

    public int size() {
        return tasks.getSize();
    }

}
