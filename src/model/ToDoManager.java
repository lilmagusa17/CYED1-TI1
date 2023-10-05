package model;

import util.HashTable;

import java.util.Calendar;

public class ToDoManager {

    /*
    FR1. The program must allow to add tasks
    The program must allow to add the tasks and reminders
    Almacenar tareas y recordatorios: Utiliza una tabla hash para almacenar
    tareas y recordatorios. La clave podría ser un identificador único y el valor
    podría ser la información de la tarea/recordatorio. Cada entrada en la tabla hash
    podría tener la siguiente información: título, descripción, fecha límite, prioridad, etc.
    */
    private HashTable<String, TaskR> tasks;

    public ToDoManager() {
        tasks = new HashTable<String, TaskR>();

    }

    public void addTask(String title, String description, Calendar date, boolean priority, String id) {
        TaskR task = new TaskR(title, description, date, priority, id);
        tasks.add(id, task);
    }


    public boolean removeTask(String id) {
        return tasks.remove(id);
    }

    public TaskR searchTask(String id) {
        return tasks.search(id);
    }

    public boolean isEmpty() {
        return tasks.isEmpty();
    }

    public int size() {
        return tasks.getSize();
    }

}
