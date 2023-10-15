package model;

import exception.HashEmptyException;
import exception.NonexistentKeyException;
import util.HashNode;
import util.HashTable;
import util.Stack;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ToDoManager {

    private HashTable<String, TaskR> tasks;
    private Stack<String, TaskR> stackActions;
    private ArrayList<TaskR> priorityTasks;
    private ArrayList<TaskR> nonPriorityTasks;
    
    public ToDoManager() {
        tasks = new HashTable<String, TaskR>();
        stackActions = new Stack<String, TaskR>();
        priorityTasks = new ArrayList<>();
        nonPriorityTasks = new ArrayList<>();
    }

    public void addTask(String title, String description, Calendar date, boolean isPriority, String id, boolean isMain) {
        TaskR task = new TaskR(title, description, date, isPriority, id);
        tasks.add(id, task);
        if (isMain) {
            pushAction("addTask", task);
        }
        if (isPriority) {
            priorityTasks.add(task);
        } else {
            nonPriorityTasks.add(task);
        }
    }

    public String displayTasks() {
        StringBuilder msg = new StringBuilder();
        priorityTasks.sort(Comparator.comparing(TaskR::getLimitDate));
        msg.append("Priority Tasks:\n");
        for (TaskR task : priorityTasks) {
            msg.append("Title: ").append(task.getTitle()).append("\n");
            msg.append("Date: ").append(task.getLimitDateFormatted()).append("\n");
            msg.append("Description: ").append(task.getDescription()).append("\n");
            msg.append("\n");
        }

        // Sort the non-priority tasks by date
        nonPriorityTasks.sort(Comparator.comparing(TaskR::getLimitDate));
        msg.append("Non-Priority Tasks:\n");
        for (TaskR task : nonPriorityTasks) {
            msg.append("Title: ").append(task.getTitle()).append("\n");
            msg.append("Date: ").append(task.getLimitDateFormatted()).append("\n");
            msg.append("Description: ").append(task.getDescription()).append("\n");
            msg.append("\n");
        }

    return msg.toString();
    }

    public void modifyTask(String id, String title, String description, Calendar date, boolean priority, boolean isMain) throws Exception {
        TaskR taskOriginal = new TaskR(searchTask(id).getTitle(), searchTask(id).getDescription(), searchTask(id).getLimitDate(), searchTask(id).getPriority(), id) ;

        TaskR taskModified = searchTask(id);
        taskModified.setTitle(title);
        taskModified.setDescription(description);
        taskModified.setLimitDate(date);
        taskModified.setPriority(priority);

        if (isMain){
            pushAction("modifyTask", id, taskOriginal, taskModified);
        }

    }

    public void modifyTask(int option, String id, String title, String description, Calendar date, boolean priority, boolean isMain) throws Exception {
        TaskR taskOriginal = new TaskR(searchTask(id).getTitle(), searchTask(id).getDescription(), searchTask(id).getLimitDate(), searchTask(id).getPriority(), id) ;


        TaskR taskModified = searchTask(id);

        if(option == 1){
            taskModified.setTitle(title);
        } else if (option == 2) {
            taskModified.setDescription(description);
        } else if (option == 3) {
            taskModified.setLimitDate(date);
        } else if (option == 4) {
            taskModified.setPriority(priority);
        }

        if (isMain){
            pushAction("modifyTask", id, taskOriginal, taskModified);
        }

    }



    public boolean removeTask(String id, boolean isMain) throws Exception {

        boolean removed = false;
        if(!tasks.isEmpty()){
            if (isMain){
                pushAction("deleteTask",  searchTask(id));
            }
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

    public void pushAction(String typeAction, TaskR task) {
        stackActions.push(typeAction, task);
    }

    public void pushAction(String typeAction, String id, TaskR task, TaskR taskModified) {
        stackActions.push(typeAction, task, taskModified);
    }


    public boolean isEmptyStackActions(){
        return stackActions.isEmpty();
    }

    public String undoAction() throws Exception {
        String msg = "";
        boolean actionsIsEmpty = isEmptyStackActions();



        if (actionsIsEmpty){
            msg = "No action has been taken";
        }else {
            String typeAction = stackActions.top().getTypeAction();
            String idTaskOriginal = stackActions.top().getTaskOriginal().getId();
            TaskR taskOriginal = stackActions.top().getTaskOriginal();

            if(typeAction.equals("addTask")){
                boolean isRemoved = removeTask(idTaskOriginal,false);
                if(isRemoved){
                    msg = "The task I recently added was removed\n"+"The task is: \n"+ taskOriginal;
                    stackActions.pop();
                }

            } else if (typeAction.equals("deletedTask")) {
                addTask(taskOriginal.getTitle(), taskOriginal.getDescription(), taskOriginal.getLimitDate(), taskOriginal.getPriority(), taskOriginal.getId(), false);
                msg = "The task I recently deleted was added\n"+"The task is: \n"+ taskOriginal;
                stackActions.pop();
            } else if (typeAction.equals("modifyTask")) {
                String idTaskModified = stackActions.top().getTaskModified().getId();
                TaskR taskModified = stackActions.top().getTaskModified();

                msg = "The changes I made earlier were reversed \n"+"The task modified is: \n"+taskModified + "\n\n The task original is: \n" + taskOriginal;
                modifyTask(idTaskModified, taskOriginal.getTitle(), taskOriginal.getDescription(), taskOriginal.getLimitDate(), taskOriginal.getPriority(), false);
                stackActions.pop();

            }
        }

        return msg;
    }


    public boolean isEmpty() {
        return tasks.isEmpty();
    }

    public int size() {
        return tasks.getSize();
    }

}
