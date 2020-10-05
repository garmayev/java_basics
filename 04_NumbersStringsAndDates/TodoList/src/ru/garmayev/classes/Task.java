package ru.garmayev.classes;

public class Task {
    private Status status;
    private String title;
    private String description;

    public Task() {
        this.setStatus(Status.NEW);
    }

    public Task(String title) {
        this();
        this.setTitle(title);
    }

    public Task(String title, String description) {
        this(title);
        this.setDescription(description);
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public String toString() {
        return "Task{status=" + this.status + ", title='" + this.title + "'}";
    }
}
