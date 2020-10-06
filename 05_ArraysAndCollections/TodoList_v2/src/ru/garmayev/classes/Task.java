package ru.garmayev.classes;

import java.util.ArrayList;

public class Task {
    private final static int STATUS_NEW = 0;
    private final static int STATUS_READ = 1;
    private final static int STATUS_COMPLETE = 2;

    private String title;
    private int status;

    public Task() {
        setStatus(Task.STATUS_NEW);
    }

    public Task(String title)
    {
        this();
        setTitle(title);
    }

    public void setStatus(int status)
    {
        this.status = status;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getTitle()
    {
        return this.title;
    }

    public String toString()
    {
        return getTitle();
    }
}
