package ru.garmayev.classes;

import java.util.ArrayList;

public class TodoList {
    protected ArrayList<Task> tasks;
    public Error error;
    public TodoList() {
        tasks = new ArrayList<>();
    }

    public TodoList(ArrayList<Task> taskArrayList) {
        this();
    }

    public boolean add(String title)
    {
        try {
            tasks.add(new Task(title));
            return true;
        } catch (Exception e) {
            this.error = new Error(e.getMessage(), 1);
            return false;
        }
    }

    public boolean add(int index, String title)
    {
        try {
            if ( index >= tasks.size() ) {
                tasks.add(new Task(title));
            } else {
                tasks.add(index, new Task(title));
            }
            return true;
        } catch (Exception e) {
            this.error = new Error(e.getMessage(), 1);
            return false;
        }
    }

    public boolean list()
    {
        if ( tasks.size() == 0 ) {
            this.error = new Error("Список пуст", 2);
            return false;
//            System.err.println("Список пуст");
        }

        int count = 0;
        for ( Task item : tasks)
        {
            System.out.printf("%02d - %s\n", count, item.toString());
            count++;
        }
        return true;
    }

    public boolean edit(int index, String title)
    {
        if ( tasks.size() > index ) {
            tasks.set(index, new Task(title));
            return true;
        } else {
            add(title);
        }
        this.error = new Error("Указанный индекс " + index + " неверен", 1);
        return false;
    }

    public boolean delete(int index)
    {
        if ( tasks.size() > index ) {
            tasks.remove(index);
            return true;
        }
        this.error = new Error("Указанный индекс неверен", 2);
        return false;
    }
}
