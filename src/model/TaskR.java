package model;

import java.util.Calendar;

public class TaskR implements Comparable<TaskR> {
    private String title;
    private String description;
    private Calendar limitDate;
    private boolean priority;
    private String id;

    public TaskR(String title, String description, Calendar date, boolean priority, String id) {
        this.title = title;
        this.description = description;
        this.limitDate = date;
        this.priority = priority;
        this.id = initId();
    }

    /**
     * This method auto-generates an id for the user
     * @return the id
     */
    public String initId(){
        StringBuilder id = new StringBuilder();
        for(int i = 0; i < 3; i++){
            id.append((char) (Math.random() * 26 + 'A'));
        }
        for(int i = 0; i < 3; i++){
            id.append((int) (Math.random() * 10));
        }
        return id.toString();
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Calendar getLimitDate() {
        return limitDate;
    }

    public boolean getPriority() {
        return priority;
    }

    public String getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLimitDate(Calendar limitDate) {
        this.limitDate = limitDate;
    }

    public void setPriority(boolean priority) {
        this.priority = priority;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TaskR{" + "title=" + title + ", description=" + description + ", date=" + limitDate + ", priority=" + priority + ", id=" + id + '}';
    }


    @Override
    public int compareTo(TaskR o) {
        return 0;
    }
}
