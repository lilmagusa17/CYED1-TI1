package model;

import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class TaskR implements Comparable<TaskR> {
    private String title;
    private String description;
    private Calendar limitDate;
    private boolean priority;
    private String id;
    private DateFormat formatter;
    

    public TaskR(String title, String description, Calendar date, boolean priority, String id) {
        this.title = title;
        this.description = description;
        this.limitDate = date;
        this.priority = priority;
        this.id = id;
        this.formatter = new SimpleDateFormat("dd/MM/yyyy");
    }

    public String getLimitDateFormatted() {
        return formatter.format(this.limitDate.getTime());
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
        return  " Title=" + title + "\n Description=" + description + "\n Date=" + getLimitDateFormatted() + "\n Priority=" + priority + "\n id=" + id ;
    }


    @Override
    public int compareTo(TaskR o) {
        return 0;
    }
}
