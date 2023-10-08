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

    public void addTask(String title, String description, Calendar date, int priority, String id) {
        boolean priorityB = false;
        switch (priority){
            case 1: priorityB = true;
            break;
            case 2: priorityB = false;
            break;

        }
        TaskR task = new TaskR(title, description, date, priorityB, id);
        tasks.add(id, task);


    }

    public void modifyTask(String id, String title, String description, Calendar date, boolean priority) throws Exception {
        TaskR task = searchTask(id);
        task.setTitle(title);
        task.setDescription(description);
        task.setLimitDate(date);
        task.setPriority(priority);
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
